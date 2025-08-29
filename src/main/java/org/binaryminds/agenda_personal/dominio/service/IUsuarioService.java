package org.binaryminds.agenda_personal.dominio.service;

import org.binaryminds.agenda_personal.persistence.entity.Usuario;

public interface IUsuarioService {
    Usuario registrarUsuario(String nombreUsuario, String telefono, String correo, String pass);
    Usuario login(String nombreUsuario, String pass);
}
