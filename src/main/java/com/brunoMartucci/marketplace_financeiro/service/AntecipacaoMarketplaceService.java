package com.brunoMartucci.marketplace_financeiro.service;

import com.brunoMartucci.marketplace_financeiro.dto.AntecipacaoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.AntecipacaoMarketplace;
import com.brunoMartucci.marketplace_financeiro.repository.AntecipacaoMarketplaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AntecipacaoMarketplaceService {

    @Autowired
    private AntecipacaoMarketplaceRepository repository;

    public AntecipacaoMarketplace registrarEntrada(AntecipacaoMarketplaceDTO inputDTO) {
        AntecipacaoMarketplace antecipacao = new AntecipacaoMarketplace();
        BeanUtils.copyProperties(inputDTO, antecipacao);

        if (antecipacao.getDataAntecipacao() == null) {
            antecipacao.setDataAntecipacao(LocalDate.now());
        }

        return repository.save(antecipacao);
    }

    public List<AntecipacaoMarketplace> listarEntradas() {
        return repository.findAll();
    }

    public AntecipacaoMarketplace buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de antecipação não encontrado para o ID: " + id));
    }
}
