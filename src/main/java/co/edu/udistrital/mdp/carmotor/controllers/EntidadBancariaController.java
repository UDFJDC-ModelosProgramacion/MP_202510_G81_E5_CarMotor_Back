package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.EntidadBancariaDTO;
import co.edu.udistrital.mdp.carmotor.services.EntidadBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entidades-bancarias")
public class EntidadBancariaController {

    @Autowired
    private EntidadBancariaService entidadBancariaService;

    @PostMapping
    public ResponseEntity<EntidadBancariaDTO> create(@RequestBody EntidadBancariaDTO dto) {
        return ResponseEntity.ok(entidadBancariaService.createEntidad(dto));
    }

    @GetMapping
    public List<EntidadBancariaDTO> getAll() {
        return entidadBancariaService.getEntidades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadBancariaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(entidadBancariaService.getEntidad(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadBancariaDTO> update(@PathVariable Long id, @RequestBody EntidadBancariaDTO dto) {
        return ResponseEntity.ok(entidadBancariaService.updateEntidad(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entidadBancariaService.deleteEntidad(id);
        return ResponseEntity.noContent().build();
    }
}
