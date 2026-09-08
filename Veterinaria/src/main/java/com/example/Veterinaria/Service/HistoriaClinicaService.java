package com.example.Veterinaria.Service;

import com.example.Veterinaria.Entity.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaService {
    List<HistoriaClinica>listarTodas();

    HistoriaClinica buscarporId(Long id);

    HistoriaClinica guardar(HistoriaClinica historiaClinica, Long mascotaId);

    HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica);

    void eliminar(Long id);


}
