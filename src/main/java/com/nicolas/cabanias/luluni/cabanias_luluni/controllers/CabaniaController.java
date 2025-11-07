package com.nicolas.cabanias.luluni.cabanias_luluni.controllers;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.CabaniaDTO;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Cabania;
import com.nicolas.cabanias.luluni.cabanias_luluni.services.CabaniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {
        "https://cabaniasfront.netlify.app",
        "http://localhost:5173"
})
@RestController
@RequestMapping("/api/cabanias")
@RequiredArgsConstructor
public class CabaniaController {

    private final CabaniaService cabaniaService;

    @PostMapping
    public ResponseEntity<Cabania> crear(@RequestBody Cabania c) {
        return ResponseEntity.ok(cabaniaService.crearCabania(c));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<CabaniaDTO>> listar() {
        // Obtener la URL base actual (Railway o localhost)
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .build()
                .toUriString();

        // Obtener cabañas con fotos (usando fetch join desde el service)
        List<Cabania> cabanias = cabaniaService.findAllWithFotos();

        // Mapear las entidades a DTOs
        List<CabaniaDTO> dtos = cabanias.stream().map(c -> {
            CabaniaDTO dto = new CabaniaDTO();
            dto.setId(c.getId());
            dto.setPrecio(c.getPrecio());
            dto.setCapacidad(c.getCapacidad());
            dto.setDescripcion(c.getDescripcion());

            // Manejar fotos null y construir las URLs correctas
            List<String> urls = Optional.ofNullable(c.getFotos())
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(f -> baseUrl + "/api/fotos/" + f.getId())
                    .toList();

            dto.setFotoUrls(urls);
            return dto;
        }).toList();

        return ResponseEntity.ok(dtos);
    }
}
