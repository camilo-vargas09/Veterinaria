package com.example.Service;


import com.example.Entity.Propietario;

import java.util.List;

public interface PropietarioService {

    List<Propietario> listarTodas();

    Propietario buscarporId(Long id);

    Propietario guardar(Propietario propietario);

    Propietario actualizar(Long id, Propietario propietario);

    void eliminar(Long id);
}

