package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.dto.SedeDTO;
import co.edu.udistrital.mdp.carmotor.entities.SedeEntity;
import co.edu.udistrital.mdp.carmotor.repositories.SedeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public SedeDTO createSede(SedeDTO dto) {
        SedeEntity entity = SedeDTO.toEntity(dto);
        return SedeDTO.toDTO(sedeRepository.save(entity));
    }

    public List<SedeDTO> getSedes() {
        return sedeRepository.findAll()
                .stream()
                .map(SedeDTO::toDTO)
                .collect(Collectors.toList());
    }

    public SedeDTO getSede(Long id) {
        return sedeRepository.findById(id)
                .map(SedeDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Sede no encontrada con ID: " + id));
    }

    public SedeDTO updateSede(Long id, SedeDTO dto) {
        SedeEntity existente = sedeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sede no encontrada con ID: " + id));
        existente.setNombre(dto.getNombre());
        existente.setDireccion(dto.getDireccion());
        // Actualiza otros campos según tu DTO
        return SedeDTO.toDTO(sedeRepository.save(existente));
    }

    public void deleteSede(Long id) {
        SedeEntity sede = sedeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sede no encontrada con ID: " + id));
        sedeRepository.delete(sede);
    }

    // Métodos de búsqueda y borrado por campos, igual que arriba, usando DTO
}




