package com.nicolas.cabanias.luluni.cabanias_luluni.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaDTO {
    private Long id;
    private Integer numero;

    private Boolean ocupadoALaManiana;
    private Boolean ocupadoALaTarde;

    private String nombreInquilinoManiana;
    private String numeroContactoManiana;

    private String nombreInquilinoTarde;
    private String numeroContactoTarde;
}
