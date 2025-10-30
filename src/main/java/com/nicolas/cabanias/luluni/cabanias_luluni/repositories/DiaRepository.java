package com.nicolas.cabanias.luluni.cabanias_luluni.repositories;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Dia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {
}
