package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.udistrital.mdp.carmotor.entities.EntidadBancaria;

public interface EntidadBancariaRepository extends JpaRepository<EntidadBancaria, Long> {
    
    List<EntidadBancariaRepository> findByNombre(String nombre);
    List<EntidadBancariaRepository> findByNumeroTelefonoAsesor(String numeroTelefonoAsesor);
    void deleteByNombre(String nombre);
    void deleteByNumeroTelefonoAsesor(String numeroTelefonoAsesor);
    void deleteById(long id);
    void addEntidadBancaria(EntidadBancariaRepository entidadBancaria);
    void updateEntidadBancaria(EntidadBancariaRepository entidadBancaria);
}
