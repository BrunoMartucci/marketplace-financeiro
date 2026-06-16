package com.brunoMartucci.marketplace_financeiro.controller;

import com.brunoMartucci.marketplace_financeiro.dto.TaxaMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.service.TaxaMarketplaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taxas-marketplace")
@RequiredArgsConstructor
public class TaxaMarketplaceController {

    private final TaxaMarketplaceService service;

    @GetMapping
    public ResponseEntity<List<TaxaMarketplaceDTO>> listarTodas() {
        List<TaxaMarketplaceDTO> taxas = service.listarTodas();
        return ResponseEntity.ok(taxas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxaMarketplaceDTO> buscarPorId(@PathVariable Long id) {
        TaxaMarketplaceDTO dto = service.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TaxaMarketplaceDTO> salvar(@RequestBody TaxaMarketplaceDTO dto) {
        TaxaMarketplaceDTO taxaSalva = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taxaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
