package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.dto.TallerDTO;
import co.edu.udistrital.mdp.carmotor.entities.TallerEntity;
import co.edu.udistrital.mdp.carmotor.repositories.TallerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TallerService {

    @Autowired
    private TallerRepository tallerRepository;

    public TallerDTO createTaller(TallerDTO dto) {
        TallerEntity entity = TallerDTO.toEntity(dto);
        return TallerDTO.toDTO(tallerRepository.save(entity));
    }

    public List<TallerDTO> getTalleres() {
        return tallerRepository.findAll()
                .stream()
                .map(TallerDTO::toDTO)
                .collect(Collectors.toList());
    }

    public TallerDTO getTaller(Long id) {
        return tallerRepository.findById(id)
                .map(TallerDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Taller no encontrado con ID: " + id));
    }

    public TallerDTO updateTaller(Long id, TallerDTO dto) {
        TallerEntity existente = tallerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Taller no encontrado con ID: " + id));
        existente.setDireccion(dto.getDireccion());
        existente.setHorario(dto.getHorario());
        // Actualiza otros campos según tu DTO
        return TallerDTO.toDTO(tallerRepository.save(existente));
    }

    public void deleteTaller(Long id) {
        TallerEntity taller = tallerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Taller no encontrado con ID: " + id));
        tallerRepository.delete(taller);
    }
}
