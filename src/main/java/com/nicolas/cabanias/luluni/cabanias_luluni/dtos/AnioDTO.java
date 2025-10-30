package com.nicolas.cabanias.luluni.cabanias_luluni.dtos;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Mes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnioDTO {
    private Long id;
    private Integer numero;
    private List<Mes> meses;
}
