package com.brunoMartucci.marketplace_financeiro.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ConciliacaoMarketplaceDTO {

    private Long marketplaceId;

    private LocalDate periodoInicio;
    private LocalDate periodoFim;

    private LocalDateTime dataConciliacao;

    @Size(max = 30, message = "O status deve ter no máximo 30 caracteres")
    private String status;
}
