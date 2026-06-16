package com.brunoMartucci.marketplace_financeiro.repository;

import com.brunoMartucci.marketplace_financeiro.entity.PedidoMarketplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoMarketplaceRepository extends JpaRepository<PedidoMarketplace, Long> {
}