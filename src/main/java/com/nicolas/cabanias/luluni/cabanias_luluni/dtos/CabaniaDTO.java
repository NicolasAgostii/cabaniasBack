package com.nicolas.cabanias.luluni.cabanias_luluni.dtos;

import java.util.List;
import lombok.Data;

@Data
public class CabaniaDTO {
    private Long id;
    private Integer precio;
    private Integer capacidad;
    private String descripcion;
    private List<String> fotoUrls;
}
