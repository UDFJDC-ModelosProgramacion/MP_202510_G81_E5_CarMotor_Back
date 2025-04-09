package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.ImagenEntity;

@Repository
public interface ImagenRepository extends JpaRepository<ImagenEntity, Long> {
    
    List<ImagenRepository> findByUrl(String url);
    List<ImagenRepository> findByAncho(String ancho);
    List<ImagenRepository> findByAlto(String alto);

    void deleteByUrl(String url);
    void deleteByAncho(String ancho);
    void deleteByAlto(String alto);

    void addImagenEntity(ImagenRepository Imagen);
    void updateImagenEntity(ImagenRepository Imagen);
}