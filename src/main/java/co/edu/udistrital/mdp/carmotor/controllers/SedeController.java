package co.edu.udistrital.mdp.carmotor.controllers;
<<<<<<< HEAD

import co.edu.udistrital.mdp.carmotor.dto.SedeDTO;
import co.edu.udistrital.mdp.carmotor.services.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
=======
import co.edu.udistrital.mdp.carmotor.dto.SedeDTO;
import co.edu.udistrital.mdp.carmotor.entities.SedeEntity;
import co.edu.udistrital.mdp.carmotor.services.SedeService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

@RestController
@RequestMapping("/sedes")
public class SedeController {
<<<<<<< HEAD
=======
    
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

    @Autowired
    private SedeService sedeService;

<<<<<<< HEAD
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
=======
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<SedeDTO> getAll() {
        return sedeService.getSedes().stream()
                .map(s -> modelMapper.map(s, SedeDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            SedeEntity sede = sedeService.getSede(id);
            return ResponseEntity.ok(modelMapper.map(sede, SedeDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SedeDTO dto) {
        try {
            SedeEntity entity = modelMapper.map(dto, SedeEntity.class);
            SedeEntity created = sedeService.createSede(entity);
            return new ResponseEntity<>(modelMapper.map(created, SedeDTO.class), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SedeDTO dto) {
        try {
            SedeEntity entity = modelMapper.map(dto, SedeEntity.class);
            SedeEntity updated = sedeService.updateSede(id, entity);
            return ResponseEntity.ok(modelMapper.map(updated, SedeDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            sedeService.deleteSede(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
