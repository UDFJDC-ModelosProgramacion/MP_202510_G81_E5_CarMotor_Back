package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculo;


public interface EntidadBancariaRepository extends JpaRepository<AsesorVehiculo, Long> {
    
    List<EntidadBancariaRepository> findByNombre(String nombre);
    List<EntidadBancariaRepository> findByNumeroTelefonoAsesor(String numeroTelefonoAsesor);
    void deleteByNombre(String nombre);
    void deleteByNumeroTelefonoAsesor(String numeroTelefonoAsesor);
    void deleteById(long id);
    void addEntidadBancaria(EntidadBancariaRepository entidadBancaria);
    void updateEntidadBancaria(EntidadBancariaRepository entidadBancaria);
}
