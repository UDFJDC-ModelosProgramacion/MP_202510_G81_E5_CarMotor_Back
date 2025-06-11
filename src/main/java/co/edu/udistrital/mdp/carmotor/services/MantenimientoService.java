package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.mdp.carmotor.entities.MantenimientoEntity;
import co.edu.udistrital.mdp.carmotor.repositories.MantenimientoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    /**
     * Crea un nuevo mantenimiento.
     */
    public MantenimientoEntity createMantenimiento(MantenimientoEntity mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    /**
     * Obtiene todos los mantenimientos.
     */
    public List<MantenimientoEntity> getMantenimientos() {
        return mantenimientoRepository.findAll();
    }

    /**
     * Obtiene un mantenimiento por su ID.
     */
    public MantenimientoEntity getMantenimiento(Long id) {
        return mantenimientoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mantenimiento no encontrado con ID: " + id));
    }

    /**
     * Actualiza los datos de un mantenimiento.
     */
    public MantenimientoEntity updateMantenimiento(Long id, MantenimientoEntity mantenimiento) {
        MantenimientoEntity existente = getMantenimiento(id);
        existente.setFechaDeServicio(mantenimiento.getFechaDeServicio());
        existente.setTipoDeServicio(mantenimiento.getTipoDeServicio());
        existente.setVehiculo(mantenimiento.getVehiculo());
        return mantenimientoRepository.save(existente);
    }

    /**
     * Elimina un mantenimiento por su ID.
     */
    public void deleteMantenimiento(Long id) {
        MantenimientoEntity mantenimiento = getMantenimiento(id);
        mantenimientoRepository.delete(mantenimiento);
    }

    /**
     * Busca mantenimientos por fecha de servicio.
     */
    public List<MantenimientoEntity> findByFechaDeServicio(String fechaDeServicio) {
        return mantenimientoRepository.findByFechaDeServicio(fechaDeServicio);
    }

    /**
     * Busca mantenimientos por tipo de servicio.
     */
    public List<MantenimientoEntity> findByTipoDeServicio(String tipoDeServicio) {
        return mantenimientoRepository.findByTipoDeServicio(tipoDeServicio);
    }

    /**
     * Elimina mantenimientos por fecha de servicio.
     */
    @Transactional
    public void deleteByFechaDeServicio(String fechaDeServicio) {
        mantenimientoRepository.deleteByFechaDeServicio(fechaDeServicio);
    }

    /**
     * Elimina mantenimientos por tipo de servicio.
     */
    @Transactional
    public void deleteByTipoDeServicio(String tipoDeServicio) {
        mantenimientoRepository.deleteByTipoDeServicio(tipoDeServicio);
    }

    /**
     * Elimina un mantenimiento por su ID usando el método personalizado.
     */
    @Transactional
    public void deleteByIdCustom(long id) {
        mantenimientoRepository.deleteById(id);
    }
}
