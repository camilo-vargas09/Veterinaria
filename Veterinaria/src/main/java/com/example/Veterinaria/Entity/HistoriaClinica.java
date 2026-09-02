package com.example.Veterinaria.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Historia Clinica")
@Data
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaApertura;

    @NotBlank(message = "los antecedentes no pueden estar en blanco")
    private String antecedentes;

    @NotBlank(message = "las observaciones no pueden estar en blanco")
    private String observaciones;


    @OneToOne
    @JoinColumn(name = "mascota_id", nullable = false, unique = true)
    private Mascota mascota;

}
