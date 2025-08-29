package org.binaryminds.agenda_personal.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Contactos")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "usuario")
@EqualsAndHashCode

public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoContacto;
    @Column
    private String nombre;
    private String telefono;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private Usuario usuario;
}
