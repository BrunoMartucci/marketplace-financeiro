package com.brunoMartucci.marketplace_financeiro.controller;

import com.brunoMartucci.marketplace_financeiro.dto.FormaPagamentoMarketplaceDTO;
import com.brunoMartucci.marketplace_financeiro.service.FormaPagamentoMarketplaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formas-pagamento-marketplace")
@RequiredArgsConstructor
public class FormaPagamentoMarketplaceController {

    private final FormaPagamentoMarketplaceService service;

    @GetMapping
    public ResponseEntity<List<FormaPagamentoMarketplaceDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamentoMarketplaceDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/marketplace/{marketplaceId}")
    public ResponseEntity<List<FormaPagamentoMarketplaceDTO>> listarPorMarketplace(@PathVariable Long marketplaceId) {
        return ResponseEntity.ok(service.listarPorMarketplace(marketplaceId));
    }

    @PostMapping
    public ResponseEntity<FormaPagamentoMarketplaceDTO> salvar(@RequestBody FormaPagamentoMarketplaceDTO dto) {
        FormaPagamentoMarketplaceDTO salvo = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}