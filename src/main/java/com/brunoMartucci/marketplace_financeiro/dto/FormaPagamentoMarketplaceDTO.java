package com.brunoMartucci.marketplace_financeiro.dto;

import com.brunoMartucci.marketplace_financeiro.enun.FormasPagamentoEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormaPagamentoMarketplaceDTO {

    private Long id;
    private Long marketplaceId;
    private FormasPagamentoEnum nome;
    private Integer prazoRecebimento;
    private Boolean permiteAntecipacao;
    private Boolean integraCartao;
}
