package com.nicolas.cabanias.luluni.cabanias_luluni.repositories;


import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Cabania;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CabaniaRepository extends JpaRepository<Cabania, Long> {
    @Query("select distinct c from Cabania c left join fetch c.fotos")
    List<Cabania> findAllWithFotos();
}
