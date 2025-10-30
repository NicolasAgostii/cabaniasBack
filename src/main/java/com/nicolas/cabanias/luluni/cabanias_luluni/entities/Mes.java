package com.nicolas.cabanias.luluni.cabanias_luluni.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "meses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "calendario_id")
    @JsonBackReference
    private Calendario calendario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mes_id")
    @JsonManagedReference
    private List<Dia> dias;
}
