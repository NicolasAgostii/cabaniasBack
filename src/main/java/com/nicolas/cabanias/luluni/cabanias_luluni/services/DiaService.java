package com.nicolas.cabanias.luluni.cabanias_luluni.services;


import java.util.List;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.DiaDTO;

public interface DiaService {
    List<DiaDTO> findAll();
    DiaDTO findById(Long id);
    DiaDTO create(DiaDTO dto);
    DiaDTO reservar(Long id, String nombreInquilino, String numeroContacto);
    DiaDTO reservarManiana(Long id, String nombreInquilino, String numeroContacto);
    DiaDTO reservarTarde(Long id, String nombreInquilino, String numeroContacto);
}
