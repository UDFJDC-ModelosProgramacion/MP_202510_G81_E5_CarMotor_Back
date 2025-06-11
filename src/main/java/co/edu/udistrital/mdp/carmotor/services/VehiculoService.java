package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;
import co.edu.udistrital.mdp.carmotor.repositories.VehiculoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    /**
     * Crea un nuevo vehículo.
     */
    public VehiculoEntity createVehiculo(VehiculoEntity vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    /**
     * Obtiene todos los vehículos.
     */
    public List<VehiculoEntity> getVehiculos() {
        return vehiculoRepository.findAll();
    }

    /**
     * Obtiene un vehículo por su ID.
     */
    public VehiculoEntity getVehiculo(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado con ID: " + id));
    }

    /**
     * Actualiza los datos de un vehículo.
     */
    public VehiculoEntity updateVehiculo(Long id, VehiculoEntity vehiculo) {
        VehiculoEntity existente = getVehiculo(id);
        existente.setMarca(vehiculo.getMarca());
        existente.setSerie(vehiculo.getSerie());
        existente.setPlaca(vehiculo.getPlaca());
        existente.setModelo(vehiculo.getModelo());
        existente.setTipo(vehiculo.getTipo());
        existente.setCapacidadPasajeros(vehiculo.getCapacidadPasajeros());
        existente.setPrecio(vehiculo.getPrecio());
        existente.setSede(vehiculo.getSede());
        existente.setAsesorVehiculo(vehiculo.getAsesorVehiculo());
        return vehiculoRepository.save(existente);
    }

    /**
     * Elimina un vehículo por su ID.
     */
    public void deleteVehiculo(Long id) {
        VehiculoEntity vehiculo = getVehiculo(id);
        vehiculoRepository.delete(vehiculo);
    }

    /**
     * Busca vehículos por marca.
     */
    public List<VehiculoEntity> findByMarca(String marca) {
        return vehiculoRepository.findByMarca(marca);
    }

    /**
     * Busca vehículos por serie.
     */
    public List<VehiculoEntity> findBySerie(String serie) {
        return vehiculoRepository.findBySerie(serie);
    }

    /**
     * Busca vehículos por placa.
     */
    public List<VehiculoEntity> findByPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa);
    }

    /**
     * Busca vehículos por modelo.
     */
    public List<VehiculoEntity> findByModelo(String modelo) {
        return vehiculoRepository.findByModelo(modelo);
    }

    /**
     * Busca vehículos por tipo.
     */
    public List<VehiculoEntity> findByTipo(String tipo) {
        return vehiculoRepository.findByTipo(tipo);
    }

    /**
     * Busca vehículos por capacidad de pasajeros.
     */
    public List<VehiculoEntity> findByCapacidadPasajeros(String capacidadPasajeros) {
        return vehiculoRepository.findByCapacidadPasajeros(capacidadPasajeros);
    }

    /**
     * Busca vehículos por precio.
     */
    public List<VehiculoEntity> findByPrecio(Integer precio) {
        return vehiculoRepository.findByPrecio(precio);
    }

    /**
     * Elimina vehículos por marca.
     */
    @Transactional
    public void deleteByMarca(String marca) {
        vehiculoRepository.deleteByMarca(marca);
    }

    /**
     * Elimina vehículos por serie.
     */
    @Transactional
    public void deleteBySerie(String serie) {
        vehiculoRepository.deleteBySerie(serie);
    }

    /**
     * Elimina vehículos por placa.
     */
    @Transactional
    public void deleteByPlaca(String placa) {
        vehiculoRepository.deleteByPlaca(placa);
    }

    /**
     * Elimina vehículos por modelo.
     */
    @Transactional
    public void deleteByModelo(String modelo) {
        vehiculoRepository.deleteByModelo(modelo);
    }

    /**
     * Elimina vehículos por tipo.
     */
    @Transactional
    public void deleteByTipo(String tipo) {
        vehiculoRepository.deleteByTipo(tipo);
    }

    /**
     * Elimina vehículos por capacidad de pasajeros.
     */
    @Transactional
    public void deleteByCapacidadPasajeros(String capacidadPasajeros) {
        vehiculoRepository.deleteByCapacidadPasajeros(capacidadPasajeros);
    }

    /**
     * Elimina vehículos por precio.
     */
    @Transactional
    public void deleteByPrecio(Integer precio) {
        vehiculoRepository.deleteByPrecio(precio);
    }
}