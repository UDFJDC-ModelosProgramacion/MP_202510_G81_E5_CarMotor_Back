package co.edu.udistrital.mdp.carmotor.controllers;
<<<<<<< HEAD

import co.edu.udistrital.mdp.carmotor.dto.TallerDTO;
import co.edu.udistrital.mdp.carmotor.services.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
=======
import co.edu.udistrital.mdp.carmotor.entities.TallerEntity;
import co.edu.udistrital.mdp.carmotor.services.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talleres")
public class TallerController {
<<<<<<< HEAD
=======
    
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

    @Autowired
    private TallerService tallerService;

<<<<<<< HEAD
    @PostMapping
    public ResponseEntity<TallerDTO> create(@RequestBody TallerDTO dto) {
        return ResponseEntity.ok(tallerService.createTaller(dto));
    }

    @GetMapping
    public List<TallerDTO> getAll() {
=======
    @GetMapping
    public List<TallerEntity> getAllTalleres() {
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
        return tallerService.getTalleres();
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
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
=======
    public ResponseEntity<?> getTallerById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tallerService.getTaller(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createTaller(@RequestBody TallerEntity taller) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(tallerService.createTaller(taller));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear taller: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTaller(@PathVariable Long id, @RequestBody TallerEntity taller) {
        try {
            return ResponseEntity.ok(tallerService.updateTaller(id, taller));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaller(@PathVariable Long id) {
        try {
            tallerService.deleteTaller(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/buscar/direccion")
    public List<TallerEntity> findByDireccion(@RequestParam String direccion) {
        return tallerService.findByDireccion(direccion);
    }

    @GetMapping("/buscar/horario")
    public List<TallerEntity> findByHorario(@RequestParam String horario) {
        return tallerService.findByHorario(horario);
    }

    @GetMapping("/buscar/numero")
    public List<TallerEntity> findByNumero(@RequestParam String numero) {
        return tallerService.findByNumero(numero);
    }

    @DeleteMapping("/eliminar/direccion")
    public ResponseEntity<?> deleteByDireccion(@RequestParam String direccion) {
        tallerService.deleteByDireccion(direccion);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/horario")
    public ResponseEntity<?> deleteByHorario(@RequestParam String horario) {
        tallerService.deleteByHorario(horario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/numero")
    public ResponseEntity<?> deleteByNumero(@RequestParam String numero) {
        tallerService.deleteByNumero(numero);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/id")
    public ResponseEntity<?> deleteByIdCustom(@RequestParam Long id) {
        tallerService.deleteByIdCustom(id);
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
        return ResponseEntity.noContent().build();
    }
}
