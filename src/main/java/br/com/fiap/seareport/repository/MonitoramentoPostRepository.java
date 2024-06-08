package br.com.fiap.seareport.repository;

import br.com.fiap.seareport.entity.MonitoramentoPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoramentoPostRepository extends JpaRepository<MonitoramentoPost, Long> {
}