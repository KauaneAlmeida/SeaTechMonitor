package br.com.fiap.seareport.dto.request;

import jakarta.validation.constraints.NotNull;

public record AvaliationMonitorRequest(
        @NotNull
        Long idUser,
        @NotNull
        Long idPost
) {
}