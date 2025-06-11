package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.dto.ImagenDTO;
import co.edu.udistrital.mdp.carmotor.entities.ImagenEntity;
import co.edu.udistrital.mdp.carmotor.repositories.ImagenRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public ImagenDTO createImagen(ImagenDTO dto) {
        ImagenEntity entity = ImagenDTO.toEntity(dto);
        return ImagenDTO.toDTO(imagenRepository.save(entity));
    }

    public List<ImagenDTO> getImagenes() {
        return imagenRepository.findAll()
                .stream()
                .map(ImagenDTO::toDTO)
                .collect(Collectors.toList());
    }

    public ImagenDTO getImagen(Long id) {
        return imagenRepository.findById(id)
                .map(ImagenDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Imagen no encontrada con ID: " + id));
    }

    public ImagenDTO updateImagen(Long id, ImagenDTO dto) {
        ImagenEntity existente = imagenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Imagen no encontrada con ID: " + id));
        existente.setUrl(dto.getUrl());
        existente.setAncho(dto.getAncho());
        existente.setAlto(dto.getAlto());
        // Actualiza otros campos según tu DTO
        return ImagenDTO.toDTO(imagenRepository.save(existente));
    }

    public void deleteImagen(Long id) {
        ImagenEntity imagen = imagenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Imagen no encontrada con ID: " + id));
        imagenRepository.delete(imagen);
    }
}