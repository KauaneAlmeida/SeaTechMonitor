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
@Builderpublic Object username(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'username'");
    }
@Entity
@Table(name = "T_MONITORAMENTO_ALERTA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_MONITORAMENTO_ALERTA_ID_LOCALIZACAO", columnNames = "ID_LOCALIZACAO")
})
public class AlertMonitor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MONITORAMENTO_ALERTA")
    @SequenceGenerator(name = "SQ_MONITORAMENTO_ALERTA", sequenceName = "SQ_MONITORAMENTO_ALERTA", allocationSize = 1)
    @Column(name = "ID_ALERTA")
    private Long id;

    @Column(name = "DESC_ALERTA")
    private String descricao;

    @Column(name = "DATA_ALERTA")
    private LocalDateTime dataAlerta;

    @Column(name = "CATEGORIA")
    private DadosMonitor categoria;

    @Column(name = "APROVADO")
    private Boolean aprovado;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(
            name = "ID_LOCALIZACAO",
            referencedColumnName = "ID_LOCALIZACAO",
            foreignKey = @ForeignKey(name = "FK_MONITORAMENTO_ALERTA_LOCALIZACAO")
    )
    private Location localizacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(
            name = "ID_USER",
            referencedColumnName = "ID_USER",
            foreignKey = @ForeignKey(name = "FK_MONITORAMENTO_ALERTA_USER")
    )
    private User usuario;
}
