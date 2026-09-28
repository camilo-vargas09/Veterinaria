package com.example.Veterinaria.Controller;

import com.example.Veterinaria.Entity.Propietario;
import com.example.Veterinaria.Service.PropietarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Propietario")
@AllArgsConstructor
public class PropietarioController {

    private final PropietarioService propietarioService;

    @PostMapping("/guardar")
    public ResponseEntity<Propietario> guardar(@RequestBody Propietario propietario) {
        Propietario nuevoPropietario = propietarioService.guardar(propietario);
        return new ResponseEntity<>(nuevoPropietario, HttpStatus.CREATED);
    }

    @GetMapping("/obtener")
    public ResponseEntity<List<Propietario>> listarTodas() {
        List<Propietario> lista = propietarioService.listarTodas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Propietario> obtenerPorId(@PathVariable Long id) {
        Propietario propietario = propietarioService.buscarporId(id);
        return ResponseEntity.ok(propietario);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Propietario> actualizar(@PathVariable Long id, @RequestBody Propietario propietario) {
        Propietario actualizado = propietarioService.actualizar(id, propietario);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}