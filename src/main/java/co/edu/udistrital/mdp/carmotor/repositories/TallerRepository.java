package co.edu.udistrital.mdp.carmotor.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.TallerEntity;
import jakarta.transaction.Transactional;

@Repository
public interface TallerRepository extends JpaRepository<TallerEntity, Long> {

    @Query("SELECT t FROM TallerEntity t WHERE t.direccion = :direccion")
    List<TallerEntity> findByDireccion(@Param("direccion") String direccion);

    @Query("SELECT t FROM TallerEntity t WHERE t.horario = :horario")
    List<TallerEntity> findByHorario(@Param("horario") String horario);

    @Query("SELECT t FROM TallerEntity t WHERE t.numero = :numero")
    List<TallerEntity> findByNumero(@Param("numero") String numero);

    @Modifying
    @Transactional
    @Query("DELETE FROM TallerEntity t WHERE t.direccion = :direccion")
    void deleteByDireccion(@Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query("DELETE FROM TallerEntity t WHERE t.horario = :horario")
    void deleteByHorario(@Param("horario") String horario);

    @Modifying
    @Transactional
    @Query("DELETE FROM TallerEntity t WHERE t.numero = :numero")
    void deleteByNumero(@Param("numero") String numero);

    @Modifying
    @Transactional
    @Query("DELETE FROM TallerEntity t WHERE t.id = :id")
    void deleteById(@Param("id") long id);
}
