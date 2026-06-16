package com.brunoMartucci.marketplace_financeiro.service;

import com.brunoMartucci.marketplace_financeiro.dto.ConciliacaoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.ConciliacaoMarketplace;
import com.brunoMartucci.marketplace_financeiro.repository.ConciliacaoMarketplaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConciliacaoMarketplaceService {

    @Autowired
    private ConciliacaoMarketplaceRepository repository;


    public ConciliacaoMarketplace registrarEntrada(ConciliacaoMarketplaceDTO inputDTO) {
        ConciliacaoMarketplace conciliacao = new ConciliacaoMarketplace();
        BeanUtils.copyProperties(inputDTO, conciliacao);

        if (conciliacao.getDataConciliacao() == null) {
            conciliacao.setDataConciliacao(LocalDateTime.now());
        }

        return repository.save(conciliacao);
    }

    public List<ConciliacaoMarketplace> listarEntradas() {
        return repository.findAll();
    }

    public ConciliacaoMarketplace buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de conciliação não encontrado para o ID: " + id));
    }
}
