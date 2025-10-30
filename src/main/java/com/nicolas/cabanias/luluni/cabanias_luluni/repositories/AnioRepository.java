package com.nicolas.cabanias.luluni.cabanias_luluni.repositories;

import com.nicolas.cabanias.luluni.cabanias_luluni.entities.Anio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface AnioRepository extends JpaRepository<Anio, Long> {
    List<Anio> findByNumero(Integer numero);
    Optional<Anio> findByNumeroAndCalendario_Id(Integer numero, Long calendarioId);
}
