package com.nicolas.cabanias.luluni.cabanias_luluni.services;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.MesDTO;
import java.util.List;

public interface MesService {
    List<MesDTO> findAll();
    MesDTO findById(Long id);
    MesDTO create(MesDTO dto);
    MesDTO agregarDia(Long id, Long diaId);
}
