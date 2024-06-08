package br.com.fiap.seareport.repository;

import br.com.fiap.seareport.entity.AvaliationMonitor;
import br.com.fiap.seareport.entity.User;
import br.com.fiap.seareport.entity.MonitoramentoPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliationMonitorRepository extends JpaRepository<AvaliationMonitor, Long> {
    AvaliationMonitor findByUserAndMonitoramento(User user, MonitoramentoPost monitoramentopost);
}
