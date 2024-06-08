package br.com.fiap.seareport.controller;

import br.com.fiap.seareport.dto.request.AvaliationMonitorRequest;
import br.com.fiap.seareport.dto.response.AvaliationMonitorResponse;
import br.com.fiap.seareport.exception.ResourceNotFoundException;
import br.com.fiap.seareport.service.AvaliationMonitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliationMonitor {

    @Autowired
    private AvaliationMonitorService service;

    @Transactional
    @PostMapping
    public ResponseEntity<AvaliationMonitorResponse> save(@RequestBody @Valid AvaliationMonitorRequest request) {
        var saved = service.save(request);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(service.toResponse(saved));
    }

    @GetMapping("/user/{userId}/monitoramento/{monitoramentoId}")
    public ResponseEntity<AvaliationMonitorResponse> findByIdUserAndIdMonitoramento(
            @PathVariable Long userId,
            @PathVariable Long monitoramentoId
    ) {
        var avaliacao = service.findByIdUserAndIdMonitoramento(userId, monitoramentoId);
        if (Objects.isNull(avaliacao)) throw new ResourceNotFoundException("Avaliação does not exist");

        return ResponseEntity.ok(service.toResponse(avaliacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAvaliacao(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deleted");
    }

}
