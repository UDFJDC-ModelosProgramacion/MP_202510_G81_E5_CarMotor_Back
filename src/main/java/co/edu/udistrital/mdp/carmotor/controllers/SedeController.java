package co.edu.udistrital.mdp.carmotor.controllers;
import co.edu.udistrital.mdp.carmotor.dto.SedeDTO;
import co.edu.udistrital.mdp.carmotor.entities.SedeEntity;
import co.edu.udistrital.mdp.carmotor.services.SedeService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sedes")
public class SedeController {
    

    @Autowired
    private SedeService sedeService;

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
