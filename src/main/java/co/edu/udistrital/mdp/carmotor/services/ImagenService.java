package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.mdp.carmotor.entities.ImagenEntity;
import co.edu.udistrital.mdp.carmotor.repositories.ImagenRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    /**
     * Crea una nueva imagen.
     */
    public ImagenEntity createImagen(ImagenEntity imagen) {
        return imagenRepository.save(imagen);
    }

    /**
     * Obtiene todas las imágenes.
     */
    public List<ImagenEntity> getImagenes() {
        return imagenRepository.findAll();
    }

    /**
     * Obtiene una imagen por su ID.
     */
    public ImagenEntity getImagen(Long id) {
        return imagenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Imagen no encontrada con ID: " + id));
    }

    /**
     * Actualiza los datos de una imagen.
     */
    public ImagenEntity updateImagen(Long id, ImagenEntity imagen) {
        ImagenEntity existente = getImagen(id);
        existente.setUrl(imagen.getUrl());
        existente.setAncho(imagen.getAncho());
        existente.setAlto(imagen.getAlto());
        existente.setVehiculo(imagen.getVehiculo());
        existente.setAsesorVehiculo(imagen.getAsesorVehiculo());
        existente.setEntidadBancaria(imagen.getEntidadBancaria());
        return imagenRepository.save(existente);
    }

    /**
     * Elimina una imagen por su ID.
     */
    public void deleteImagen(Long id) {
        ImagenEntity imagen = getImagen(id);
        imagenRepository.delete(imagen);
    }

    /**
     * Busca imágenes por URL.
     */
    public List<ImagenEntity> findByUrl(String url) {
        return imagenRepository.findByUrl(url);
    }

    /**
     * Busca imágenes por ancho.
     */
    public List<ImagenEntity> findByAncho(String ancho) {
        return imagenRepository.findByAncho(ancho);
    }

    /**
     * Busca imágenes por alto.
     */
    public List<ImagenEntity> findByAlto(String alto) {
        return imagenRepository.findByAlto(alto);
    }

    /**
     * Elimina imágenes por URL.
     */
    @Transactional
    public void deleteByUrl(String url) {
        imagenRepository.deleteByUrl(url);
    }

    /**
     * Elimina imágenes por ancho.
     */
    @Transactional
    public void deleteByAncho(String ancho) {
        imagenRepository.deleteByAncho(ancho);
    }

    /**
     * Elimina imágenes por alto.
     */
    @Transactional
    public void deleteByAlto(String alto) {
        imagenRepository.deleteByAlto(alto);
    }
}
