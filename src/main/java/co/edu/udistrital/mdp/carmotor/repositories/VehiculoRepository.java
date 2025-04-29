package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;


@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {

    List<VehiculoEntity> findByMarca(String marca);
    List<VehiculoEntity> findBySerie(String serie);
    List<VehiculoEntity> findByPlaca(String placa);
    List<VehiculoEntity> findByModelo(String modelo);
    List<VehiculoEntity> findByTipo(String tipo);
    List<VehiculoEntity> findByCapacidadPasajeros(String capacidadPasajeros);
    List<VehiculoEntity> findByPrecio(Integer precio);

    void deleteByMarca(String marca);
    void deleteBySerie(String serie);
    void deleteByPlaca(String placa);
    void deleteByModelo(String modelo);
    void deleteByTipo(String tipo);
    void deleteByCapacidadPasajeros(String capacidadPasajeros);
    void deleteByPrecio(Integer precio);
   


}