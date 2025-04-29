package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.udistrital.mdp.carmotor.entities.EntidadBancariaEntity;

public interface EntidadBancariaRepository extends JpaRepository<EntidadBancariaEntity, Long> {
    
    List<EntidadBancariaEntity> findByNombre(String nombre);
    List<EntidadBancariaEntity> findByNumeroTelefonoAsesor(String numeroTelefonoAsesor);

    void deleteByNombre(String nombre);
    void deleteByNumeroTelefonoAsesor(String numeroTelefonoAsesor);
    void deleteById(long id);
    
}
