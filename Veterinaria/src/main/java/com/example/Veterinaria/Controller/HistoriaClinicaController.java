package com.example.Veterinaria.Controller;

import com.example.Veterinaria.Service.HistoriaClinicaService;
import com.example.Veterinaria.Entity.HistoriaClinica;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/HistoriaClinica")
@AllArgsConstructor
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;


    @PostMapping("/guardar")
    public ResponseEntity<HistoriaClinica> guardar(@RequestBody HistoriaClinica historiaClinica, @RequestParam Long mascotaId) {
        HistoriaClinica nuevaHistoria = historiaClinicaService.guardar(historiaClinica,mascotaId);
        return new ResponseEntity<>(nuevaHistoria, HttpStatus.CREATED);
    }

    @GetMapping("/obtener")
    public ResponseEntity<List<HistoriaClinica>> listarTodas() {
        List<HistoriaClinica> lista = historiaClinicaService.listarTodas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<HistoriaClinica> obtenerPorId(@PathVariable Long id) {
        HistoriaClinica historia = historiaClinicaService.buscarporId(id);
        return ResponseEntity.ok(historia);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HistoriaClinica> actualizar(@PathVariable Long id, @RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica actualizada = historiaClinicaService.actualizar(id, historiaClinica);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historiaClinicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}