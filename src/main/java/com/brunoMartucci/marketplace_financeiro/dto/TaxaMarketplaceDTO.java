package com.brunoMartucci.marketplace_financeiro.dto;

import com.brunoMartucci.marketplace_financeiro.enun.TipoTaxaEnum;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxaMarketplaceDTO {

    private Long id;
    private Long marketplaceId;
    private String descricao;
    private BigDecimal percentual;
    private TipoTaxaEnum tipoTaxa;
}
