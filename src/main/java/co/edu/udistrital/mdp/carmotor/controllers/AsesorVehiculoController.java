package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.AsesorVehiculoDetailDTO;
import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculoEntity;
import co.edu.udistrital.mdp.carmotor.services.AsesorVehiculoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/asesores")
public class AsesorVehiculoController {

    @Autowired
    private AsesorVehiculoService asesorVehiculoService;

    @Autowired
    private ModelMapper modelMapper;

    // Obtener todos los asesores
    @GetMapping
    public List<AsesorVehiculoDetailDTO> getAllAsesores() {
        return asesorVehiculoService.getAsesores().stream()
                .map(asesor -> modelMapper.map(asesor, AsesorVehiculoDetailDTO.class))
                .collect(Collectors.toList());
    }

    // Obtener un asesor por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAsesorById(@PathVariable Long id) {
        try {
            AsesorVehiculoEntity asesor = asesorVehiculoService.getAsesor(id);
            AsesorVehiculoDetailDTO dto = modelMapper.map(asesor, AsesorVehiculoDetailDTO.class);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Crear asesor
    @PostMapping
    public ResponseEntity<?> createAsesor(@RequestBody AsesorVehiculoDetailDTO dto) {
        try {
            AsesorVehiculoEntity asesor = modelMapper.map(dto, AsesorVehiculoEntity.class);
            AsesorVehiculoEntity created = asesorVehiculoService.createAsesor(asesor);
            return new ResponseEntity<>(modelMapper.map(created, AsesorVehiculoDetailDTO.class), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Actualizar asesor
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAsesor(@PathVariable Long id, @RequestBody AsesorVehiculoDetailDTO dto) {
        try {
            AsesorVehiculoEntity asesor = modelMapper.map(dto, AsesorVehiculoEntity.class);
            AsesorVehiculoEntity updated = asesorVehiculoService.updateAsesor(id, asesor);
            return ResponseEntity.ok(modelMapper.map(updated, AsesorVehiculoDetailDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Eliminar asesor
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsesor(@PathVariable Long id) {
        try {
            asesorVehiculoService.deleteAsesor(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
