package co.edu.udistrital.mdp.carmotor.controllers;

import co.edu.udistrital.mdp.carmotor.dto.ImagenDTO;
import co.edu.udistrital.mdp.carmotor.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenes")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @PostMapping
    public ResponseEntity<ImagenDTO> create(@RequestBody ImagenDTO dto) {
        return ResponseEntity.ok(imagenService.createImagen(dto));
    }

    @GetMapping
    public List<ImagenDTO> getAll() {
        return imagenService.getImagenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(imagenService.getImagen(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenDTO> update(@PathVariable Long id, @RequestBody ImagenDTO dto) {
        return ResponseEntity.ok(imagenService.updateImagen(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        imagenService.deleteImagen(id);
        return ResponseEntity.noContent().build();
    }
}
