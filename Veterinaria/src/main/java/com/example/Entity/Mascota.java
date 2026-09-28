package com.example.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@Entity
@Table(name ="Mascota")
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 20)
    @Column(name = "nombre" , nullable = false)
    private String nombre;

    private String especie;
    private String raza;
    private Integer edad;
    private double peso;


    @ManyToOne
    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "propietario_id", nullable = false)
    private Propietario propietario;


    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    private HistoriaClinica historiaClinica;


    @ManyToMany
    @JoinTable(
            name = "mascota_veterinario",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "veterinario_id")
    )
    @JsonIgnoreProperties("mascotas")
    private List<Veterinario> veterinarios;
}