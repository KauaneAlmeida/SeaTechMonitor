package br.com.fiap.seareport.controller;

import br.com.fiap.seareport.dto.request.MonitoramentoPostRequest;
import br.com.fiap.seareport.dto.response.MonitoramentoPostResponse;
import br.com.fiap.seareport.entity.MonitoramentoPost;
import br.com.fiap.seareport.exception.ResourceNotFoundException;
import br.com.fiap.seareport.service.MonitoramentoPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/monitoramento-post")
public class MonitoramentoPostController {

    @Autowired
    private MonitoramentoPostService service;

    @Transactional
    @PostMapping
    public ResponseEntity<MonitoramentoPostResponse> save(@RequestBody MonitoramentoPostRequest request) {
        var saved = service.save(request);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(service.toResponse(saved));
    }

    @GetMapping
    public ResponseEntity<Page<MonitoramentoPostResponse>> findAll(
            @RequestParam(name = "word", required = false) String word,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        var monitoramentoPost = MonitoramentoPost.builder()
                .contentPost(word)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withMatcher("contentPost", match -> match.contains());

        Example<MonitoramentoPost> example = Example.of(monitoramentoPost, matcher);

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "contentPost");

        var monitoramentoPosts = service.findAll(example)
                .stream()
                .map(service::toResponse)
                .toList();

        if (Objects.isNull(monitoramentoPosts) || monitoramentoPosts.isEmpty()) {
            throw new ResourceNotFoundException("Monitoramento Post not found");
        }

        Page<MonitoramentoPostResponse> pagina = new PageImpl<>(monitoramentoPosts, pageable, monitoramentoPosts.size());

        return ResponseEntity.ok(pagina);
    }
}
