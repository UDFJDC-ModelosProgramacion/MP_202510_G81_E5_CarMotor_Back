package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.mdp.carmotor.entities.EntidadBancariaEntity;
import co.edu.udistrital.mdp.carmotor.repositories.EntidadBancariaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EntidadBancariaService {

    @Autowired
    private EntidadBancariaRepository entidadBancariaRepository;

    /**
     * Crea una nueva entidad bancaria.
     */
    public EntidadBancariaEntity createEntidad(EntidadBancariaEntity entidad) {
        return entidadBancariaRepository.save(entidad);
    }

    /**
     * Obtiene todas las entidades bancarias.
     */
    public List<EntidadBancariaEntity> getEntidades() {
        return entidadBancariaRepository.findAll();
    }

    /**
     * Obtiene una entidad bancaria por su ID.
     */
    public EntidadBancariaEntity getEntidad(Long id) {
        return entidadBancariaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entidad bancaria no encontrada con ID: " + id));
    }

    /**
     * Actualiza los datos de una entidad bancaria.
     */
    public EntidadBancariaEntity updateEntidad(Long id, EntidadBancariaEntity entidad) {
        EntidadBancariaEntity existente = getEntidad(id);
        existente.setNombre(entidad.getNombre());
        existente.setNumeroTelefonoAsesor(entidad.getNumeroTelefonoAsesor());
        existente.setVehiculo(entidad.getVehiculo());
        return entidadBancariaRepository.save(existente);
    }

    /**
     * Elimina una entidad bancaria por su ID.
     */
    public void deleteEntidad(Long id) {
        EntidadBancariaEntity entidad = getEntidad(id);
        entidadBancariaRepository.delete(entidad);
    }

    /**
     * Busca entidades bancarias por nombre.
     */
    public List<EntidadBancariaEntity> findByNombre(String nombre) {
        return entidadBancariaRepository.findByNombre(nombre);
    }

    /**
     * Busca entidades bancarias por número de teléfono del asesor.
     */
    public List<EntidadBancariaEntity> findByNumeroTelefonoAsesor(String numeroTelefonoAsesor) {
        return entidadBancariaRepository.findByNumeroTelefonoAsesor(numeroTelefonoAsesor);
    }

    /**
     * Elimina entidades bancarias por nombre.
     */
    @Transactional
    public void deleteByNombre(String nombre) {
        entidadBancariaRepository.deleteByNombre(nombre);
    }

    /**
     * Elimina entidades bancarias por número de teléfono del asesor.
     */
    @Transactional
    public void deleteByNumeroTelefonoAsesor(String numeroTelefonoAsesor) {
        entidadBancariaRepository.deleteByNumeroTelefonoAsesor(numeroTelefonoAsesor);
    }

    /**
     * Elimina una entidad bancaria por su ID usando el método personalizado.
     */
    @Transactional
    public void deleteByIdCustom(long id) {
        entidadBancariaRepository.deleteById(id);
    }
}
