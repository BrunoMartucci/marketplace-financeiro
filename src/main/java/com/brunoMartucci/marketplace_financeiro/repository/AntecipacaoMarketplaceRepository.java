package com.brunoMartucci.marketplace_financeiro.repository;

import com.brunoMartucci.marketplace_financeiro.entity.AntecipacaoMarketplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntecipacaoMarketplaceRepository extends JpaRepository<AntecipacaoMarketplace, Long> {
}