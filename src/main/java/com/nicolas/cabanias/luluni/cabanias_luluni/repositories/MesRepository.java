package com.nicolas.cabanias.luluni.cabanias_luluni.repositories;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Mes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesRepository extends JpaRepository<Mes, Long> {
}
