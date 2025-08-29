package org.binaryminds.agenda_personal.dominio.service;

import org.binaryminds.agenda_personal.persistence.entity.Contacto;
import org.binaryminds.agenda_personal.persistence.entity.Usuario;

import java.util.List;

public interface IContactoService {
    List<Contacto> listarContactosPorUsuario(Usuario usuario);
    Contacto buscarContactoPorNombre(String nombre, Usuario usuario);
    void guardarContacto(Contacto contacto);
    void eliminarContacto(Contacto contacto);
}
