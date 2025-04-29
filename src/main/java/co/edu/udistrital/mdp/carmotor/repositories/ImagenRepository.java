package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.ImagenEntity;

@Repository
public interface ImagenRepository extends JpaRepository<ImagenEntity, Long> {
    
    List<ImagenEntity> findByUrl(String url);
    List<ImagenEntity> findByAncho(String ancho);
    List<ImagenEntity> findByAlto(String alto);

    void deleteByUrl(String url);
    void deleteByAncho(String ancho);
    void deleteByAlto(String alto);

   
}