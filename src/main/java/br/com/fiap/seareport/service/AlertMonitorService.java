package br.com.fiap.seareport.service;

import br.com.fiap.seareport.dto.request.AlertMonitorRequest;
import br.com.fiap.seareport.dto.response.AlertMonitorResponse;
import br.com.fiap.seareport.entity.AlertMonitor;
import br.com.fiap.seareport.entity.DadosMonitor;
import br.com.fiap.seareport.entity.Location;
import br.com.fiap.seareport.entity.User;
import br.com.fiap.seareport.exception.ResourceNotFoundException;
import br.com.fiap.seareport.repository.AlertMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AlertMonitorService implements ServiceDTO<AlertMonitor, AlertMonitorRequest, AlertMonitorResponse, Long> {

    @Autowired
    private AlertMonitorRepository repo;

    @Autowired
    private UserService userService;

    @Autowired
    private Location locationService;

    @Override
    public AlertMonitor toEntity(AlertMonitorRequest request) {
        if (Objects.isNull(request)) return null;
        var user = userService.findById(request.getUserId());
        var location = locationService.findById(request.getLocationId());
        return AlertMonitor.builder()
                .usuario((User) user)
                .localizacao((Location) location)
                .descricao(request.getDescription())
                .categoria(request.getCategory())
                .aprovado(request.isApproved())
                .build();
    }

    @Override
    public AlertMonitorResponse toResponse(AlertMonitor entity) {
        if (Objects.isNull(entity) || (entity.getUsuario() == null && entity.getLocalizacao() == null)) return null;
        var user = userService.findById(entity.getUsuario().getId());
        var location = locationService.findById(entity.getLocalizacao().getId());
        if (Objects.isNull(user) || Objects.isNull(location)) return null;

        return AlertMonitorResponse.builder()
                .id(entity.getId())
                .username(user.getUsername())
                .locationName(((DadosMonitor) location).getName())
                .description(entity.getDescricao())
                .category(entity.getCategoria())
                .approved(entity.getAprovado())
                .build();
    }

    @Override
    public List<AlertMonitor> findAll() {
        return repo.findAll();
    }

    @Override
    public List<AlertMonitor> findAll(Example<AlertMonitor> example) {
        return repo.findAll(example);
    }

    @Override
    public AlertMonitor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public AlertMonitor save(AlertMonitorRequest request) {
        // Converte AlertMonitorRequest em AlertMonitor entity
        AlertMonitor entity = toEntity(request);
        // Salva o objeto AlertMonitor no repositório
        return repo.save(entity);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public AlertMonitor findByUserIdAndLocationId(Long userId, Long locationId) {
        var user = userService.findById(userId);
        var location = locationService.findById(locationId);
        if (Objects.isNull(user) || Objects.isNull(location)) throw new ResourceNotFoundException("User or Location not found");
        return repo.findByUsuarioAndLocalizacao(user, location);
    }
}


