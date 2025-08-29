package org.binaryminds.agenda_personal.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.binaryminds.agenda_personal.dominio.service.IContactoService;
import org.binaryminds.agenda_personal.persistence.entity.Contacto;
import org.binaryminds.agenda_personal.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class AgendaController {

    @Autowired
    private IContactoService contactoService;

    @Autowired
    private LoginController loginController;

    private List<Contacto> contactos;
    private Contacto contactoSeleccionado;

    @PostConstruct
    public void init() {
        cargarContactos();
    }

    public void cargarContactos() {
        Usuario usuarioLogeado = loginController.getUsuarioLogeado();
        if (usuarioLogeado != null) {
            this.contactos = contactoService.listarContactosPorUsuario(usuarioLogeado);
        }
    }

    public void nuevoContacto() {
        this.contactoSeleccionado = new Contacto();
    }

    public void guardarContacto() {
        Usuario usuarioLogeado = loginController.getUsuarioLogeado();
        if (usuarioLogeado != null && contactoSeleccionado != null) {
            contactoSeleccionado.setUsuario(usuarioLogeado);
            contactoService.guardarContacto(contactoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contacto agregado"));
            cargarContactos();
        }
    }


    public void eliminarContacto(Contacto contacto) {
        contactoService.eliminarContacto(contacto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contacto Eliminado"));
        cargarContactos();
    }
}
