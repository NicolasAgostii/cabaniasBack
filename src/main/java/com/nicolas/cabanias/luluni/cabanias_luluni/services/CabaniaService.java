package com.nicolas.cabanias.luluni.cabanias_luluni.services;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Cabania;

import java.util.List;

public interface CabaniaService {
    Cabania crearCabania(Cabania cabania);
    List<Cabania> obtenerTodas();
}
