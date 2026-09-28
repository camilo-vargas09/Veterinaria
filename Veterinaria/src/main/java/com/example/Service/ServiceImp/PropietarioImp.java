package com.example.Service.ServiceImp;

import com.example.Entity.Propietario;
import com.example.Repository.PropietarioRepository;
import com.example.Service.PropietarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropietarioImp implements PropietarioService {

    private final PropietarioRepository propietarioRepository;


    @Override
    public List<Propietario> listarTodas() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario buscarporId(Long id) {
        return propietarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado con el id: " + id));
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario actualizar(Long id, Propietario propietarioActualizado) {

        Propietario existente = buscarporId(id);

        existente.setNombre(propietarioActualizado.getNombre());
        existente.setTelefono(propietarioActualizado.getTelefono());
        existente.setCorreo(propietarioActualizado.getCorreo());

        if (propietarioActualizado.getMascotas() != null && !propietarioActualizado.getMascotas().isEmpty()) {
            existente.setMascotas(propietarioActualizado.getMascotas());
        }
        return propietarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Propietario existente = buscarporId(id);
        propietarioRepository.delete(existente);
    }
}