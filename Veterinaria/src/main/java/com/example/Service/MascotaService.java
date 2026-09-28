package com.example.Service;

import com.example.Entity.Mascota;

import java.util.List;

public interface MascotaService {

    List<Mascota> listarTodas();

    Mascota buscarporId(Long id);

    Mascota guardar(Mascota mascota,Long propietarioId);

    Mascota actualizar(Long id, Mascota mascota);

    void eliminar(Long id);
}
