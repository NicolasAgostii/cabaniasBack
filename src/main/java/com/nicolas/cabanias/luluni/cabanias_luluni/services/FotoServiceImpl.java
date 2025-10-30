package com.nicolas.cabanias.luluni.cabanias_luluni.services;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Cabania;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Foto;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.CabaniaRepository;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.FotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FotoServiceImpl implements FotoService {

    private final FotoRepository fotoRepository;
    private final CabaniaRepository cabaniaRepository;

public Foto obtenerFotoEntity(Long fotoId) {
    return fotoRepository.findById(fotoId).orElseThrow();
}


public void guardarFoto(Long id, MultipartFile file) {
    Cabania cabania = cabaniaRepository.findById(id).orElseThrow();
    try {
        Foto foto = new Foto();
        foto.setData(file.getBytes());
        foto.setCabania(cabania);
        fotoRepository.save(foto);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}

