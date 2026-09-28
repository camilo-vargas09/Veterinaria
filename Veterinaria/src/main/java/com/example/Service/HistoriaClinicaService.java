package com.example.Service;

import com.example.Entity.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaService {
    List<HistoriaClinica>listarTodas();

    HistoriaClinica buscarporId(Long id);

    HistoriaClinica guardar(HistoriaClinica historiaClinica, Long mascotaId);

    HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica);

    void eliminar(Long id);


}
