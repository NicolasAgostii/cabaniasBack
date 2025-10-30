package com.nicolas.cabanias.luluni.cabanias_luluni.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;

    private String nombreInquilinoManiana;
    private String numeroContactoManiana;
    private String nombreInquilinoTarde;
    private String numeroContactoTarde;

    private Boolean ocupadoALaManiana = false;
    private Boolean ocupadoALaTarde = false;

    @ManyToOne
    @JoinColumn(name = "mes_id")
    @JsonBackReference
    private Mes mes;

    public void reservar() {
        this.ocupadoALaManiana = true;
        this.ocupadoALaTarde = true;
    }

    public void reservarALaManiana() {
        this.ocupadoALaManiana = true;
    }

    public void reservarALaTarde() {
        this.ocupadoALaTarde = true;
    }
}
