package org.binaryminds.agenda_personal.persistence.crud;

import org.binaryminds.agenda_personal.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioCrud extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String usuario);
}
