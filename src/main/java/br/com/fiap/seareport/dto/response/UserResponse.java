
package br.com.fiap.seareport.dto.response;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        @NotBlank String username,
        Integer xp,
        AuthResponse auth
) {
}
