package br.com.fiap.seareport.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "T_MONITORAMENTO_POST")
public class MonitoramentoPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MONITORAMENTO_POST")
    @SequenceGenerator(name = "SQ_MONITORAMENTO_POST", sequenceName = "SQ_MONITORAMENTO_POST", allocationSize = 1)
    @Column(name = "ID_POST")
    private Long id;

    @Column(name = "CONTEUDO_POST" , length = 4000, nullable = false)
    private String conteudoPost;

    @Column(name = "DATA_POST")
    private LocalDateTime dataPostagem;
}
