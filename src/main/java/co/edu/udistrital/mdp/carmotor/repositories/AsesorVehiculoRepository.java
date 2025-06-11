package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculoEntity;

@Repository
public interface AsesorVehiculoRepository extends JpaRepository<AsesorVehiculoEntity, Long> {

    // ========================
    // Consultas (JPQL)
    // ========================
    
    @Query("SELECT a FROM AsesorVehiculoEntity a WHERE a.nombre = :nombre")
    List<AsesorVehiculoEntity> findByNombre(@Param("nombre") String nombre);

    @Query("SELECT a FROM AsesorVehiculoEntity a WHERE a.numeroContacto = :numeroContacto")
    List<AsesorVehiculoEntity> findByNumeroContacto(@Param("numeroContacto") String numeroContacto);

    @Query("DELETE FROM AsesorVehiculoEntity a WHERE a.nombre = :nombre")
    void deleteByNombre(@Param("nombre") String nombre);

    @Query("DELETE FROM AsesorVehiculoEntity a WHERE a.numeroContacto = :numeroContacto")
    void deleteByNumeroContacto(@Param("numeroContacto") String numeroContacto);

    @Query("DELETE FROM AsesorVehiculoEntity a WHERE a.id = :id")
    void deleteById(@Param("id") long id);

    /*
    // ========================
    // Consultas nativas (SQL puro)
    // ========================
    
    @Query(value = "SELECT * FROM asesor_vehiculo WHERE nombre = :nombre", nativeQuery = true)
    List<AsesorVehiculoEntity> findByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM asesor_vehiculo WHERE numero_contacto = :numeroContacto", nativeQuery = true)
    List<AsesorVehiculoEntity> findByNumeroContacto(@Param("numeroContacto") String numeroContacto);

    @Query(value = "DELETE FROM asesor_vehiculo WHERE nombre = :nombre", nativeQuery = true)
    void deleteByNombre(@Param("nombre") String nombre);

    @Query(value = "DELETE FROM asesor_vehiculo WHERE numero_contacto = :numeroContacto", nativeQuery = true)
    void deleteByNumeroContacto(@Param("numeroContacto") String numeroContacto);

    @Query(value = "DELETE FROM asesor_vehiculo WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") long id);
    */
}


