package br.com.fiap.seareport.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Builder;

@Builder
public record UserRequest(

//        @NotBlank
//        String name,
        @NotBlank(message = "O email é obrigatório!")
//        @Email(message = "Email inválido!")
//        String email,
        @NotBlank
        String username,
        String phoneNumber,
        Integer xp,
        @NotNull
        AuthRequest auth

) {
}