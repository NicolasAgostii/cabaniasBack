package com.nicolas.cabanias.luluni.cabanias_luluni.services;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.DiaDTO;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Dia;
import com.nicolas.cabanias.luluni.cabanias_luluni.exceptions.CabaniaOcupadaException;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.DiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiaServiceImpl implements DiaService {

    private final DiaRepository diaRepository;

    @Override
    public List<DiaDTO> findAll() {
        return diaRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DiaDTO findById(Long id) {
        Dia dia = diaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Día no encontrado"));
        return mapToDto(dia);
    }

    @Override
    public DiaDTO create(DiaDTO dto) {
        Dia dia = new Dia();
        dia.setNumero(dto.getNumero());
        dia.setOcupadoALaManiana(dto.getOcupadoALaManiana());
        dia.setOcupadoALaTarde(dto.getOcupadoALaTarde());
        dia.setNombreInquilinoManiana(dto.getNombreInquilinoManiana());
        dia.setNumeroContactoManiana(dto.getNumeroContactoManiana());
        dia.setNombreInquilinoTarde(dto.getNombreInquilinoTarde());
        dia.setNumeroContactoTarde(dto.getNumeroContactoTarde());
        diaRepository.save(dia);
        return mapToDto(dia);
    }

    @Override
    public DiaDTO reservar(Long id, String nombreInquilino, String numeroContacto) {
        Dia dia = diaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Día no encontrado"));

        if (dia.getOcupadoALaManiana() && dia.getOcupadoALaTarde()) {
            throw CabaniaOcupadaException.yaOcupada();
        }

        if (nombreInquilino == null || numeroContacto == null) {
            throw new IllegalArgumentException("Debe indicar el nombre y número del inquilino.");
        }

        dia.reservar();
        dia.setNombreInquilinoManiana(nombreInquilino);
        dia.setNumeroContactoManiana(numeroContacto);
        dia.setNombreInquilinoTarde(nombreInquilino);
        dia.setNumeroContactoTarde(numeroContacto);
        diaRepository.save(dia);

        return mapToDto(dia);
    }

    @Override
    public DiaDTO reservarManiana(Long id, String nombreInquilino, String numeroContacto) {
        Dia dia = diaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Día no encontrado"));

        if (dia.getOcupadoALaManiana()) {
            throw CabaniaOcupadaException.yaOcupadaEnLaManiana();
        }

        if (nombreInquilino == null || numeroContacto == null) {
            throw new IllegalArgumentException("Debe indicar el nombre y número del inquilino.");
        }

        dia.reservarALaManiana();
        dia.setNombreInquilinoManiana(nombreInquilino);
        dia.setNumeroContactoManiana(numeroContacto);
        diaRepository.save(dia);

        return mapToDto(dia);
    }

    @Override
    public DiaDTO reservarTarde(Long id, String nombreInquilino, String numeroContacto) {
        Dia dia = diaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Día no encontrado"));

        if (dia.getOcupadoALaTarde()) {
            throw CabaniaOcupadaException.yaOcupadaEnLaTarde();
        }

        if (nombreInquilino == null || numeroContacto == null) {
            throw new IllegalArgumentException("Debe indicar el nombre y número del inquilino.");
        }

        dia.reservarALaTarde();
        dia.setNombreInquilinoTarde(nombreInquilino);
        dia.setNumeroContactoTarde(numeroContacto);
        diaRepository.save(dia);

        return mapToDto(dia);
    }

    private DiaDTO mapToDto(Dia dia) {
        return new DiaDTO(
                dia.getId(),
                dia.getNumero(),
                dia.getOcupadoALaManiana(),
                dia.getOcupadoALaTarde(),
                dia.getNombreInquilinoManiana(),
                dia.getNumeroContactoManiana(),
                dia.getNombreInquilinoTarde(),
                dia.getNumeroContactoTarde()
        );
    }
}
