package org.binaryminds.agenda_personal.web.controller;

import org.binaryminds.agenda_personal.dominio.service.IUsuarioService;
import org.binaryminds.agenda_personal.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import lombok.Data;

@Component
@SessionScope
@Data
public class LoginController {

    @Autowired
    private IUsuarioService usuarioService;

    private String nombreUsuario;
    private String pass;
    private String mensaje;

    private Usuario usuarioLogeado;


    public String login() {
        usuarioLogeado = usuarioService.login(nombreUsuario, pass);
        if (usuarioLogeado != null) {
            mensaje = "Inicio de sesión exitoso";

            return "agenda.xhtml?faces-redirect=true";
        } else {
            mensaje = "Usuario o contraseña incorrectos";
            return null;
        }
    }

    public String logout() {
        usuarioLogeado = null;
        nombreUsuario = null;
        pass = null;
        mensaje = "Sesión cerrada correctamente";
        return "index.xhtml?faces-redirect=true";
    }
}
