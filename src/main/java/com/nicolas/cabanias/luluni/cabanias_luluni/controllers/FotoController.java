package com.nicolas.cabanias.luluni.cabanias_luluni.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Foto;
import com.nicolas.cabanias.luluni.cabanias_luluni.services.FotoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/fotos")
@RequiredArgsConstructor
public class FotoController {

    private final FotoService fotoService;

    @PostMapping("/cabania/{id}")
    public ResponseEntity<String> subirFoto(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        fotoService.guardarFoto(id, file);
        return ResponseEntity.ok("Foto subida");
    }

    @GetMapping("/{fotoId}")
    public ResponseEntity<byte[]> verFoto(@PathVariable Long fotoId) {
        Foto foto = fotoService.obtenerFotoEntity(fotoId);

        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg")
                .body(foto.getData());
    }

}
