package br.com.fiap.seareport.repository;

import br.com.fiap.seareport.entity.AlertMonitor;
import br.com.fiap.seareport.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertMonitorRepository extends JpaRepository<AlertMonitor, Long> {
    List<AlertMonitor> findByUserId(Long userId);
    List<AlertMonitor> findByApprovedFalse();
    AlertMonitor findByUsuarioAndLocalizacao(User user, Object location);
}