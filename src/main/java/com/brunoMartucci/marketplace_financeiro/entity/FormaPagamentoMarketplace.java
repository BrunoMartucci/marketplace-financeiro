package com.brunoMartucci.marketplace_financeiro.entity;

import com.brunoMartucci.marketplace_financeiro.enun.FormasPagamentoEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "forma_pagamento_marketplace")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormaPagamentoMarketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketplace_id", nullable = false)
    private Marketplace marketplace;

    @Enumerated(EnumType.STRING)
    @Column(name = "nome", nullable = false, length = 100)
    private FormasPagamentoEnum nome;

    @Column(name = "prazo_recebimento")
    private Integer prazoRecebimento;

    @Column(name = "permite_antecipacao")
    private Boolean permiteAntecipacao;

    @Column(name = "integra_cartao")
    private Boolean integraCartao;
}