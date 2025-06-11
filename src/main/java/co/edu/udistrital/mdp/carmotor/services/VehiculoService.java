package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.dto.VehiculoDTO;
import co.edu.udistrital.mdp.carmotor.dto.VehiculoDetailDTO;
import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;
import co.edu.udistrital.mdp.carmotor.repositories.VehiculoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public VehiculoDetailDTO createVehiculo(VehiculoDTO dto) {
    VehiculoEntity entity = VehiculoDTO.toEntity(dto);
    VehiculoEntity saved = vehiculoRepository.save(entity);
    return VehiculoDetailDTO.toDTO(saved);
}

    public List<VehiculoDetailDTO> getVehiculos() {
        return vehiculoRepository.findAll()
                .stream()
                .map(VehiculoDetailDTO::toDTO)
                .collect(Collectors.toList());
    }

    public VehiculoDetailDTO getVehiculo(Long id) {
        return vehiculoRepository.findById(id)
                .map(VehiculoDetailDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado con ID: " + id));
    }

    public VehiculoDetailDTO updateVehiculo(Long id, VehiculoDTO dto) {
    VehiculoEntity existente = vehiculoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado con ID: " + id));
    existente.setMarca(dto.getMarca());
    existente.setSerie(dto.getSerie());
    existente.setPlaca(dto.getPlaca());
    existente.setModelo(dto.getModelo());
    VehiculoEntity actualizado = vehiculoRepository.save(existente);
    return VehiculoDetailDTO.toDTO(actualizado);
}

    public void deleteVehiculo(Long id) {
        VehiculoEntity vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado con ID: " + id));
        vehiculoRepository.delete(vehiculo);
    }
}
