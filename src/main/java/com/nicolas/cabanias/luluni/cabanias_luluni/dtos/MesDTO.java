package com.nicolas.cabanias.luluni.cabanias_luluni.dtos;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Dia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesDTO {
    private Long id;
    private String nombre;
    private List<Dia> dias;
}
