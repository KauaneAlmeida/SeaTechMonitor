package br.com.fiap.seareport.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "T_MONITORAMENTO_AVALIATION", uniqueConstraints = {
        @UniqueConstraint(name = "UK_MONITORAMENTO_AVALIATION_ID_USER_ID_MONITORAMENTO", columnNames = {"ID_USER", "ID_MONITORAMENTO"})
})
public class AvaliationMonitor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MONITORAMENTO_AVALIATION")
    @SequenceGenerator(name = "SQ_MONITORAMENTO_AVALIATION", sequenceName = "SQ_MONITORAMENTO_AVALIATION", allocationSize = 1)
    @Column(name = "ID_AVALIATION")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(
            name = "ID_USER",
            referencedColumnName = "ID_USER",
            foreignKey = @ForeignKey(name = "FK_MONITORAMENTO_AVALIATION_USER")
    )
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(
            name = "ID_MONITORAMENTO",
            referencedColumnName = "ID_MONITORAMENTO",
            foreignKey = @ForeignKey(name = "FK_MONITORAMENTO_AVALIATION_MONITORAMENTO")
    )
    private AvaliationMonitor monitoramento;
}
