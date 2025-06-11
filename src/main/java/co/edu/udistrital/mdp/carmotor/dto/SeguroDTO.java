package co.edu.udistrital.mdp.carmotor.dto;

import co.edu.udistrital.mdp.carmotor.entities.SeguroEntity;
import lombok.Data;

@Data
public class SeguroDTO {
    private String valorAnual;
    private String entidadAseguradora;

    public static SeguroDTO toDTO(SeguroEntity entity) {
        if (entity == null) return null;

        SeguroDTO dto = new SeguroDTO();
        dto.setValorAnual(entity.getValorAnual());
        dto.setEntidadAseguradora(entity.getEntidadAseguradora());

        return dto;
    }

    public static SeguroEntity toEntity(SeguroDTO dto) {
        if (dto == null) return null;

        SeguroEntity entity = new SeguroEntity();
        entity.setValorAnual(dto.getValorAnual());
        entity.setEntidadAseguradora(dto.getEntidadAseguradora());

        return entity;
    }
}

