package br.com.fiap.seareport.controller;

import br.com.fiap.seareport.dto.request.AlertMonitorRequest;
import br.com.fiap.seareport.dto.response.AlertMonitorResponse;
import br.com.fiap.seareport.entity.AlertMonitor;
import br.com.fiap.seareport.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

@RestController
@RequestMapping("/alerts")
public class AlertMonitorController {

    @Autowired
    private AlertMonitor service;

    @Transactional
    @PostMapping
    public ResponseEntity<AlertMonitorResponse> save(@RequestBody @Valid AlertMonitorRequest alertmonitorrequest) {
        var saved = service.save(alertmonitorrequest);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(service.toResponse(saved));
    }

    @GetMapping("/user/{userId}/location/{locationId}")
    public ResponseEntity<AlertMonitorResponse> findByUserIdAndLocationId(
            @PathVariable Long userId,
            @PathVariable Long locationId
    ) {
        var alert = service.findByUserIdAndLocationId(userId, locationId);
        if (Objects.isNull(alert)) throw new ResourceNotFoundException("Alert does not exist");

        return ResponseEntity.ok(service.toResponse(alert));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlert(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deleted");
    }
}

