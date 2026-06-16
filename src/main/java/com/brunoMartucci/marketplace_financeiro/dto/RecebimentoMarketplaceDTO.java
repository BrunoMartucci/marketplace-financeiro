package com.brunoMartucci.marketplace_financeiro.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RecebimentoMarketplaceDTO {

    private Long pedidoId;
    private Long formaPagamentoId;

    private BigDecimal valorBruto;
    private BigDecimal totalTaxas;
    private BigDecimal valorLiquido;

    private LocalDate dataPrevista;
    private LocalDate dataRecebimento;

    @Size(max = 30, message = "O status deve ter no máximo 30 caracteres")
    private String status;
}