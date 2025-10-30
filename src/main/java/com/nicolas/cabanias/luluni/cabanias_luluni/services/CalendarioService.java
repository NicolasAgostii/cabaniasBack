package com.nicolas.cabanias.luluni.cabanias_luluni.services;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.CalendarioDTO;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Mes;

import java.util.List;

public interface CalendarioService {
    List<CalendarioDTO> findAll();
    CalendarioDTO findById(Long id);
    CalendarioDTO create(CalendarioDTO dto);
    CalendarioDTO agregarMes(Long calendarioId, Long mesId);
    List<Integer> getAniosByCalendario(Long id);
    List<Mes> getMesesPorAnio(Long calendarioId, Integer anioNumero);

}
