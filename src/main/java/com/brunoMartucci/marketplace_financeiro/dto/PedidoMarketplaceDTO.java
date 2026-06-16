package com.brunoMartucci.marketplace_financeiro.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PedidoMarketplaceDTO {

    @NotNull(message = "O ID do marketplace é obrigatório")
    private Long marketplaceId;

    @Size(max = 100, message = "O código do marketplace deve ter no máximo 100 caracteres")
    private String codigoMarketplace;

    private BigDecimal valorBruto;
    private BigDecimal valorEntrega;
    private LocalDateTime dataPedido;

    @Size(max = 30, message = "O status deve ter no máximo 30 caracteres")
    private String status;
}