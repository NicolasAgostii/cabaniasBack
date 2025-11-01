package com.nicolas.cabanias.luluni.cabanias_luluni.controllers;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.AnioDTO;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Anio;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.AnioRepository;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.CalendarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/anios")
@RequiredArgsConstructor
public class AnioController {

    private final AnioRepository anioRepository;
    private final CalendarioRepository calendarioRepository;

    @GetMapping
    public ResponseEntity<List<AnioDTO>> getAll() {
        List<AnioDTO> anios = anioRepository.findAll().stream()
                .map(a -> new AnioDTO(a.getId(), a.getNumero(), a.getMeses()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(anios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnioDTO> getById(@PathVariable Long id) {
        Anio anio = anioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Año no encontrado"));
        return ResponseEntity.ok(new AnioDTO(anio.getId(), anio.getNumero(), anio.getMeses()));
    }

    @GetMapping("/calendario/{calendarioId}")
    public ResponseEntity<List<AnioDTO>> getByCalendario(@PathVariable Long calendarioId) {
        var calendario = calendarioRepository.findById(calendarioId)
                .orElseThrow(() -> new RuntimeException("Calendario no encontrado"));
        List<AnioDTO> anios = calendario.getAnios().stream()
                .map(a -> new AnioDTO(a.getId(), a.getNumero(), a.getMeses()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(anios);
    }
}
