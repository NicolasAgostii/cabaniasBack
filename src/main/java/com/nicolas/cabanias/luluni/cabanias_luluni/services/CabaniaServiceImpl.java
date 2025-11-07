package com.nicolas.cabanias.luluni.cabanias_luluni.services;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Cabania;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.CabaniaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CabaniaServiceImpl implements CabaniaService {

    private final CabaniaRepository cabaniaRepository;

    @Override
    public Cabania crearCabania(Cabania cabania) {
        return cabaniaRepository.save(cabania);
    }

    public List<Cabania> findAllWithFotos() {
        return cabaniaRepository.findAllWithFotos();
    }

    @Override
    public List<Cabania> obtenerTodas() {
        return cabaniaRepository.findAll();
    }
}
