package com.brunoMartucci.marketplace_financeiro.repository;

import com.brunoMartucci.marketplace_financeiro.entity.TaxaMarketplace;
import com.brunoMartucci.marketplace_financeiro.enun.TipoTaxaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaxaMarketplaceRepository extends JpaRepository<TaxaMarketplace, Long> {

    List<TaxaMarketplace> findByMarketplaceId(Long marketplaceId);

    List<TaxaMarketplace> findByTipoTaxa(TipoTaxaEnum tipoTaxa);
}
