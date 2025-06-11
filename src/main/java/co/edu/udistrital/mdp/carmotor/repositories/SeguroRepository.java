package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.SeguroEntity;
import jakarta.transaction.Transactional;

@Repository
public interface SeguroRepository extends JpaRepository<SeguroEntity, Long> {

    @Query("SELECT s FROM SeguroEntity s WHERE s.valorAnual = :valorAnual")
    List<SeguroEntity> findByValorAnual(@Param("valorAnual") String valorAnual);

    @Query("SELECT s FROM SeguroEntity s WHERE s.entidadAseguradora = :entidadAseguradora")
    List<SeguroEntity> findByEntidadAseguradora(@Param("entidadAseguradora") String entidadAseguradora);

    @Modifying
    @Transactional
    @Query("DELETE FROM SeguroEntity s WHERE s.valorAnual = :valorAnual")
    void deleteByValorAnual(@Param("valorAnual") String valorAnual);

    @Modifying
    @Transactional
    @Query("DELETE FROM SeguroEntity s WHERE s.entidadAseguradora = :entidadAseguradora")
    void deleteByEntidadAseguradora(@Param("entidadAseguradora") String entidadAseguradora);
}
