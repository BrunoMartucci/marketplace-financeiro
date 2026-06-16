package com.brunoMartucci.marketplace_financeiro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "recebivel_marketplace")
@Data
public class RecebimentoMarketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id")
    private Long pedidoId;

    @Column(name = "forma_pagamento_id")
    private Long formaPagamentoId;

    @Column(name = "valor_bruto", precision = 15, scale = 2)
    private BigDecimal valorBruto;

    @Column(name = "total_taxas", precision = 15, scale = 2)
    private BigDecimal totalTaxas;

    @Column(name = "valor_liquido", precision = 15, scale = 2)
    private BigDecimal valorLiquido;

    @Column(name = "data_prevista")
    private LocalDate dataPrevista;

    @Column(name = "data_recebimento")
    private LocalDate dataRecebimento;

    @Column(name = "status", length = 30)
    private String status;
}
