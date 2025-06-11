package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.AsesorVehiculoDTO;
import co.edu.udistrital.mdp.carmotor.services.AsesorVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asesores")
public class AsesorVehiculoController {

    @Autowired
    private AsesorVehiculoService asesorVehiculoService;

    @PostMapping
    public ResponseEntity<AsesorVehiculoDTO> create(@RequestBody AsesorVehiculoDTO dto) {
        return ResponseEntity.ok(asesorVehiculoService.createAsesor(dto));
    }

    @GetMapping
    public List<AsesorVehiculoDTO> getAll() {
        return asesorVehiculoService.getAsesores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsesorVehiculoDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(asesorVehiculoService.getAsesor(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsesorVehiculoDTO> update(@PathVariable Long id, @RequestBody AsesorVehiculoDTO dto) {
        return ResponseEntity.ok(asesorVehiculoService.updateAsesor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        asesorVehiculoService.deleteAsesor(id);
        return ResponseEntity.noContent().build();
    }
}