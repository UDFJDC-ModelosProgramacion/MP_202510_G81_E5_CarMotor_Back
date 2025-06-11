package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.ImagenEntity;

@Repository
public interface ImagenRepository extends JpaRepository<ImagenEntity, Long> {

    // ============================
    // Consultas JPQL explícitas
    // ============================

    @Query("SELECT i FROM ImagenEntity i WHERE i.url = :url")
    List<ImagenEntity> findByUrl(@Param("url") String url);

    @Query("SELECT i FROM ImagenEntity i WHERE i.ancho = :ancho")
    List<ImagenEntity> findByAncho(@Param("ancho") String ancho);

    @Query("SELECT i FROM ImagenEntity i WHERE i.alto = :alto")
    List<ImagenEntity> findByAlto(@Param("alto") String alto);

    @Modifying
    @Transactional
    @Query("DELETE FROM ImagenEntity i WHERE i.url = :url")
    void deleteByUrl(@Param("url") String url);

    @Modifying
    @Transactional
    @Query("DELETE FROM ImagenEntity i WHERE i.ancho = :ancho")
    void deleteByAncho(@Param("ancho") String ancho);

    @Modifying
    @Transactional
    @Query("DELETE FROM ImagenEntity i WHERE i.alto = :alto")
    void deleteByAlto(@Param("alto") String alto);

    /*
    // ============================
    // Versión con consultas SQL nativas (opcional)
    // ============================

    @Query(value = "SELECT * FROM imagen WHERE url = :url", nativeQuery = true)
    List<ImagenEntity> findByUrl(@Param("url") String url);

    @Query(value = "SELECT * FROM imagen WHERE ancho = :ancho", nativeQuery = true)
    List<ImagenEntity> findByAncho(@Param("ancho") String ancho);

    @Query(value = "SELECT * FROM imagen WHERE alto = :alto", nativeQuery = true)
    List<ImagenEntity> findByAlto(@Param("alto") String alto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM imagen WHERE url = :url", nativeQuery = true)
    void deleteByUrl(@Param("url") String url);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM imagen WHERE ancho = :ancho", nativeQuery = true)
    void deleteByAncho(@Param("ancho") String ancho);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM imagen WHERE alto = :alto", nativeQuery = true)
    void deleteByAlto(@Param("alto") String alto);
    */
}
