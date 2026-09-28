package com.example.Service.ServiceImp;

import com.example.Entity.Mascota;
import com.example.Entity.Veterinario;
import com.example.Repository.MascotaRepository;
import com.example.Repository.VeterinarioRepository;
import com.example.Service.VeterinarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarioImp implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;
    private final MascotaRepository mascotaRepository;

    @Override
    public List<Veterinario> listarTodas() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario buscarporId(Long id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado con el id: " + id));
    }

    @Override
    public Veterinario guardar(Veterinario veterinario, Long mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con el ID: " + mascotaId));

        if (veterinario.getMascotas() == null) {
            veterinario.setMascotas(new ArrayList<>());
        }
        veterinario.getMascotas().add(mascota);

        return veterinarioRepository.save(veterinario);
    }

    @Override
    public Veterinario actualizar(Long id, Veterinario veterinarioActualizado) {

        Veterinario existente = buscarporId(id);

        existente.setNombre(veterinarioActualizado.getNombre());
        existente.setEspecialidad(veterinarioActualizado.getEspecialidad());
        existente.setCorreo(veterinarioActualizado.getCorreo());
        existente.setTarjetaProfesional(veterinarioActualizado.getTarjetaProfesional());

        if (veterinarioActualizado.getMascotas() != null && !veterinarioActualizado.getMascotas().isEmpty()) {
            existente.setMascotas(veterinarioActualizado.getMascotas());
        }
        return veterinarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Veterinario existente = buscarporId(id);
        veterinarioRepository.delete(existente);
    }

    @Override
    public Veterinario asociarMascota(Long veterinarioId, Long mascotaId) {

        Veterinario veterinario = buscarporId(veterinarioId);
        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con el ID: " + mascotaId));

        if (veterinario.getMascotas() == null) {
            veterinario.setMascotas(new ArrayList<>());
        }
        if (!veterinario.getMascotas().contains(mascota)) {
            veterinario.getMascotas().add(mascota);
        }
        if (mascota.getVeterinarios() == null) {
            mascota.setVeterinarios(new ArrayList<>());
        }
        if (!mascota.getVeterinarios().contains(veterinario)) {
            mascota.getVeterinarios().add(veterinario);
        }

        mascotaRepository.save(mascota);
        return veterinarioRepository.save(veterinario);
    }
}
