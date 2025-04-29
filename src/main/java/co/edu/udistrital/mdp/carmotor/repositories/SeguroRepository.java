package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.SeguroEntity;

@Repository
public interface SeguroRepository extends JpaRepository<SeguroEntity, Long> {
    
    List<SeguroEntity> findByValorAnual(String valorAnual);
    List<SeguroEntity> findByEntidadAseguradora(String entidadAseguradora);

    void deleteByValorAnual(String valorAnual);
    void deleteByEntidadAseguradora(String entidadAseguradora);

    
}