package com.brunoMartucci.marketplace_financeiro.service;

import com.brunoMartucci.marketplace_financeiro.dto.RecebimentoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.RecebimentoMarketplace;
import com.brunoMartucci.marketplace_financeiro.repository.RecebimentoMarketplaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecebimentoMarketplaceService {

    @Autowired
    private RecebimentoMarketplaceRepository repository;


    public RecebimentoMarketplace registrarEntrada(RecebimentoMarketplaceDTO inputDTO) {
        RecebimentoMarketplace recebivel = new RecebimentoMarketplace();
        BeanUtils.copyProperties(inputDTO, recebivel);

        return repository.save(recebivel);
    }

    public List<RecebimentoMarketplace> listarEntradas() {
        return repository.findAll();
    }

    public RecebimentoMarketplace buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de recebível não encontrado para o ID: " + id));
    }
}