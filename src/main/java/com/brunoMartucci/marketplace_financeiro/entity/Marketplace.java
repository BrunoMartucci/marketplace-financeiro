package com.brunoMartucci.marketplace_financeiro.entity;

import com.brunoMartucci.marketplace_financeiro.enun.MarketplaceEnun;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marketplace")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nome", nullable = false, length = 100)
    private MarketplaceEnun nome;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "ativo", columnDefinition = "TINYINT")
    private Boolean ativo;
}
