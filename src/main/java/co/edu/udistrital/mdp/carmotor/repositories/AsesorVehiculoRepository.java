package co.edu.udistrital.mdp.carmotor.repositories;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsesorVehiculoRepository extends JpaRepository<AsesorVehiculo, Long> {

    // Buscar asesores por nombre exacto
    @Query("SELECT a FROM AsesorVehiculo a WHERE a.nombre = ?1")
    List<AsesorVehiculo> findByNombre(String nombre);

    // Buscar asesores cuyo nombre contenga una cadena (ignorando mayúsculas/minúsculas)
    @Query("SELECT a FROM AsesorVehiculo a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<AsesorVehiculo> searchByNombre(String nombreParcial);

    // Buscar asesor por número de contacto exacto
    @Query("SELECT a FROM AsesorVehiculo a WHERE a.numeroContacto = ?1")
    AsesorVehiculo findByNumeroContacto(String numeroContacto);

    // Contar cuántos asesores hay con un nombre dado
    @Query("SELECT COUNT(a) FROM AsesorVehiculo a WHERE a.nombre = ?1")
    long countByNombre(String nombre);
}

