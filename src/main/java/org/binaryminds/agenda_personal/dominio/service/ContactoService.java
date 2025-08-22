package org.binaryminds.agenda_personal.dominio.service;


import org.binaryminds.agenda_personal.persistence.crud.ContactoCrud;
import org.binaryminds.agenda_personal.persistence.entity.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService implements IContactoService{

    @Autowired
    private ContactoCrud crud;

    @Override
    public List<Contacto> listarContactos() {
        return List.of();
    }

    @Override
    public Contacto buscarContactoPorNombre(String nombre) {
        return null;
    }

    @Override
    public void guardarContacto(Contacto contacto) {

    }

    @Override
    public void eliminarContacto(Contacto contacto) {

    }
}
