package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculoEntity;
import co.edu.udistrital.mdp.carmotor.repositories.AsesorVehiculoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class AsesorVehiculoService {
    
    @Autowired
    AsesorVehiculoRepository asesorVehiculoRepository;

    // Crea un nuevo asesor.
    // Reglas:
    // - No puede haber otro asesor con el mismo número de contacto.
    // - El nombre es obligatorio.
    //
    public AsesorVehiculoEntity createAsesor(AsesorVehiculoEntity asesor) {
        if (asesor.getNombre() == null || asesor.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del asesor es obligatorio.");
        }

        if (asesor.getNumeroContacto() != null && !asesor.getNumeroContacto().trim().isEmpty()) {
            List<AsesorVehiculoEntity> existentes = asesorVehiculoRepository.findByNumeroContacto(asesor.getNumeroContacto());
            if (!existentes.isEmpty()) {
                throw new IllegalArgumentException("Ya existe un asesor con este número de contacto.");
            }
        }

        return asesorVehiculoRepository.save(asesor);
    }

    /**
     * Obtiene todos los asesores.
     */
    public List<AsesorVehiculoEntity> getAsesores() {
        return asesorVehiculoRepository.findAll();
    }

    /**
     * Obtiene un asesor por ID.
     */
    public AsesorVehiculoEntity getAsesor(Long id) {
        return asesorVehiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asesor no encontrado con id: " + id));
    }

    /**
     * Actualiza la información de un asesor.
     * Reglas:
     * - No puede haber otro asesor con el mismo número de contacto.
     * - El nombre es obligatorio.
     */
    public AsesorVehiculoEntity updateAsesor(Long id, AsesorVehiculoEntity asesor) {
        AsesorVehiculoEntity existente = getAsesor(id);

        if (asesor.getNombre() == null || asesor.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del asesor es obligatorio.");
        }

        if (asesor.getNumeroContacto() != null && !asesor.getNumeroContacto().equals(existente.getNumeroContacto())) {
            List<AsesorVehiculoEntity> conMismoContacto = asesorVehiculoRepository.findByNumeroContacto(asesor.getNumeroContacto());
            if (!conMismoContacto.isEmpty()) {
                throw new IllegalArgumentException("Ya existe un asesor con este número de contacto.");
            }
        }

        existente.setNombre(asesor.getNombre());
        existente.setNumeroContacto(asesor.getNumeroContacto());
        existente.setSede(asesor.getSede());

        return asesorVehiculoRepository.save(existente);
    }

    /**
     * Borra un asesor por ID.
     * Regla: Solo puede borrarse si no tiene vehículos asociados.
     */
    public void deleteAsesor(Long id) {
        AsesorVehiculoEntity asesor = getAsesor(id);
        if (asesor.getVehiculos() != null && !asesor.getVehiculos().isEmpty()) {
            throw new IllegalStateException("No se puede eliminar el asesor porque tiene vehículos asociados.");
        }
        asesorVehiculoRepository.delete(asesor);
    }
}



