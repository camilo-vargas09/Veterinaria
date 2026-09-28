package com.example.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.*;

@Entity
@Table(name = "Veterinario")
@Data
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 20)
    @Column(name = "nombre" , nullable = false)
    private String nombre;

    @NotBlank(message = "El tarjeta profesional es obligatoria")
    @Size(min = 3, max = 10)
    @Column(name = "tarjetaProfesional" , nullable = false)
    private String tarjetaProfesional;

    @NotBlank(message = "La especialidad es obligatoria")
    @Column(name = "especialidad" , nullable = false)
    private String especialidad;

    @NotBlank(message = "El correo no puede estar en blanco")
    @Email
    @Column(unique = true , nullable = false)
    private String correo;


    @ManyToMany(mappedBy = "veterinarios")
    private List<Mascota> mascotas;
}
