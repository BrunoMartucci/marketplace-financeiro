package com.brunoMartucci.marketplace_financeiro.controller;

import com.brunoMartucci.marketplace_financeiro.dto.PedidoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.PedidoMarketplace;
import com.brunoMartucci.marketplace_financeiro.service.PedidoMarketplaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas-marketplace")
public class PedidoMarketplaceController {

    @Autowired
    private PedidoMarketplaceService service;

    @PostMapping
    public ResponseEntity<PedidoMarketplace> receberPedido(@Valid @RequestBody PedidoMarketplaceDTO inputDTO) {
        PedidoMarketplace novoPedido = service.registrarEntrada(inputDTO);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PedidoMarketplace>> listarTodas() {
        return ResponseEntity.ok(service.listarEntradas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoMarketplace> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
