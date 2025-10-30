package com.nicolas.cabanias.luluni.cabanias_luluni.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "calendarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "calendario_id")
    @JsonManagedReference
    private List<Anio> anios; // Ahora contiene objetos Anio, no solo enteros

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "calendario_id")
    @JsonManagedReference
    private List<Mes> meses;
}
