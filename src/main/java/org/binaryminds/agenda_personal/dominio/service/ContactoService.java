package org.binaryminds.agenda_personal.dominio.service;


import org.binaryminds.agenda_personal.persistence.crud.ContactoCrud;
import org.binaryminds.agenda_personal.persistence.entity.Contacto;
import org.binaryminds.agenda_personal.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService implements IContactoService{

    @Autowired
    private ContactoCrud crud;

    @Override
    public List<Contacto> listarContactosPorUsuario(Usuario usuario) {
        return crud.findByUsuario(usuario);
    }

    @Override
    public Contacto buscarContactoPorNombre(String nombre, Usuario usuario) {
        return crud.findByNombreAndUsuario(nombre, usuario).orElse(null);
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        crud.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        crud.delete(contacto);
    }
}
