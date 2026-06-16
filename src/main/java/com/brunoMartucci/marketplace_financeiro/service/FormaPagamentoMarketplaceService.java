package com.brunoMartucci.marketplace_financeiro.service;

import com.brunoMartucci.marketplace_financeiro.dto.FormaPagamentoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.FormaPagamentoMarketplace;
import com.brunoMartucci.marketplace_financeiro.entity.Marketplace;
import com.brunoMartucci.marketplace_financeiro.repository.FormaPagamentoMarketplaceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormaPagamentoMarketplaceService {

    private final FormaPagamentoMarketplaceRepository repository;

    @Transactional(readOnly = true)
    public List<FormaPagamentoMarketplaceDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FormaPagamentoMarketplaceDTO buscarPorId(Long id) {
        FormaPagamentoMarketplace fpm = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Forma de pagamento não encontrada com o ID: " + id));
        return toDTO(fpm);
    }

    @Transactional(readOnly = true)
    public List<FormaPagamentoMarketplaceDTO> listarPorMarketplace(Long marketplaceId) {
        return repository.findByMarketplaceId(marketplaceId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public FormaPagamentoMarketplaceDTO salvar(FormaPagamentoMarketplaceDTO dto) {
        FormaPagamentoMarketplace fpm = toEntity(dto);
        FormaPagamentoMarketplace salvo = repository.save(fpm);
        return toDTO(salvo);
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Forma de pagamento não encontrada com o ID: " + id);
        }
        repository.deleteById(id);
    }

    private FormaPagamentoMarketplaceDTO toDTO(FormaPagamentoMarketplace entity) {
        return FormaPagamentoMarketplaceDTO.builder()
                .id(entity.getId())
                .marketplaceId(entity.getMarketplace() != null ? entity.getMarketplace().getId() : null)
                .nome(entity.getNome())
                .prazoRecebimento(entity.getPrazoRecebimento())
                .permiteAntecipacao(entity.getPermiteAntecipacao())
                .integraCartao(entity.getIntegraCartao())
                .build();
    }

    private FormaPagamentoMarketplace toEntity(FormaPagamentoMarketplaceDTO dto) {
        Marketplace marketplace = new Marketplace();
        marketplace.setId(dto.getMarketplaceId());

        return FormaPagamentoMarketplace.builder()
                .id(dto.getId())
                .marketplace(marketplace)
                .nome(dto.getNome())
                .prazoRecebimento(dto.getPrazoRecebimento())
                .permiteAntecipacao(dto.getPermiteAntecipacao())
                .integraCartao(dto.getIntegraCartao())
                .build();
    }
}
