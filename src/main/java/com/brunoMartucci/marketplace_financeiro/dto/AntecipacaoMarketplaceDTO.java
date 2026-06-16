package com.brunoMartucci.marketplace_financeiro.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AntecipacaoMarketplaceDTO {

    @NotNull(message = "O ID do marketplace é obrigatório")
    private Long marketplaceId;

    private LocalDate dataAntecipacao;
    private BigDecimal valorOriginal;
    private BigDecimal taxaPercentual;
    private BigDecimal valorTaxa;
    private BigDecimal valorLiquido;
}
