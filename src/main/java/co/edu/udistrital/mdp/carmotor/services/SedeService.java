package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.entities.SedeEntity;
import co.edu.udistrital.mdp.carmotor.repositories.SedeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class SedeService {


    @Autowired
    private SedeRepository sedeRepository;

    /**
     * Crea una nueva sede.
     * Reglas:
     * - El nombre debe ser único.
     * - La dirección debe ser única.
     */
    public SedeEntity createSede(SedeEntity sede) {
        if (sedeRepository.existsByNombre(sede.getNombre())) {
            throw new IllegalArgumentException("Ya existe una sede con este nombre.");
        }
        if (sedeRepository.existsByDireccion(sede.getDireccion())) {
            throw new IllegalArgumentException("Ya existe una sede con esta dirección.");
        }
        return sedeRepository.save(sede);
    }

    /**
     * Obtiene todas las sedes.
     */
    public List<SedeEntity> getSedes() {
        return sedeRepository.findAll();
    }

    /**
     * Obtiene una sede por su ID.
     */
    public SedeEntity getSede(Long id) {
        return sedeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sede no encontrada con ID: " + id));
    }

    /**
     * Actualiza los datos de una sede.
     */
    public SedeEntity updateSede(Long id, SedeEntity sede) {
        SedeEntity existente = getSede(id);

        if (!existente.getNombre().equals(sede.getNombre()) && sedeRepository.existsByNombre(sede.getNombre())) {
            throw new IllegalArgumentException("Ya existe otra sede con ese nombre.");
        }
        if (!existente.getDireccion().equals(sede.getDireccion()) && sedeRepository.existsByDireccion(sede.getDireccion())) {
            throw new IllegalArgumentException("Ya existe otra sede con esa dirección.");
        }

        existente.setNombre(sede.getNombre());
        existente.setDireccion(sede.getDireccion());
        existente.setActiva(sede.isActiva());
        existente.setCapacidadMaxima(sede.getCapacidadMaxima());
        existente.setHorario(sede.getHorario());

        return sedeRepository.save(existente);
    }

    /**
     * Elimina una sede por su ID.
     */
    public void deleteSede(Long id) {
        SedeEntity sede = getSede(id);
        sedeRepository.delete(sede);
    }
}




