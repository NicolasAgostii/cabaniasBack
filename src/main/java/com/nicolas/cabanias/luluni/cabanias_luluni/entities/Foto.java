package com.nicolas.cabanias.luluni.cabanias_luluni.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

@ManyToOne
@JoinColumn(name = "cabania_id")
@com.fasterxml.jackson.annotation.JsonBackReference
private Cabania cabania;

}
