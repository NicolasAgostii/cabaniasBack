package com.nicolas.cabanias.luluni.cabanias_luluni.services;

import com.nicolas.cabanias.luluni.cabanias_luluni.dtos.CalendarioDTO;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Anio;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Calendario;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Mes;
import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Dia;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.CalendarioRepository;
import com.nicolas.cabanias.luluni.cabanias_luluni.repositories.MesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalendarioServiceImpl implements CalendarioService {

    private final CalendarioRepository calendarioRepository;
    private final MesRepository mesRepository;

    @Override
    public List<CalendarioDTO> findAll() {
        return calendarioRepository.findAll()
                .stream()
                .map(c -> new CalendarioDTO(c.getId(), c.getNombre(), c.getAnios(), c.getMeses()))
                .collect(Collectors.toList());
    }

    @Override
    public CalendarioDTO findById(Long id) {
        Calendario calendario = calendarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendario no encontrado"));
        return new CalendarioDTO(calendario.getId(), calendario.getNombre(), calendario.getAnios(), calendario.getMeses());
    }

    @Override
    public CalendarioDTO create(CalendarioDTO dto) {
        Calendario calendario = new Calendario();
        calendario.setNombre(dto.getNombre());

        // 🔹 Generar años completos (2025–2028)
        List<Anio> anios = new ArrayList<>();
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] nombresMeses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        for (int year : Arrays.asList(2025, 2026, 2027, 2028)) {
            Anio anio = new Anio();
            anio.setNumero(year);

            List<Mes> meses = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                Mes mes = new Mes();
                mes.setNombre(nombresMeses[i]);

                List<Dia> dias = new ArrayList<>();
                for (int j = 1; j <= diasPorMes[i]; j++) {
                    Dia dia = new Dia();
                    dia.setNumero(j);
                    dia.setOcupadoALaManiana(false);
                    dia.setOcupadoALaTarde(false);
                    dias.add(dia);
                }

                mes.setDias(dias);
                meses.add(mes);
            }

            anio.setMeses(meses);
            anios.add(anio);
        }

        calendario.setAnios(anios);
        calendarioRepository.save(calendario);

        return new CalendarioDTO(calendario.getId(), calendario.getNombre(), calendario.getAnios(), null);
    }

    @Override
    public CalendarioDTO agregarMes(Long calendarioId, Long mesId) {
        Calendario calendario = calendarioRepository.findById(calendarioId)
                .orElseThrow(() -> new RuntimeException("Calendario no encontrado"));
        Mes mes = mesRepository.findById(mesId)
                .orElseThrow(() -> new RuntimeException("Mes no encontrado"));
        calendario.getMeses().add(mes);
        calendarioRepository.save(calendario);
        return new CalendarioDTO(calendario.getId(), calendario.getNombre(), calendario.getAnios(), calendario.getMeses());
    }

    @Override
    public List<Integer> getAniosByCalendario(Long id) {
        Calendario calendario = calendarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendario no encontrado"));
        return calendario.getAnios()
                .stream()
                .map(Anio::getNumero)
                .collect(Collectors.toList());
    }

@Override
public List<Mes> getMesesPorAnio(Long calendarioId, Integer anioNumero) {
    Calendario calendario = calendarioRepository.findById(calendarioId)
            .orElseThrow(() -> new RuntimeException("Calendario no encontrado"));
    return calendario.getAnios().stream()
            .filter(a -> a.getNumero().equals(anioNumero))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Año no encontrado"))
            .getMeses();
}
}
