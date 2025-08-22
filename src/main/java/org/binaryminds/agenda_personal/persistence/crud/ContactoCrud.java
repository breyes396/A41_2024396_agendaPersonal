package org.binaryminds.agenda_personal.persistence.crud;

import org.binaryminds.agenda_personal.persistence.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoCrud extends JpaRepository<Contacto, Integer> {
}
