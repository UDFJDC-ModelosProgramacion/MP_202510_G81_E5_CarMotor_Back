package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.dto.AsesorVehiculoDTO;
import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculoEntity;
import co.edu.udistrital.mdp.carmotor.repositories.AsesorVehiculoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsesorVehiculoService {

    @Autowired
    AsesorVehiculoRepository asesorVehiculoRepository;

    /**
     * Crea un nuevo asesor.
     * Reglas:
     * - No puede haber otro asesor con el mismo número de contacto.
     * - El nombre es obligatorio.
     */
    public AsesorVehiculoDTO createAsesor(AsesorVehiculoDTO asesorDTO) {
        if (asesorDTO.getNombre() == null || asesorDTO.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del asesor es obligatorio.");
        }

        if (asesorDTO.getNumeroContacto() != null && !asesorDTO.getNumeroContacto().trim().isEmpty()) {
            List<AsesorVehiculoEntity> existentes = asesorVehiculoRepository.findByNumeroContacto(asesorDTO.getNumeroContacto());
            if (!existentes.isEmpty()) {
                throw new IllegalArgumentException("Ya existe un asesor con este número de contacto.");
            }
        }

        AsesorVehiculoEntity entity = AsesorVehiculoDTO.toEntity(asesorDTO);
        return AsesorVehiculoDTO.toDTO(asesorVehiculoRepository.save(entity));
    }

    /**
     * Obtiene todos los asesores.
     */
    public List<AsesorVehiculoDTO> getAsesores() {
        return asesorVehiculoRepository.findAll()
                .stream()
                .map(AsesorVehiculoDTO::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un asesor por ID.
     */
    public AsesorVehiculoDTO getAsesor(Long id) {
        return asesorVehiculoRepository.findById(id)
                .map(AsesorVehiculoDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Asesor no encontrado con id: " + id));
    }

    /**
     * Actualiza la información de un asesor.
     * Reglas:
     * - No puede haber otro asesor con el mismo número de contacto.
     * - El nombre es obligatorio.
     */
    public AsesorVehiculoDTO updateAsesor(Long id, AsesorVehiculoDTO asesorDTO) {
        AsesorVehiculoEntity existente = asesorVehiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asesor no encontrado con id: " + id));

        if (asesorDTO.getNombre() == null || asesorDTO.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del asesor es obligatorio.");
        }

        if (asesorDTO.getNumeroContacto() != null && !asesorDTO.getNumeroContacto().equals(existente.getNumeroContacto())) {
            List<AsesorVehiculoEntity> conMismoContacto = asesorVehiculoRepository.findByNumeroContacto(asesorDTO.getNumeroContacto());
            if (!conMismoContacto.isEmpty()) {
                throw new IllegalArgumentException("Ya existe un asesor con este número de contacto.");
            }
        }

        existente.setNombre(asesorDTO.getNombre());
        existente.setNumeroContacto(asesorDTO.getNumeroContacto());
        // Puedes actualizar imagen y vehículos si lo deseas

        return AsesorVehiculoDTO.toDTO(asesorVehiculoRepository.save(existente));
    }

    /**
     * Borra un asesor por ID.
     * Regla: Solo puede borrarse si no tiene vehículos asociados.
     */
    public void deleteAsesor(Long id) {
        AsesorVehiculoEntity asesor = asesorVehiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asesor no encontrado con id: " + id));
        if (asesor.getVehiculos() != null && !asesor.getVehiculos().isEmpty()) {
            throw new IllegalStateException("No se puede eliminar el asesor porque tiene vehículos asociados.");
        }
        asesorVehiculoRepository.delete(asesor);
    }
}



