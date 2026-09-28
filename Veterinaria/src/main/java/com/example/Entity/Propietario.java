package com.example.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "propietario")
@Data
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 20)
    @Column(name = "nombre" , nullable = false)
    private String nombre;

    @NotBlank(message = "El documento es obligatorio")
    @Size(min = 8, max = 10)
    @Column(name = "documento" , nullable = false)
    private String documento;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(min = 10, max = 10)
    @Column(name = "telefono" , nullable = false)
    private String telefono;

    @NotBlank(message = "El correo no puede estar en blanco")
    @Email
    @Column(unique = true , nullable = false)
    private String correo;


    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas;


}
