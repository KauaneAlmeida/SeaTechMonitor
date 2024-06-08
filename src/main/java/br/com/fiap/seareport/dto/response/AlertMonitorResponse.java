package br.com.fiap.seareport.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
public record AlertMonitorResponse(
        Long id,
        String username,
        String contentPost
) {
}
