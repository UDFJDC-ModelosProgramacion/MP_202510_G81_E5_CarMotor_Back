package co.edu.udistrital.mdp.carmotor.controllers;
import co.edu.udistrital.mdp.carmotor.entities.SeguroEntity;
import co.edu.udistrital.mdp.carmotor.services.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {
    

    @Autowired
    private SeguroService seguroService;

    @GetMapping
    public List<SeguroEntity> getAllSeguros() {
        return seguroService.getSeguros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSeguroById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(seguroService.getSeguro(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createSeguro(@RequestBody SeguroEntity seguro) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(seguroService.createSeguro(seguro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear seguro: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeguro(@PathVariable Long id, @RequestBody SeguroEntity seguro) {
        try {
            return ResponseEntity.ok(seguroService.updateSeguro(id, seguro));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeguro(@PathVariable Long id) {
        try {
            seguroService.deleteSeguro(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/buscar/valor-anual")
    public List<SeguroEntity> findByValorAnual(@RequestParam String valorAnual) {
        return seguroService.findByValorAnual(valorAnual);
    }

    @GetMapping("/buscar/entidad-aseguradora")
    public List<SeguroEntity> findByEntidadAseguradora(@RequestParam String entidadAseguradora) {
        return seguroService.findByEntidadAseguradora(entidadAseguradora);
    }

    @DeleteMapping("/eliminar/valor-anual")
    public ResponseEntity<?> deleteByValorAnual(@RequestParam String valorAnual) {
        seguroService.deleteByValorAnual(valorAnual);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/entidad-aseguradora")
    public ResponseEntity<?> deleteByEntidadAseguradora(@RequestParam String entidadAseguradora) {
        seguroService.deleteByEntidadAseguradora(entidadAseguradora);
        return ResponseEntity.noContent().build();
    }
}
