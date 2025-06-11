package co.edu.udistrital.mdp.carmotor.dto;

import co.edu.udistrital.mdp.carmotor.entities.SedeEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SedeDetailDTO extends SedeDTO {

    private List<VehiculoDTO> vehiculos = new ArrayList<>();
    private List<AsesorVehiculoDTO> asesores = new ArrayList<>();

    public static SedeDetailDTO toDTO(SedeEntity entity) {
        if (entity == null) return null;

        SedeDetailDTO dto = new SedeDetailDTO();
        dto.setNombre(entity.getNombre());
        dto.setDireccion(entity.getDireccion());
        dto.setTelefono(entity.getTelefono());
        dto.setHorario(entity.getHorario());

        if (entity.getVehiculos() != null) {
            dto.setVehiculos(entity.getVehiculos()
                .stream()
                .map(VehiculoDTO::toDTO)
                .collect(Collectors.toList()));
        }

        if (entity.getAsesores() != null) {
            dto.setAsesores(entity.getAsesores()
                .stream()
                .map(AsesorVehiculoDTO::toDTO)
                .collect(Collectors.toList()));
        }

        return dto;
    }

    public static SedeEntity toEntity(SedeDetailDTO dto) {
        if (dto == null) return null;

        SedeEntity entity = new SedeEntity();
        entity.setNombre(dto.getNombre());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setHorario(dto.getHorario());

        if (dto.getVehiculos() != null) {
            entity.setVehiculos(dto.getVehiculos()
                .stream()
                .map(VehiculoDTO::toEntity)
                .collect(Collectors.toList()));
        }

        if (dto.getAsesores() != null) {
            entity.setAsesores(dto.getAsesores()
                .stream()
                .map(AsesorVehiculoDTO::toEntity)
                .collect(Collectors.toList()));
        }

        return entity;
    }
}

