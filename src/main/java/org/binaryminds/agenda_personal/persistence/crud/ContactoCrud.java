package org.binaryminds.agenda_personal.persistence.crud;

import org.binaryminds.agenda_personal.persistence.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactoCrud extends JpaRepository<Contacto, Integer> {
    Optional<Contacto> findByNombre(String nombre);
}
