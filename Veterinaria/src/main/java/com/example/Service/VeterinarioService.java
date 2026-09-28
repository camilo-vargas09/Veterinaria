package com.example.Service;


import com.example.Entity.Veterinario;

import java.util.List;

public interface VeterinarioService {

    List<Veterinario> listarTodas();

    Veterinario buscarporId(Long id);

    Veterinario guardar(Veterinario veterinario, Long mascotaId);

    Veterinario actualizar(Long id, Veterinario veterinario);

    void eliminar(Long id);

    Veterinario asociarMascota(Long veterinarioId, Long mascotaId);
}
