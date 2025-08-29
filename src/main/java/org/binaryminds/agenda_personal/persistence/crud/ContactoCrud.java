package org.binaryminds.agenda_personal.persistence.crud;

import org.binaryminds.agenda_personal.persistence.entity.Contacto;
import org.binaryminds.agenda_personal.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactoCrud extends JpaRepository<Contacto, Integer> {
    List<Contacto> findByUsuario(Usuario usuario);
    Optional<Contacto> findByNombreAndUsuario(String nombre, Usuario usuario);
}
