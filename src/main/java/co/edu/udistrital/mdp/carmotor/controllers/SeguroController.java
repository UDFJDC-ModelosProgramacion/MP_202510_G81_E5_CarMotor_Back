package co.edu.udistrital.mdp.carmotor.controllers;
<<<<<<< HEAD

import co.edu.udistrital.mdp.carmotor.dto.SeguroDTO;
import co.edu.udistrital.mdp.carmotor.services.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
=======
import co.edu.udistrital.mdp.carmotor.entities.SeguroEntity;
import co.edu.udistrital.mdp.carmotor.services.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {
<<<<<<< HEAD
=======
    
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

    @Autowired
    private SeguroService seguroService;

<<<<<<< HEAD
    @PostMapping
    public ResponseEntity<SeguroDTO> create(@RequestBody SeguroDTO dto) {
        return ResponseEntity.ok(seguroService.createSeguro(dto));
    }

    @GetMapping
    public List<SeguroDTO> getAll() {
=======
    @GetMapping
    public List<SeguroEntity> getAllSeguros() {
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
        return seguroService.getSeguros();
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
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
=======
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
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
        return ResponseEntity.noContent().build();
    }
}
