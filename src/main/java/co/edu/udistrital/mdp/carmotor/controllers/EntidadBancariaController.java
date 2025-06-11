package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.EntidadBancariaDTO;
import co.edu.udistrital.mdp.carmotor.entities.EntidadBancariaEntity;
import co.edu.udistrital.mdp.carmotor.services.EntidadBancariaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entidades-bancarias")
public class EntidadBancariaController {
    

    @Autowired
    private EntidadBancariaService entidadBancariaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<EntidadBancariaDTO> getAll() {
        return entidadBancariaService.getEntidades().stream()
                .map(entidad -> modelMapper.map(entidad, EntidadBancariaDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            EntidadBancariaEntity entidad = entidadBancariaService.getEntidad(id);
            return ResponseEntity.ok(modelMapper.map(entidad, EntidadBancariaDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EntidadBancariaDTO dto) {
        EntidadBancariaEntity entity = modelMapper.map(dto, EntidadBancariaEntity.class);
        EntidadBancariaEntity created = entidadBancariaService.createEntidad(entity);
        return new ResponseEntity<>(modelMapper.map(created, EntidadBancariaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EntidadBancariaDTO dto) {
        try {
            EntidadBancariaEntity entity = modelMapper.map(dto, EntidadBancariaEntity.class);
            EntidadBancariaEntity updated = entidadBancariaService.updateEntidad(id, entity);
            return ResponseEntity.ok(modelMapper.map(updated, EntidadBancariaDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            entidadBancariaService.deleteEntidad(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/buscar/nombre")
    public List<EntidadBancariaDTO> findByNombre(@RequestParam String nombre) {
        return entidadBancariaService.findByNombre(nombre).stream()
                .map(e -> modelMapper.map(e, EntidadBancariaDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar/telefono")
    public List<EntidadBancariaDTO> findByTelefono(@RequestParam String numeroTelefonoAsesor) {
        return entidadBancariaService.findByNumeroTelefonoAsesor(numeroTelefonoAsesor).stream()
                .map(e -> modelMapper.map(e, EntidadBancariaDTO.class))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/eliminar/nombre")
    public ResponseEntity<?> deleteByNombre(@RequestParam String nombre) {
        entidadBancariaService.deleteByNombre(nombre);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/telefono")
    public ResponseEntity<?> deleteByTelefono(@RequestParam String numeroTelefonoAsesor) {
        entidadBancariaService.deleteByNumeroTelefonoAsesor(numeroTelefonoAsesor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar-custom/{id}")
    public ResponseEntity<?> deleteByIdCustom(@PathVariable Long id) {
        entidadBancariaService.deleteByIdCustom(id);
        return ResponseEntity.noContent().build();
    }
}
