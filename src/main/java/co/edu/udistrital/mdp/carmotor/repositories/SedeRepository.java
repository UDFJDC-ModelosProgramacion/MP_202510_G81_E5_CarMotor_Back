package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.SedeEntity;


@Repository

public interface SedeRepository extends JpaRepository<SedeEntity, Long>{
    
    List<SedeEntity> findByNombre(String nombre);
    List<SedeEntity> findByDireccion(String direccion);
    List<SedeEntity> findByTelefono(String telefono);
    List<SedeEntity> findByHorario(String horario);

    void deleteByNombre(String nombre);
    void deleteByDireccion(String direccion);
    void deleteByTelefono(String telefono);
    void deleteByHorario(String horario);


}
