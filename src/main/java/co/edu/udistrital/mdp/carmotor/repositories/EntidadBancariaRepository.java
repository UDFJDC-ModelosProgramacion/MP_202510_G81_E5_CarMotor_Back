package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;
import co.edu.udistrital.mdp.carmotor.entities.EntidadBancariaEntity;

@Repository
public interface EntidadBancariaRepository extends JpaRepository<EntidadBancariaEntity, Long> {

    // ============================
    // Consultas JPQL explícitas
    // ============================

    @Query("SELECT e FROM EntidadBancariaEntity e WHERE e.nombre = :nombre")
    List<EntidadBancariaEntity> findByNombre(@Param("nombre") String nombre);

    @Query("SELECT e FROM EntidadBancariaEntity e WHERE e.numeroTelefonoAsesor = :numeroTelefonoAsesor")
    List<EntidadBancariaEntity> findByNumeroTelefonoAsesor(@Param("numeroTelefonoAsesor") String numeroTelefonoAsesor);

    @Modifying
    @Transactional
    @Query("DELETE FROM EntidadBancariaEntity e WHERE e.nombre = :nombre")
    void deleteByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query("DELETE FROM EntidadBancariaEntity e WHERE e.numeroTelefonoAsesor = :numeroTelefonoAsesor")
    void deleteByNumeroTelefonoAsesor(@Param("numeroTelefonoAsesor") String numeroTelefonoAsesor);

    @Modifying
    @Transactional
    @Query("DELETE FROM EntidadBancariaEntity e WHERE e.id = :id")
    void deleteById(@Param("id") long id);

    /*
    // ============================
    // Versión con consultas nativas (opcional)
    // ============================

    @Query(value = "SELECT * FROM entidad_bancaria WHERE nombre = :nombre", nativeQuery = true)
    List<EntidadBancariaEntity> findByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM entidad_bancaria WHERE numero_telefono_asesor = :numeroTelefonoAsesor", nativeQuery = true)
    List<EntidadBancariaEntity> findByNumeroTelefonoAsesor(@Param("numeroTelefonoAsesor") String numeroTelefonoAsesor);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM entidad_bancaria WHERE nombre = :nombre", nativeQuery = true)
    void deleteByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM entidad_bancaria WHERE numero_telefono_asesor = :numeroTelefonoAsesor", nativeQuery = true)
    void deleteByNumeroTelefonoAsesor(@Param("numeroTelefonoAsesor") String numeroTelefonoAsesor);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM entidad_bancaria WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") long id);
    */
}
