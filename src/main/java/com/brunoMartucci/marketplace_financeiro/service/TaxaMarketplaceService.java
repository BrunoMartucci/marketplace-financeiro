package com.brunoMartucci.marketplace_financeiro.service;

import com.brunoMartucci.marketplace_financeiro.dto.TaxaMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.Marketplace;
import com.brunoMartucci.marketplace_financeiro.entity.TaxaMarketplace;
import com.brunoMartucci.marketplace_financeiro.repository.TaxaMarketplaceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaxaMarketplaceService {

    private final TaxaMarketplaceRepository repository;

    @Transactional(readOnly = true)
    public List<TaxaMarketplaceDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TaxaMarketplaceDTO buscarPorId(Long id) {
        TaxaMarketplace taxa = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Taxa não encontrada com o ID: " + id));
        return toDTO(taxa);
    }

    @Transactional
    public TaxaMarketplaceDTO salvar(TaxaMarketplaceDTO dto) {
        TaxaMarketplace taxa = toEntity(dto);
        TaxaMarketplace taxaSalva = repository.save(taxa);
        return toDTO(taxaSalva);
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Taxa não encontrada com o ID: " + id);
        }
        repository.deleteById(id);
    }

    private TaxaMarketplaceDTO toDTO(TaxaMarketplace entity) {
        return TaxaMarketplaceDTO.builder()
                .id(entity.getId())
                .marketplaceId(entity.getMarketplace() != null ? entity.getMarketplace().getId() : null)
                .descricao(entity.getDescricao())
                .percentual(entity.getPercentual())
                .tipoTaxa(entity.getTipoTaxa())
                .build();
    }

    private TaxaMarketplace toEntity(TaxaMarketplaceDTO dto) {
        Marketplace marketplace = new Marketplace();
        marketplace.setId(dto.getMarketplaceId());

        return TaxaMarketplace.builder()
                .id(dto.getId())
                .marketplace(marketplace)
                .descricao(dto.getDescricao())
                .percentual(dto.getPercentual())
                .tipoTaxa(dto.getTipoTaxa())
                .build();
    }
}
