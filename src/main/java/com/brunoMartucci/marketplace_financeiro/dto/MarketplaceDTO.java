package com.brunoMartucci.marketplace_financeiro.dto;

import com.brunoMartucci.marketplace_financeiro.enun.MarketplaceEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketplaceDTO {

    private Long id;

    @NotNull(message = "O nome do marketplace é obrigatório e deve ser um valor válido")
    private MarketplaceEnum nome;

    @Size(max = 255, message = "A descrição deve ter no máximo {max} caracteres")
    private String descricao;

    private Boolean ativo;
}
