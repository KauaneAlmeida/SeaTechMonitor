package br.com.fiap.seareport.service;

import br.com.fiap.seareport.dto.request.AvaliationMonitorRequest;
import br.com.fiap.seareport.dto.response.AvaliationMonitorResponse;
import br.com.fiap.seareport.entity.AlertMonitor;
import br.com.fiap.seareport.entity.AvaliationMonitor;
import br.com.fiap.seareport.entity.User;
import br.com.fiap.seareport.repository.AvaliationMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AvaliationMonitorService implements ServiceDTO<AvaliationMonitor, AvaliationMonitorRequest, AvaliationMonitorResponse, Long> {

    @Autowired
    private AvaliationMonitorRepository repo;
    @Autowired
    private UserService userService;
    @Autowired
    private AvaliationMonitorService monitoramentoService;

    @Override
    public AvaliationMonitor toEntity(AvaliationMonitorRequest request) {
        if (Objects.isNull(request)) return null;
        User user = userService.findById(request.getUserId());
        Monitoramento monitoramento = monitoramentoService.findById(request.getMonitoramentoId());
        return AvaliationMonitor.builder()
                .user(user)
                .monitoramento(monitoramento)
                .build();
    }

    @Override
    public AvaliationMonitorResponse toResponse(AvaliationMonitor entity) {
        if (Objects.isNull(entity) || (entity.getUser() == null && entity.getMonitoramento() == null)) return null;
        User user = userService.findById(entity.getUser().getId());
        Monitoramento monitoramento = monitoramentoService.findById(entity.getMonitoramento().getId());
        if (Objects.isNull(user) || Objects.isNull(monitoramento)) return null;

        return AvaliationMonitorResponse.builder()
                .id(entity.getId())
                .username(user.getUsername())
                .content(monitoramento.getContent())
                .build();
    }

    @Override
    public List<AvaliationMonitor> findAll() {
        return repo.findAll();
    }

    @Override
    public List<AvaliationMonitor> findAll(Example<AvaliationMonitor> example) {
        return repo.findAll(example);
    }

    @Override
    public AvaliationMonitor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public AvaliationMonitor save(AvaliationMonitorRequest request) {
        return repo.save(toEntity(request));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public AvaliationMonitor findByIdUserAndIdMonitoramento(Long userId, Long monitoramentoId) {
        User user = userService.findById(userId);
        AvaliationMonitor monitoramento = monitoramentoService.findById(monitoramentoId);
        if (Objects.isNull(user) || Objects.isNull(monitoramento)) return null;
        return repo.findByUserAndMonitoramento(user, monitoramento);
    }
}
