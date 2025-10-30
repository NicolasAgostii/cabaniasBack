package com.nicolas.cabanias.luluni.cabanias_luluni.services;

import org.springframework.web.multipart.MultipartFile;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Foto;

public interface FotoService {
    void guardarFoto(Long cabaniaId, MultipartFile file);
    Foto obtenerFotoEntity(Long fotoId);
}

