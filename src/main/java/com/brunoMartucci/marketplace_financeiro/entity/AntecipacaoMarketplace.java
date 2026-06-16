package com.brunoMartucci.marketplace_financeiro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "antecipacao_marketplace")
@Data
public class AntecipacaoMarketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marketplace_id", nullable = false)
    private Long marketplaceId;

    @Column(name = "data_antecipacao")
    private LocalDate dataAntecipacao;

    @Column(name = "valor_original", precision = 15, scale = 2)
    private BigDecimal valorOriginal;

    @Column(name = "taxa_percentual", precision = 10, scale = 2)
    private BigDecimal taxaPercentual;

    @Column(name = "valor_taxa", precision = 15, scale = 2)
    private BigDecimal valorTaxa;

    @Column(name = "valor_liquido", precision = 15, scale = 2)
    private BigDecimal valorLiquido;
}
