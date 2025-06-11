package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.TallerDTO;
import co.edu.udistrital.mdp.carmotor.services.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talleres")
public class TallerController {

    @Autowired
    private TallerService tallerService;

    @PostMapping
    public ResponseEntity<TallerDTO> create(@RequestBody TallerDTO dto) {
        return ResponseEntity.ok(tallerService.createTaller(dto));
    }

    @GetMapping
    public List<TallerDTO> getAll() {
        return tallerService.getTalleres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TallerDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tallerService.getTaller(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TallerDTO> update(@PathVariable Long id, @RequestBody TallerDTO dto) {
        return ResponseEntity.ok(tallerService.updateTaller(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tallerService.deleteTaller(id);
        return ResponseEntity.noContent().build();
    }
}
