package org.binaryminds.agenda_personal.dominio.service;

import org.binaryminds.agenda_personal.persistence.entity.Contacto;

import java.util.List;

public interface IContactoService {
    List<Contacto> listarContactos();
    Contacto buscarContactoPorNombre(String nombre);
    void guardarContacto(Contacto contacto);
    void eliminarContacto(Contacto contacto);
}
