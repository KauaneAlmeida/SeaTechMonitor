package br.com.fiap.seareport.service;

import br.com.fiap.seareport.dto.request.MonitoramentoPostRequest;
import br.com.fiap.seareport.dto.response.MonitoramentoPostResponse;
import br.com.fiap.seareport.entity.MonitoramentoPost;
import br.com.fiap.seareport.repository.MonitoramentoPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class MonitoramentoPostService implements ServiceDTO<MonitoramentoPost, MonitoramentoPostRequest, MonitoramentoPostResponse, Long> {

    @Autowired
    private MonitoramentoPostRepository repo;

    @Override
    public MonitoramentoPost toEntity(MonitoramentoPostRequest request) {
        if (Objects.isNull(request)) return null;
        return MonitoramentoPost.builder()
                .contentPost(request.getContentPost())
                .date(LocalDateTime.now())
                .build();
    }

    @Override
    public MonitoramentoPostResponse toResponse(MonitoramentoPost entity) {
        if (Objects.isNull(entity)) return null;
        return MonitoramentoPostResponse.builder()
                .id(entity.getId())
                .contentPost(entity.getContentPost())
                .date(entity.getDate())
                .build();
    }

    @Override
    public List<MonitoramentoPost> findAll() {
        return repo.findAll();
    }

    @Override
    public List<MonitoramentoPost> findAll(Example<MonitoramentoPost> example) {
        return repo.findAll(example);
    }

    @Override
    public MonitoramentoPost findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public MonitoramentoPost save(MonitoramentoPostRequest request) {
        return repo.save(toEntity(request));
    }
}
