package com.nicolas.cabanias.luluni.cabanias_luluni.services;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.MesDTO;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Dia;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Mes;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.DiaRepository;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.MesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MesServiceImpl implements MesService {

    private final MesRepository mesRepository;
    private final DiaRepository diaRepository;

    @Override
    public List<MesDTO> findAll() {
        return mesRepository.findAll()
                .stream()
                .map(m -> new MesDTO(m.getId(), m.getNombre(), m.getDias()))
                .collect(Collectors.toList());
    }

    @Override
    public MesDTO findById(Long id) {
        Mes mes = mesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mes no encontrado"));
        return new MesDTO(mes.getId(), mes.getNombre(), mes.getDias());
    }

    @Override
    public MesDTO create(MesDTO dto) {
        Mes mes = new Mes();
        mes.setNombre(dto.getNombre());
        mes.setDias(dto.getDias());
        mesRepository.save(mes);
        return new MesDTO(mes.getId(), mes.getNombre(), mes.getDias());
    }

    @Override
    public MesDTO agregarDia(Long id, Long diaId) {
        Mes mes = mesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mes no encontrado"));
        Dia dia = diaRepository.findById(diaId)
                .orElseThrow(() -> new RuntimeException("Día no encontrado"));
        mes.getDias().add(dia);
        mesRepository.save(mes);
        return new MesDTO(mes.getId(), mes.getNombre(), mes.getDias());
    }
}
