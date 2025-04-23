package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;


@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {

    List<VehiculoRepository> findByMarca(String marca);
    List<VehiculoRepository> findBySerie(String serie);
    List<VehiculoRepository> findByPlaca(String placa);
    List<ImagenRepository> findByModelo(String modelo);
    List<ImagenRepository> findByTipo(String tipo);
    List<ImagenRepository> findByCapacidadPasajeros(String capacidadPasajeros);
    List<ImagenRepository> findByPrecio(Integer precio);

    void deleteByMarca(String marca);
    void deleteBySerie(String serie);
    void deleteByPlaca(String placa);
    void deleteByModelo(String modelo);
    void deleteByTipo(String tipo);
    void deleteByCapacidadPasajeros(String capacidadPasajeros);
    void deleteByPrecio(Integer precio);
    void addVehiculoEntity(VehiculoRepository Vehiculo);
    void updateVehiculoEntity(VehiculoRepository Vehiculo);
}