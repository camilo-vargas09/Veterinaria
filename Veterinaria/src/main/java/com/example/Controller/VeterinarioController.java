package com.example.Controller;

import com.example.Entity.Veterinario;
import com.example.Service.VeterinarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Veterinario")
@AllArgsConstructor
public class VeterinarioController {

        private final VeterinarioService veterinarioService;

    @PostMapping("/guardar")
    public ResponseEntity<Veterinario> guardar(
            @RequestBody Veterinario veterinario,
            @RequestParam Long mascotaId) {

        Veterinario nuevoVeterinario = veterinarioService.guardar(veterinario, mascotaId);
        return new ResponseEntity<>(nuevoVeterinario, HttpStatus.CREATED);
    }

        @GetMapping("/obtener")
        public ResponseEntity<List<Veterinario>> listarTodas() {
            List<Veterinario> lista = veterinarioService.listarTodas();
            return ResponseEntity.ok(lista);
        }

        @GetMapping("/buscar/{id}")
        public ResponseEntity<Veterinario> obtenerPorId(@PathVariable Long id) {
            Veterinario veterinario = veterinarioService.buscarporId(id);
            return ResponseEntity.ok(veterinario);
        }

        @PutMapping("/actualizar/{id}")
        public ResponseEntity<Veterinario> actualizar(@PathVariable Long id, @RequestBody Veterinario veterinario) {
            Veterinario actualizado = veterinarioService.actualizar(id, veterinario);
            return ResponseEntity.ok(actualizado);
        }

        @DeleteMapping("/eliminar/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            veterinarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
    @PostMapping("/{veterinarioId}/asociar-mascota/{mascotaId}")
    public ResponseEntity<Veterinario> asociarMascota(
            @PathVariable Long veterinarioId,
            @PathVariable Long mascotaId) {

        Veterinario veterinarioActualizado = veterinarioService.asociarMascota(veterinarioId, mascotaId);
        return ResponseEntity.ok(veterinarioActualizado);
    }
}
