package org.binaryminds.agenda_personal.dominio.service;

import org.binaryminds.agenda_personal.persistence.crud.UsuarioCrud;
import org.binaryminds.agenda_personal.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioCrud crud;

    @Override
    public Usuario registrarUsuario(String nombreUsuario, String telefono, String correo, String pass){
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setTelefono(telefono);
        usuario.setCorreo(correo);
        usuario.setPass(pass);
        return crud.save(usuario);
    }

    @Override
    public boolean login(String nombreUsuario, String pass){
        Usuario usuario = crud.findByNombreUsuario(nombreUsuario).orElse(null);
        return usuario != null && usuario.getPass().equals(pass);
    }
}
