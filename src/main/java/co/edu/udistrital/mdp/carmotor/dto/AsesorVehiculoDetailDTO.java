package co.edu.udistrital.mdp.carmotor.dto;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculoEntity;
import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AsesorVehiculoDetailDTO extends AsesorVehiculoDTO {

    private List<VehiculoDTO> vehiculos;

    public static AsesorVehiculoDetailDTO toDTO(AsesorVehiculoEntity entity) {
        AsesorVehiculoDetailDTO dto = new AsesorVehiculoDetailDTO();

        // Llamar al método base para cargar los atributos comunes
        AsesorVehiculoDTO baseDTO = AsesorVehiculoDTO.toDTO(entity);
        dto.setNombre(baseDTO.getNombre());
        dto.setNumeroContacto(baseDTO.getNumeroContacto());
        dto.setImagen(baseDTO.getImagen());

        // Convertir vehículos si existen
        if (entity.getVehiculos() != null) {
            dto.setVehiculos(entity.getVehiculos().stream()
                    .map(VehiculoDTO::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static AsesorVehiculoEntity toEntity(AsesorVehiculoDetailDTO dto) {
        AsesorVehiculoEntity entity = AsesorVehiculoDTO.toEntity(dto);

        if (dto.getVehiculos() != null) {
            List<VehiculoEntity> vehiculoEntities = dto.getVehiculos()
                    .stream()
                    .map(VehiculoDTO::toEntity)
                    .collect(Collectors.toList());
            entity.setVehiculos(vehiculoEntities);
        }

        return entity;
    }
}

