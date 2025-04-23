package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculo;
@Repository
public interface AsesorVehiculoRepository extends JpaRepository<AsesorVehiculo, Long> {
    
    List<AsesorVehiculo> findByNombre(String nombre);
    List<AsesorVehiculo> findByNumeroContacto(String numeroContacto);
    void deleteByNombre(String nombre);
    void deleteByNumeroContacto(String numeroContacto);
    void deleteById(long id);
    void addAsesorVehiculo(AsesorVehiculo asesorVehiculo);
    void updateAsesorVehiculo(AsesorVehiculo asesorVehiculo);
}
