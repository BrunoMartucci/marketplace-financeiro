package com.brunoMartucci.marketplace_financeiro.controller;

import com.brunoMartucci.marketplace_financeiro.dto.AntecipacaoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.AntecipacaoMarketplace;
import com.brunoMartucci.marketplace_financeiro.service.AntecipacaoMarketplaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antecipacoes-marketplace")
public class AntecipacaoMarketplaceController {

    @Autowired
    private AntecipacaoMarketplaceService service;

    @PostMapping
    public ResponseEntity<AntecipacaoMarketplace> receberAntecipacao(@Valid @RequestBody AntecipacaoMarketplaceDTO inputDTO) {
        AntecipacaoMarketplace novaAntecipacao = service.registrarEntrada(inputDTO);
        return new ResponseEntity<>(novaAntecipacao, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AntecipacaoMarketplace>> listarTodas() {
        return ResponseEntity.ok(service.listarEntradas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AntecipacaoMarketplace> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
