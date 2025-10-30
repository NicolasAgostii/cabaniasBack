package com.nicolas.cabanias.luluni.cabanias_luluni.repositories;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
}