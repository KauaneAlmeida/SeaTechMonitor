package br.com.fiap.seareport.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DadosMonitor {
    TEMPERATURA_AGUA(1L, "Temperatura da Água", "Medição da temperatura da água no mar."),
    SALINIDADE(2L, "Salinidade", "Medição da salinidade da água no mar."),
    PH(3L, "PH", "Medição do nível de pH da água no mar."),
    PRESENCA_POLUENTES(4L, "Presença de Poluentes", "Detecção da presença de poluentes na água marinha."),
    OUTROS(5L, "Outros", "Outros parâmetros de monitoramento marinho."),
    // Adicione outras categorias específicas de monitoramento, se necessário
    ;

    private Long id;
    private String name;
    private String description;

    public static DadosMonitor fromId(int id) {
        for (DadosMonitor monitorData : DadosMonitor.values()) {
            if (monitorData.getId() == id) {
                return monitorData;
            }
        }
        throw new IllegalArgumentException("Invalid monitor data id: " + id);
    }
}

    

