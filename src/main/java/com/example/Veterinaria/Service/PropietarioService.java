package com.example.Veterinaria.Service;


import com.example.Veterinaria.Entity.Propietario;

import java.util.List;

public interface PropietarioService {

    List<Propietario> listarTodas();

    Propietario buscarporId(Long id);

    Propietario guardar(Propietario propietario);

    Propietario actualizar(Long id, Propietario propietario);

    void eliminar(Long id);
}

