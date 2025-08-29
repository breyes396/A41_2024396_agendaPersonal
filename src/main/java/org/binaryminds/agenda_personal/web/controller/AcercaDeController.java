package org.binaryminds.agenda_personal.web.controller;

import org.springframework.stereotype.Component;
import lombok.Data;
import jakarta.faces.view.ViewScoped;

@Component
@Data
@ViewScoped
public class AcercaDeController {
    public String volverIndex() {
        return "index.xhtml?faces-redirect=true";
    }
}
