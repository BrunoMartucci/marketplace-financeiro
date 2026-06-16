package com.brunoMartucci.marketplace_financeiro.entity;

import com.brunoMartucci.marketplace_financeiro.enun.TipoTaxaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "taxa_marketplace")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxaMarketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketplace_id", nullable = false)
    private Marketplace marketplace;

    @Column(name = "descricao", nullable = false, length = 150)
    private String descricao;

    @Column(name = "percentual", nullable = false, precision = 10, scale = 2)
    private BigDecimal percentual;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_taxa", nullable = false, length = 50)
    private TipoTaxaEnum tipoTaxa;
}
