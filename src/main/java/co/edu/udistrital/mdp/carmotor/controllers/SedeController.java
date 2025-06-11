package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.SedeDTO;
import co.edu.udistrital.mdp.carmotor.services.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @PostMapping
    public ResponseEntity<SedeDTO> create(@RequestBody SedeDTO dto) {
        return ResponseEntity.ok(sedeService.createSede(dto));
    }

    @GetMapping
    public List<SedeDTO> getAll() {
        return sedeService.getSedes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SedeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sedeService.getSede(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SedeDTO> update(@PathVariable Long id, @RequestBody SedeDTO dto) {
        return ResponseEntity.ok(sedeService.updateSede(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sedeService.deleteSede(id);
        return ResponseEntity.noContent().build();
    }
}
