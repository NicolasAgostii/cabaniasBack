package com.nicolas.cabanias.luluni.cabanias_luluni.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "cabania")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cabania {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer precio;
    private Integer capacidad;
    private String descripcion;

@OneToMany(mappedBy = "cabania", cascade = CascadeType.ALL, orphanRemoval = true)
@org.springframework.data.annotation.Transient
private List<Foto> fotos;

}
