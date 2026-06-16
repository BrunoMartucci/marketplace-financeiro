package com.brunoMartucci.marketplace_financeiro.controller;

import com.brunoMartucci.marketplace_financeiro.dto.MarketplaceDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.brunoMartucci.marketplace_financeiro.service.MarketplaceService;

import java.util.List;

@RestController
@RequestMapping("/api/marketplaces")
@RequiredArgsConstructor
public class MarketplaceController {

    private final MarketplaceService service;

    @GetMapping
    public ResponseEntity<List<MarketplaceDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketplaceDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<MarketplaceDTO> create(@Valid @RequestBody MarketplaceDTO dto) {
        MarketplaceDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarketplaceDTO> update(@PathVariable Long id, @Valid @RequestBody MarketplaceDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
