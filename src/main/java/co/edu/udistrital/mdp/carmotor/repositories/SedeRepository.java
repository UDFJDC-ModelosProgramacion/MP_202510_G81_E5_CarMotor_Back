package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.edu.udistrital.mdp.carmotor.entities.SedeEntity;
import jakarta.transaction.Transactional;
@Repository
public interface SedeRepository extends JpaRepository<SedeEntity, Long> {

    @Query("SELECT s FROM SedeEntity s WHERE s.nombre = :nombre")
    List<SedeEntity> findByNombre(@Param("nombre") String nombre);

    @Query("SELECT s FROM SedeEntity s WHERE s.direccion = :direccion")
    List<SedeEntity> findByDireccion(@Param("direccion") String direccion);

    @Query("SELECT s FROM SedeEntity s WHERE s.telefono = :telefono")
    List<SedeEntity> findByTelefono(@Param("telefono") String telefono);

    @Query("SELECT s FROM SedeEntity s WHERE s.horario = :horario")
    List<SedeEntity> findByHorario(@Param("horario") String horario);

    @Query("SELECT s FROM SedeEntity s WHERE s.activa = :activa")
    List<SedeEntity> findByActiva(@Param("activa") Boolean activa);

    @Query("SELECT s FROM SedeEntity s WHERE s.capacidadMaxima = :capacidadMaxima")
    List<SedeEntity> findByCapacidadMaxima(@Param("capacidadMaxima") String capacidadMaxima);

    @Modifying
    @Transactional
    @Query("DELETE FROM SedeEntity s WHERE s.nombre = :nombre")
    void deleteByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query("DELETE FROM SedeEntity s WHERE s.direccion = :direccion")
    void deleteByDireccion(@Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query("DELETE FROM SedeEntity s WHERE s.telefono = :telefono")
    void deleteByTelefono(@Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query("DELETE FROM SedeEntity s WHERE s.horario = :horario")
    void deleteByHorario(@Param("horario") String horario);

    boolean existsByNombre(String nombre);
    boolean existsByDireccion(String direccion);
}

