package com.brunoMartucci.marketplace_financeiro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido_marketplace")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoMarketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marketplace_id", nullable = false)
    private Long marketplaceId;

    @Column(name = "codigo_marketplace", length = 100)
    private String codigoMarketplace;

    @Column(name = "valor_bruto", precision = 15, scale = 2)
    private BigDecimal valorBruto;

    @Column(name = "valor_entrega", precision = 15, scale = 2)
    private BigDecimal valorEntrega;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "status", length = 30)
    private String status;
}
