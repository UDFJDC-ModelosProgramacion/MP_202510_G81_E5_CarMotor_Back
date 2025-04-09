package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.SeguroEntity;

@Repository
public interface SeguroRepository extends JpaRepository<SeguroEntity, Long> {
    
    List<SeguroRepository> findByValorAnual(String valorAnual);
    List<SeguroRepository> findByEntidadAseguradora(String entidadAseguradora);

    void deleteByValorAnual(String valorAnual);
    void deleteByEntidadAseguradora(String entidadAseguradora);

    void addSeguroEntity(SeguroRepository Seguro);
    void updateSeguroEntity(SeguroRepository Seguro);
}