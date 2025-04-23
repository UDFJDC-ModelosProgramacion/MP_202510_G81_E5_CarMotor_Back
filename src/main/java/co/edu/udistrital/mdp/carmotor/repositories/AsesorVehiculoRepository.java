package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculo;
@Repository
public interface AsesorVehiculoRepository extends JpaRepository<AsesorVehiculo, Long> {

    @Query("SELECT a FROM AsesorVehiculo a WHERE a.nombre = :nombre")
    List<AsesorVehiculo> findByNombre(@Param("nombre") String nombre);

    @Query("SELECT a FROM AsesorVehiculo a WHERE a.numeroContacto = :numeroContacto")
    List<AsesorVehiculo> findByNumeroContacto(@Param("numeroContacto") String numeroContacto);

    @Query("DELETE FROM AsesorVehiculo a WHERE a.nombre = :nombre")
    void deleteByNombre(@Param("nombre") String nombre);

    @Query("DELETE FROM AsesorVehiculo a WHERE a.numeroContacto = :numeroContacto")
    void deleteByNumeroContacto(@Param("numeroContacto") String numeroContacto);

    @Query("DELETE FROM AsesorVehiculo a WHERE a.id = :id")
    void deleteById(@Param("id") long id);

    // Aunque no es necesario usar @Query para agregar, se puede hacer de esta forma (no recomendado):
    @Query("INSERT INTO AsesorVehiculo (nombre, numeroContacto) VALUES (:nombre, :numeroContacto)")
    void addAsesorVehiculo(@Param("nombre") String nombre, @Param("numeroContacto") String numeroContacto);

    // Aunque no es necesario usar @Query para actualizar, se puede hacer de esta forma (no recomendado):
    @Query("UPDATE AsesorVehiculo a SET a.nombre = :nombre, a.numeroContacto = :numeroContacto WHERE a.id = :id")
    void updateAsesorVehiculo(@Param("nombre") String nombre, @Param("numeroContacto") String numeroContacto, @Param("id") long id);
}

