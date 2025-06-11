package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.mdp.carmotor.dto.EntidadBancariaDTO;
import co.edu.udistrital.mdp.carmotor.entities.EntidadBancariaEntity;
import co.edu.udistrital.mdp.carmotor.repositories.EntidadBancariaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EntidadBancariaService {

    @Autowired
    private EntidadBancariaRepository entidadBancariaRepository;

    public EntidadBancariaDTO createEntidad(EntidadBancariaDTO dto) {
        EntidadBancariaEntity entity = EntidadBancariaDTO.toEntity(dto);
        return EntidadBancariaDTO.toDTO(entidadBancariaRepository.save(entity));
    }

    public List<EntidadBancariaDTO> getEntidades() {
        return entidadBancariaRepository.findAll()
                .stream()
                .map(EntidadBancariaDTO::toDTO)
                .collect(Collectors.toList());
    }

    public EntidadBancariaDTO getEntidad(Long id) {
        return entidadBancariaRepository.findById(id)
                .map(EntidadBancariaDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Entidad bancaria no encontrada con ID: " + id));
    }

    public EntidadBancariaDTO updateEntidad(Long id, EntidadBancariaDTO dto) {
        EntidadBancariaEntity existente = entidadBancariaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entidad bancaria no encontrada con ID: " + id));
        existente.setNombre(dto.getNombre());
        existente.setNumeroTelefonoAsesor(dto.getNumeroTelefonoAsesor());
        // Actualiza otros campos según tu DTO
        return EntidadBancariaDTO.toDTO(entidadBancariaRepository.save(existente));
    }

    public void deleteEntidad(Long id) {
        EntidadBancariaEntity entidad = entidadBancariaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entidad bancaria no encontrada con ID: " + id));
        entidadBancariaRepository.delete(entidad);
    }

    public List<EntidadBancariaDTO> findByNombre(String nombre) {
        return entidadBancariaRepository.findByNombre(nombre)
                .stream()
                .map(EntidadBancariaDTO::toDTO)
                .collect(Collectors.toList());
    }

    public List<EntidadBancariaDTO> findByNumeroTelefonoAsesor(String numeroTelefonoAsesor) {
        return entidadBancariaRepository.findByNumeroTelefonoAsesor(numeroTelefonoAsesor)
                .stream()
                .map(EntidadBancariaDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteByNombre(String nombre) {
        entidadBancariaRepository.deleteByNombre(nombre);
    }

    @Transactional
    public void deleteByNumeroTelefonoAsesor(String numeroTelefonoAsesor) {
        entidadBancariaRepository.deleteByNumeroTelefonoAsesor(numeroTelefonoAsesor);
    }

    @Transactional
    public void deleteByIdCustom(long id) {
        entidadBancariaRepository.deleteById(id);
    }
}
