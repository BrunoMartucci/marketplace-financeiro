package com.brunoMartucci.marketplace_financeiro.repository;

import com.brunoMartucci.marketplace_financeiro.entity.FormaPagamentoMarketplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FormaPagamentoMarketplaceRepository extends JpaRepository<FormaPagamentoMarketplace, Long> {

    List<FormaPagamentoMarketplace> findByMarketplaceId(Long marketplaceId);

    List<FormaPagamentoMarketplace> findByNome(FormaPagamentoMarketplace nome);
}
