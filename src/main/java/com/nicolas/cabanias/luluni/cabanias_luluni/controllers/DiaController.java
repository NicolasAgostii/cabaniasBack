package com.nicolas.cabanias.luluni.cabanias_luluni.controllers;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.DiaDTO;
import com.nicolas.cabanias.luluni.cabanias_luluni.services.DiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dias")
@RequiredArgsConstructor
public class DiaController {

    private final DiaService diaService;

    @GetMapping
    public ResponseEntity<List<DiaDTO>> getAll() {
        return ResponseEntity.ok(diaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(diaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DiaDTO> create(@RequestBody DiaDTO dto) {
        return ResponseEntity.ok(diaService.create(dto));
    }

    @PutMapping("/{id}/reservar")
    public ResponseEntity<DiaDTO> reservar(@PathVariable Long id, @RequestBody DiaDTO dto) {
        return ResponseEntity.ok(
                diaService.reservar(
                        id,
                        dto.getNombreInquilinoManiana() != null ? dto.getNombreInquilinoManiana() : dto.getNombreInquilinoTarde(),
                        dto.getNumeroContactoManiana() != null ? dto.getNumeroContactoManiana() : dto.getNumeroContactoTarde()
                )
        );
    }

    @PutMapping("/{id}/reservar-maniana")
    public ResponseEntity<DiaDTO> reservarManiana(@PathVariable Long id, @RequestBody DiaDTO dto) {
        return ResponseEntity.ok(
                diaService.reservarManiana(
                        id,
                        dto.getNombreInquilinoManiana(),
                        dto.getNumeroContactoManiana()
                )
        );
    }

    @PutMapping("/{id}/reservar-tarde")
    public ResponseEntity<DiaDTO> reservarTarde(@PathVariable Long id, @RequestBody DiaDTO dto) {
        return ResponseEntity.ok(
                diaService.reservarTarde(
                        id,
                        dto.getNombreInquilinoTarde(),
                        dto.getNumeroContactoTarde()
                )
        );
    }
}
