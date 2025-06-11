package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.dto.SeguroDTO;
import co.edu.udistrital.mdp.carmotor.entities.SeguroEntity;
import co.edu.udistrital.mdp.carmotor.repositories.SeguroRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    public SeguroDTO createSeguro(SeguroDTO dto) {
        SeguroEntity entity = SeguroDTO.toEntity(dto);
        return SeguroDTO.toDTO(seguroRepository.save(entity));
    }

    public List<SeguroDTO> getSeguros() {
        return seguroRepository.findAll()
                .stream()
                .map(SeguroDTO::toDTO)
                .collect(Collectors.toList());
    }

    public SeguroDTO getSeguro(Long id) {
        return seguroRepository.findById(id)
                .map(SeguroDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Seguro no encontrado con ID: " + id));
    }

    public SeguroDTO updateSeguro(Long id, SeguroDTO dto) {
        SeguroEntity existente = seguroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seguro no encontrado con ID: " + id));
        existente.setValorAnual(dto.getValorAnual());
        existente.setEntidadAseguradora(dto.getEntidadAseguradora());
        // Actualiza otros campos según tu DTO
        return SeguroDTO.toDTO(seguroRepository.save(existente));
    }

    public void deleteSeguro(Long id) {
        SeguroEntity seguro = seguroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seguro no encontrado con ID: " + id));
        seguroRepository.delete(seguro);
    }
}
