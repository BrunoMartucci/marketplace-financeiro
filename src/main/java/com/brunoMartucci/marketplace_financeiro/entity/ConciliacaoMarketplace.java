package com.brunoMartucci.marketplace_financeiro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "conciliacao_marketplace")
@Data
public class ConciliacaoMarketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marketplace_id")
    private Long marketplaceId;

    @Column(name = "periodo_inicio")
    private LocalDate periodoInicio;

    @Column(name = "periodo_fim")
    private LocalDate periodoFim;

    @Column(name = "data_conciliacao")
    private LocalDateTime dataConciliacao;

    @Column(name = "status", length = 30)
    private String status;
}
