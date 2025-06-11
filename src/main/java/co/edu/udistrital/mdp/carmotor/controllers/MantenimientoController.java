package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.MantenimientoDTO;
import co.edu.udistrital.mdp.carmotor.services.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mantenimientos")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @PostMapping
    public ResponseEntity<MantenimientoDTO> create(@RequestBody MantenimientoDTO dto) {
        return ResponseEntity.ok(mantenimientoService.createMantenimiento(dto));
    }

    @GetMapping
    public List<MantenimientoDTO> getAll() {
        return mantenimientoService.getMantenimientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MantenimientoDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mantenimientoService.getMantenimiento(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MantenimientoDTO> update(@PathVariable Long id, @RequestBody MantenimientoDTO dto) {
        return ResponseEntity.ok(mantenimientoService.updateMantenimiento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mantenimientoService.deleteMantenimiento(id);
        return ResponseEntity.noContent().build();
    }
}