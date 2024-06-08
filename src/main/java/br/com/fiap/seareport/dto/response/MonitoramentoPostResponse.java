package br.com.fiap.seareport.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MonitoramentoPostResponse(
        Long id,
        String contentPost,
        LocalDateTime date
) {
}