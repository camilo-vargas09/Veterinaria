package com.example.Controller;

import com.example.Entity.Mascota;
import com.example.Repository.PropietarioRepository;
import com.example.Service.MascotaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Mascota")
@AllArgsConstructor
public class MascotaController {

    private final MascotaService mascotaService;
    private final PropietarioRepository propietarioRepository;

    @PostMapping("/guardar")
    public ResponseEntity<Mascota> guardar(
            @RequestBody Mascota mascota,
            @RequestParam Long propietarioId) {

        Mascota nuevaMascota = mascotaService.guardar(mascota, propietarioId);
        return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
    }

    @GetMapping("/obtener")
    public ResponseEntity<List<Mascota>> listarTodas() {
        List<Mascota> lista = mascotaService.listarTodas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Mascota> obtenerPorId(@PathVariable Long id) {
        Mascota mascota = mascotaService.buscarporId(id);
        return ResponseEntity.ok(mascota);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota actualizada = mascotaService.actualizar(id, mascota);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}