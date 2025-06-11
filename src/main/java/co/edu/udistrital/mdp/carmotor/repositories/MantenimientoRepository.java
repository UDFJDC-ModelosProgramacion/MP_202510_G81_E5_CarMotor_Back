package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.MantenimientoEntity;
import jakarta.transaction.Transactional;

@Repository
public interface MantenimientoRepository extends JpaRepository<MantenimientoEntity, Long> {

    @Query("SELECT m FROM MantenimientoEntity m WHERE m.fechaDeServicio = :fechaDeServicio")
    List<MantenimientoEntity> findByFechaDeServicio(@Param("fechaDeServicio") String fechaDeServicio);

    @Query("SELECT m FROM MantenimientoEntity m WHERE m.tipoDeServicio = :tipoDeServicio")
    List<MantenimientoEntity> findByTipoDeServicio(@Param("tipoDeServicio") String tipoDeServicio);

    @Modifying
    @Transactional
    @Query("DELETE FROM MantenimientoEntity m WHERE m.fechaDeServicio = :fechaDeServicio")
    void deleteByFechaDeServicio(@Param("fechaDeServicio") String fechaDeServicio);

    @Modifying
    @Transactional
    @Query("DELETE FROM MantenimientoEntity m WHERE m.tipoDeServicio = :tipoDeServicio")
    void deleteByTipoDeServicio(@Param("tipoDeServicio") String tipoDeServicio);

    @Modifying
    @Transactional
    @Query("DELETE FROM MantenimientoEntity m WHERE m.id = :id")
    void deleteById(@Param("id") long id);
}

