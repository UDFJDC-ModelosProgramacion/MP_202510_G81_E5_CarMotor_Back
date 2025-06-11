package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.dto.MantenimientoDTO;
import co.edu.udistrital.mdp.carmotor.entities.MantenimientoEntity;
import co.edu.udistrital.mdp.carmotor.repositories.MantenimientoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    public MantenimientoDTO createMantenimiento(MantenimientoDTO dto) {
        MantenimientoEntity entity = MantenimientoDTO.toEntity(dto);
        return MantenimientoDTO.toDTO(mantenimientoRepository.save(entity));
    }

    public List<MantenimientoDTO> getMantenimientos() {
        return mantenimientoRepository.findAll()
                .stream()
                .map(MantenimientoDTO::toDTO)
                .collect(Collectors.toList());
    }

    public MantenimientoDTO getMantenimiento(Long id) {
        return mantenimientoRepository.findById(id)
                .map(MantenimientoDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Mantenimiento no encontrado con ID: " + id));
    }

    public MantenimientoDTO updateMantenimiento(Long id, MantenimientoDTO dto) {
        MantenimientoEntity existente = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mantenimiento no encontrado con ID: " + id));
        existente.setFechaDeServicio(dto.getFechaDeServicio());
        existente.setTipoDeServicio(dto.getTipoDeServicio());
        // Actualiza otros campos según tu DTO
        return MantenimientoDTO.toDTO(mantenimientoRepository.save(existente));
    }

    public void deleteMantenimiento(Long id) {
        MantenimientoEntity mantenimiento = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mantenimiento no encontrado con ID: " + id));
        mantenimientoRepository.delete(mantenimiento);
    }
}
