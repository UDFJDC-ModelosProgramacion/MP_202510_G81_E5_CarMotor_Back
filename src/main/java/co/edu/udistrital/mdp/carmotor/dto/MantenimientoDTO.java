package co.edu.udistrital.mdp.carmotor.dto;

import co.edu.udistrital.mdp.carmotor.entities.MantenimientoEntity;
import lombok.Data;

@Data
public class MantenimientoDTO {

    private TallerDTO taller;
    private String fechaDeServicio;
    private String tipoDeServicio;

    public static MantenimientoDTO toDTO(MantenimientoEntity entity) {
        if (entity == null) return null;

        MantenimientoDTO dto = new MantenimientoDTO();
        dto.setFechaDeServicio(entity.getFechaDeServicio());
        dto.setTipoDeServicio(entity.getTipoDeServicio());

        if (entity.getTaller() != null) {
            dto.setTaller(TallerDTO.toDTO(entity.getTaller()));
        }

        return dto;
    }

    public static MantenimientoEntity toEntity(MantenimientoDTO dto) {
        if (dto == null) return null;

        MantenimientoEntity entity = new MantenimientoEntity();
        entity.setFechaDeServicio(dto.getFechaDeServicio());
        entity.setTipoDeServicio(dto.getTipoDeServicio());

        if (dto.getTaller() != null) {
            entity.setTaller(TallerDTO.toEntity(dto.getTaller()));
        }

        return entity;
    }
}

