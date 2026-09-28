package com.example.Service.ServiceImp;

import com.example.Entity.Mascota;
import com.example.Entity.Propietario;
import com.example.Repository.MascotaRepository;
import com.example.Repository.PropietarioRepository;
import com.example.Service.MascotaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MascotaImp implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;

    @Override
    public List<Mascota> listarTodas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota buscarporId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con el id: " + id));
    }

    @Override
    public Mascota guardar(Mascota mascota, Long propietarioId) {

        Propietario propietario = propietarioRepository.findById(propietarioId)
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado con el ID: " + propietarioId));
        mascota.setPropietario(propietario);

        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota actualizar(Long id, Mascota mascotaActualizada) {

        Mascota mascotaExistente = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con el ID: " + id));
        mascotaExistente.setNombre(mascotaActualizada.getNombre());
        mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
        mascotaExistente.setRaza(mascotaActualizada.getRaza());
        mascotaExistente.setEdad(mascotaActualizada.getEdad());
        mascotaExistente.setPeso(mascotaActualizada.getPeso());
        if (mascotaActualizada.getPropietario() != null) {
            mascotaExistente.setPropietario(mascotaActualizada.getPropietario());
        }
        return mascotaRepository.save(mascotaExistente);
    }

    @Override
    public void eliminar(Long id) {
        Mascota existente = buscarporId(id);
        mascotaRepository.delete(existente);

    }
}
