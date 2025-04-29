package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.TallerEntity;

@Repository
public interface TallerRepository extends JpaRepository<TallerEntity, Long> {
    
    List<TallerEntity>findByDireccion(String direccion);
    List<TallerEntity> findByHorario(String horario);
    List<TallerEntity> findByNumero(String numero);

    void deleteByDireccion(String direccion);
    void deleteByHorario(String horario);
    void deleteByNumero(String numero);

    void deleteById(long id);
   
}