package com.nicolas.cabanias.luluni.cabanias_luluni.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "anios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Anio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "calendario_id")
    @JsonBackReference
    private Calendario calendario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "anio_id")
    @JsonManagedReference
    private List<Mes> meses;
}
