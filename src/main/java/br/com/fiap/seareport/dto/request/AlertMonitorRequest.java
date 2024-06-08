package br.com.fiap.seareport.dto.request;

import br.com.fiap.seareport.entity.DadosMonitor;
import br.com.fiap.seareport.entity.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record AlertMonitorRequest(
        @NotBlank(message = "Descricao é obrigatório!")
        String description,
        @NotNull
        Location location,
        @NotNull
        int dadosmonitor,
        @Positive
        @NotNull(message = "O ID do usuario é obrigatório!")
        Long userId
) {public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

public DadosMonitor getCategory() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCategory'");
}

public Boolean isApproved() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isApproved'");
}

public Object getLocationId() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getLocationId'");
}

public Long getUserId() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUserId'");
}
}