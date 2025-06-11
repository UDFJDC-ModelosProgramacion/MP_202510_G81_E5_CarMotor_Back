package co.edu.udistrital.mdp.carmotor.controllers;
<<<<<<< HEAD

import co.edu.udistrital.mdp.carmotor.dto.ImagenDTO;
import co.edu.udistrital.mdp.carmotor.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
=======
import co.edu.udistrital.mdp.carmotor.dto.ImagenDTO;
import co.edu.udistrital.mdp.carmotor.entities.ImagenEntity;
import co.edu.udistrital.mdp.carmotor.services.ImagenService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

@RestController
@RequestMapping("/imagenes")
public class ImagenController {
<<<<<<< HEAD
=======
    
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

    @Autowired
    private ImagenService imagenService;

<<<<<<< HEAD
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
=======
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ImagenDTO> getAll() {
        return imagenService.getImagenes().stream()
                .map(imagen -> modelMapper.map(imagen, ImagenDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            ImagenEntity imagen = imagenService.getImagen(id);
            return ResponseEntity.ok(modelMapper.map(imagen, ImagenDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ImagenDTO dto) {
        ImagenEntity entity = modelMapper.map(dto, ImagenEntity.class);
        ImagenEntity created = imagenService.createImagen(entity);
        return new ResponseEntity<>(modelMapper.map(created, ImagenDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ImagenDTO dto) {
        try {
            ImagenEntity entity = modelMapper.map(dto, ImagenEntity.class);
            ImagenEntity updated = imagenService.updateImagen(id, entity);
            return ResponseEntity.ok(modelMapper.map(updated, ImagenDTO.class));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            imagenService.deleteImagen(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/buscar/url")
    public List<ImagenDTO> findByUrl(@RequestParam String url) {
        return imagenService.findByUrl(url).stream()
                .map(imagen -> modelMapper.map(imagen, ImagenDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar/ancho")
    public List<ImagenDTO> findByAncho(@RequestParam String ancho) {
        return imagenService.findByAncho(ancho).stream()
                .map(imagen -> modelMapper.map(imagen, ImagenDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar/alto")
    public List<ImagenDTO> findByAlto(@RequestParam String alto) {
        return imagenService.findByAlto(alto).stream()
                .map(imagen -> modelMapper.map(imagen, ImagenDTO.class))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/eliminar/url")
    public ResponseEntity<?> deleteByUrl(@RequestParam String url) {
        imagenService.deleteByUrl(url);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/ancho")
    public ResponseEntity<?> deleteByAncho(@RequestParam String ancho) {
        imagenService.deleteByAncho(ancho);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/alto")
    public ResponseEntity<?> deleteByAlto(@RequestParam String alto) {
        imagenService.deleteByAlto(alto);
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
        return ResponseEntity.noContent().build();
    }
}
