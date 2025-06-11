package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.VehiculoDetailDTO;
import co.edu.udistrital.mdp.carmotor.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<VehiculoDetailDTO> create(@RequestBody VehiculoDetailDTO dto) {
        return ResponseEntity.ok(vehiculoService.createVehiculo(dto));
    }

    @GetMapping
    public List<VehiculoDetailDTO> getAll() {
        return vehiculoService.getVehiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDetailDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.getVehiculo(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculoDetailDTO> update(@PathVariable Long id, @RequestBody VehiculoDetailDTO dto) {
        return ResponseEntity.ok(vehiculoService.updateVehiculo(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehiculoService.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }
}
