package com.brunoMartucci.marketplace_financeiro.controller;

import com.brunoMartucci.marketplace_financeiro.dto.ConciliacaoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.entity.ConciliacaoMarketplace;
import com.brunoMartucci.marketplace_financeiro.service.ConciliacaoMarketplaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conciliacoes-marketplace")
public class ConciliacaoMarketplaceController {

    @Autowired
    private ConciliacaoMarketplaceService service;

    @PostMapping
    public ResponseEntity<ConciliacaoMarketplace> receberConciliacao(@Valid @RequestBody ConciliacaoMarketplaceDTO inputDTO) {
        ConciliacaoMarketplace novaConciliacao = service.registrarEntrada(inputDTO);
        return new ResponseEntity<>(novaConciliacao, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ConciliacaoMarketplace>> listarTodas() {
        return ResponseEntity.ok(service.listarEntradas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConciliacaoMarketplace> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}