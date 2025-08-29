package org.binaryminds.agenda_personal.web.controller;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.binaryminds.agenda_personal.dominio.service.IUsuarioService;
import org.binaryminds.agenda_personal.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@ViewScoped
public class RegistroController {

    @Autowired
    private IUsuarioService usuarioService;

    private String nombreUsuario;
    private String telefono;
    private String correo;
    private String pass;
    private String mensaje;

    public String registrar() {
        Usuario usuario = usuarioService.registrarUsuario(nombreUsuario, telefono, correo, pass);
        if (usuario != null) {
            mensaje = "Usuario registrado correctamente";
            return "login.xhtml?faces-redirect=true";
        } else {
            mensaje = "Error al registrar usuario";
            return null;
        }
    }
}
