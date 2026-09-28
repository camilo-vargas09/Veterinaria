package com.example.Service.ServiceImp;

import com.example.Entity.HistoriaClinica;
import com.example.Entity.Mascota;
import com.example.Repository.HistoriaClinicaRepository;
import com.example.Repository.MascotaRepository;
import com.example.Service.HistoriaClinicaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoriaClinicaImp implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;
    private final MascotaRepository mascotaRepository;

    @Override
    public List<HistoriaClinica> listarTodas() {
        return historiaClinicaRepository.findAll();
    }

    @Override
    public HistoriaClinica buscarporId(Long id) {
        return historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada con el id: " + id));
    }

    @Override
    public HistoriaClinica guardar(HistoriaClinica historiaClinica, Long mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con el ID: " + mascotaId));
        historiaClinica.setMascota(mascota);
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public HistoriaClinica actualizar(Long id, HistoriaClinica historiaActualizada) {

        HistoriaClinica existente = buscarporId(id);

        existente.setAntecedentes(historiaActualizada.getAntecedentes());
        existente.setObservaciones(historiaActualizada.getObservaciones());
        existente.setFechaApertura(historiaActualizada.getFechaApertura());

        if (historiaActualizada.getMascota() != null) {
            existente.setMascota(historiaActualizada.getMascota());
        }
        return historiaClinicaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        HistoriaClinica existente = buscarporId(id);
        historiaClinicaRepository.delete(existente);
    }
}
