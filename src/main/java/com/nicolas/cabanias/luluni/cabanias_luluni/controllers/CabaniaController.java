package com.nicolas.cabanias.luluni.cabanias_luluni.controllers;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.CabaniaDTO;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Cabania;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.CabaniaRepository;
import com.nicolas.cabanias.luluni.cabanias_luluni.services.CabaniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cabanias")
@RequiredArgsConstructor
public class CabaniaController {

    private final CabaniaService cabaniaService;

    private final CabaniaRepository cabaniaRepository;

    @PostMapping
    public ResponseEntity<Cabania> crear(@RequestBody Cabania c) {
        return ResponseEntity.ok(cabaniaService.crearCabania(c));
    }

    @GetMapping
public ResponseEntity<List<CabaniaDTO>> listar() {
    List<Cabania> cabanias = cabaniaRepository.findAll();

    List<CabaniaDTO> dtos = cabanias.stream().map(c -> {
        CabaniaDTO dto = new CabaniaDTO();
        dto.setId(c.getId());
        dto.setPrecio(c.getPrecio());
        dto.setCapacidad(c.getCapacidad());
        dto.setDescripcion(c.getDescripcion());

        List<String> urls = c.getFotos().stream()
            .map(f -> "http://localhost:8080/api/fotos/" + f.getId())
            .toList();

        dto.setFotoUrls(urls);
        return dto;
    }).toList();

    return ResponseEntity.ok(dtos);
}

}
