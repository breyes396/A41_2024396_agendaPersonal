package org.binaryminds.agenda_personal.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer id;

    @Column(name = "usuario")
    private String nombreUsuario;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "pass")
    private String pass;
}
