package br.com.fiap.seareport.dto.response;

import lombok.Builder;

@Builder
public record AvaliationMonitorResponse(

        Long id,
        String username,
        String contentPost
) {
}