package com.brunoMartucci.marketplace_financeiro.repository;

import com.brunoMartucci.marketplace_financeiro.entity.RecebimentoMarketplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecebimentoMarketplaceRepository extends JpaRepository<RecebimentoMarketplace, Long> {

     List<RecebimentoMarketplace> findByPedidoId(Long pedidoId);
}