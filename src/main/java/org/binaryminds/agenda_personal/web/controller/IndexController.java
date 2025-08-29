package org.binaryminds.agenda_personal.web.controller;


import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ViewScoped
public class IndexController {
    private String mensaje = "Bienvenido a tu agenda de contactos personal";

    public String irLogin(){
        return "login.xhtml?faces-redirect=true";
    }

    public String irRegistro(){
        return "registro.xhtml?faces-redirect=true";
    }

    public String irAcercaDe(){
        return "acercade.xhtml?faces-redirect=true";
    }
}
