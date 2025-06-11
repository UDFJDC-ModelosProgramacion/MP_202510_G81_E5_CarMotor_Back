package co.edu.udistrital.mdp.carmotor.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;
import jakarta.transaction.Transactional;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {

    @Query("SELECT v FROM VehiculoEntity v WHERE v.marca = :marca")
    List<VehiculoEntity> findByMarca(@Param("marca") String marca);

    @Query("SELECT v FROM VehiculoEntity v WHERE v.serie = :serie")
    List<VehiculoEntity> findBySerie(@Param("serie") String serie);

    @Query("SELECT v FROM VehiculoEntity v WHERE v.placa = :placa")
    List<VehiculoEntity> findByPlaca(@Param("placa") String placa);

    @Query("SELECT v FROM VehiculoEntity v WHERE v.modelo = :modelo")
    List<VehiculoEntity> findByModelo(@Param("modelo") String modelo);

    @Query("SELECT v FROM VehiculoEntity v WHERE v.tipo = :tipo")
    List<VehiculoEntity> findByTipo(@Param("tipo") String tipo);

    @Query("SELECT v FROM VehiculoEntity v WHERE v.capacidadPasajeros = :capacidadPasajeros")
    List<VehiculoEntity> findByCapacidadPasajeros(@Param("capacidadPasajeros") String capacidadPasajeros);

    @Query("SELECT v FROM VehiculoEntity v WHERE v.precio = :precio")
    List<VehiculoEntity> findByPrecio(@Param("precio") Integer precio);

    @Modifying
    @Transactional
    @Query("DELETE FROM VehiculoEntity v WHERE v.marca = :marca")
    void deleteByMarca(@Param("marca") String marca);

    @Modifying
    @Transactional
    @Query("DELETE FROM VehiculoEntity v WHERE v.serie = :serie")
    void deleteBySerie(@Param("serie") String serie);

    @Modifying
    @Transactional
    @Query("DELETE FROM VehiculoEntity v WHERE v.placa = :placa")
    void deleteByPlaca(@Param("placa") String placa);

    @Modifying
    @Transactional
    @Query("DELETE FROM VehiculoEntity v WHERE v.modelo = :modelo")
    void deleteByModelo(@Param("modelo") String modelo);

    @Modifying
    @Transactional
    @Query("DELETE FROM VehiculoEntity v WHERE v.tipo = :tipo")
    void deleteByTipo(@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query("DELETE FROM VehiculoEntity v WHERE v.capacidadPasajeros = :capacidadPasajeros")
    void deleteByCapacidadPasajeros(@Param("capacidadPasajeros") String capacidadPasajeros);

    @Modifying
    @Transactional
    @Query("DELETE FROM VehiculoEntity v WHERE v.precio = :precio")
    void deleteByPrecio(@Param("precio") Integer precio);
}
