package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.MantenimientoDTO;
<<<<<<< HEAD
import co.edu.udistrital.mdp.carmotor.services.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
=======
import co.edu.udistrital.mdp.carmotor.entities.MantenimientoEntity;
import co.edu.udistrital.mdp.carmotor.services.MantenimientoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

@RestController
@RequestMapping("/mantenimientos")
public class MantenimientoController {
<<<<<<< HEAD
=======
    
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

    @Autowired
    private MantenimientoService mantenimientoService;

<<<<<<< HEAD
    @PostMapping
    public ResponseEntity<MantenimientoDTO> create(@RequestBody MantenimientoDTO dto) {
        return ResponseEntity.ok(mantenimientoService.createMantenimiento(dto));
    }

    @GetMapping
    public List<MantenimientoDTO> getAll() {
        return mantenimientoService.getMantenimientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MantenimientoDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mantenimientoService.getMantenimiento(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MantenimientoDTO> update(@PathVariable Long id, @RequestBody MantenimientoDTO dto) {
        return ResponseEntity.ok(mantenimientoService.updateMantenimiento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mantenimientoService.deleteMantenimiento(id);
        return ResponseEntity.noContent().build();
    }
}
=======
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<MantenimientoDTO> getAll() {
        return mantenimientoService.getMantenimientos().stream()
                .map(mantenimiento -> modelMapper.map(mantenimiento, MantenimientoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            MantenimientoEntity mantenimiento = mantenimientoService.getMantenimiento(id);
            return ResponseEntity.ok(modelMapper.map(mantenimiento, MantenimientoDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MantenimientoDTO dto) {
        MantenimientoEntity entity = modelMapper.map(dto, MantenimientoEntity.class);
        MantenimientoEntity created = mantenimientoService.createMantenimiento(entity);
        return new ResponseEntity<>(modelMapper.map(created, MantenimientoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MantenimientoDTO dto) {
        try {
            MantenimientoEntity entity = modelMapper.map(dto, MantenimientoEntity.class);
            MantenimientoEntity updated = mantenimientoService.updateMantenimiento(id, entity);
            return ResponseEntity.ok(modelMapper.map(updated, MantenimientoDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            mantenimientoService.deleteMantenimiento(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/buscar/fecha")
    public List<MantenimientoDTO> findByFechaDeServicio(@RequestParam String fechaDeServicio) {
        return mantenimientoService.findByFechaDeServicio(fechaDeServicio).stream()
                .map(m -> modelMapper.map(m, MantenimientoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar/tipo")
    public List<MantenimientoDTO> findByTipoDeServicio(@RequestParam String tipoDeServicio) {
        return mantenimientoService.findByTipoDeServicio(tipoDeServicio).stream()
                .map(m -> modelMapper.map(m, MantenimientoDTO.class))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/eliminar/fecha")
    public ResponseEntity<?> deleteByFechaDeServicio(@RequestParam String fechaDeServicio) {
        mantenimientoService.deleteByFechaDeServicio(fechaDeServicio);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/tipo")
    public ResponseEntity<?> deleteByTipoDeServicio(@RequestParam String tipoDeServicio) {
        mantenimientoService.deleteByTipoDeServicio(tipoDeServicio);
        return ResponseEntity.noContent().build();
    }
}
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
