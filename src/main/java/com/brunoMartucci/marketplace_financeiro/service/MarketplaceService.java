package com.brunoMartucci.marketplace_financeiro.service;

import com.brunoMartucci.marketplace_financeiro.dto.MarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.Marketplace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brunoMartucci.marketplace_financeiro.repository.MarketplaceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarketplaceService {

    private final MarketplaceRepository repository;

    @Transactional(readOnly = true)
    public List<MarketplaceDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MarketplaceDTO findById(Long id) {
        Marketplace marketplace = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marketplace não encontrado com o ID: " + id));
        return convertToDTO(marketplace);
    }

    @Transactional
    public MarketplaceDTO create(MarketplaceDTO dto) {
        Marketplace marketplace = convertToEntity(dto);
        if (marketplace.getAtivo() == null) {
            marketplace.setAtivo(true);
        }
        Marketplace savedMarketplace = repository.save(marketplace);
        return convertToDTO(savedMarketplace);
    }

    @Transactional
    public MarketplaceDTO update(Long id, MarketplaceDTO dto) {
        Marketplace marketplace = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marketplace não encontrado com o ID: " + id));

        marketplace.setNome(dto.getNome());
        marketplace.setDescricao(dto.getDescricao());
        marketplace.setAtivo(dto.getAtivo());

        Marketplace updatedMarketplace = repository.save(marketplace);
        return convertToDTO(updatedMarketplace);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Marketplace não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }

    private MarketplaceDTO convertToDTO(Marketplace entity) {
        return MarketplaceDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .ativo(entity.getAtivo())
                .build();
    }

    private Marketplace convertToEntity(MarketplaceDTO dto) {
        return Marketplace.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .ativo(dto.getAtivo())
                .build();
    }
}
