package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.SeguroDTO;
import co.edu.udistrital.mdp.carmotor.services.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @PostMapping
    public ResponseEntity<SeguroDTO> create(@RequestBody SeguroDTO dto) {
        return ResponseEntity.ok(seguroService.createSeguro(dto));
    }

    @GetMapping
    public List<SeguroDTO> getAll() {
        return seguroService.getSeguros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(seguroService.getSeguro(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguroDTO> update(@PathVariable Long id, @RequestBody SeguroDTO dto) {
        return ResponseEntity.ok(seguroService.updateSeguro(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        seguroService.deleteSeguro(id);
        return ResponseEntity.noContent().build();
    }
}
