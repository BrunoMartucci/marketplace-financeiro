package com.brunoMartucci.marketplace_financeiro.controller;

import com.brunoMartucci.marketplace_financeiro.dto.RecebimentoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.RecebimentoMarketplace;
import com.brunoMartucci.marketplace_financeiro.service.RecebimentoMarketplaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recebiveis-marketplace")
public class RecebimentoMarketplaceController {

    @Autowired
    private RecebimentoMarketplaceService service;

    @PostMapping
    public ResponseEntity<RecebimentoMarketplace> receberRecebivel(@Valid @RequestBody RecebimentoMarketplaceDTO inputDTO) {
        RecebimentoMarketplace novoRecebivel = service.registrarEntrada(inputDTO);
        return new ResponseEntity<>(novoRecebivel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecebimentoMarketplace>> listarTodas() {
        return ResponseEntity.ok(service.listarEntradas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecebimentoMarketplace> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}