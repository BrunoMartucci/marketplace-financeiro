package com.brunoMartucci.marketplace_financeiro.repository;

import com.brunoMartucci.marketplace_financeiro.entity.ConciliacaoMarketplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConciliacaoMarketplaceRepository extends JpaRepository<ConciliacaoMarketplace, Long> {
}
