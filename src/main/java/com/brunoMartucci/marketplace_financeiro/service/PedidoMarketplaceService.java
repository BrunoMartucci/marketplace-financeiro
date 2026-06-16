package com.brunoMartucci.marketplace_financeiro.service;

import com.brunoMartucci.marketplace_financeiro.dto.PedidoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.PedidoMarketplace;
import com.brunoMartucci.marketplace_financeiro.repository.PedidoMarketplaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoMarketplaceService {

    @Autowired
    private PedidoMarketplaceRepository repository;

    public PedidoMarketplace registrarEntrada(PedidoMarketplaceDTO inputDTO) {
        PedidoMarketplace pedido = new PedidoMarketplace();
        BeanUtils.copyProperties(inputDTO, pedido);

        if (pedido.getDataPedido() == null) {
            pedido.setDataPedido(LocalDateTime.now());
        }

        return repository.save(pedido);
    }

    public List<PedidoMarketplace> listarEntradas() {
        return repository.findAll();
    }

    public PedidoMarketplace buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de entrada não encontrado para o ID: " + id));
    }
}