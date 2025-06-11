package co.edu.udistrital.mdp.carmotor.dto;

import co.edu.udistrital.mdp.carmotor.entities.TallerEntity;
import lombok.Data;

@Data
public class TallerDTO {

    private MantenimientoDTO mantenimiento; // manejado con precaución para evitar ciclos

    private String direccion;
    private String numero;
    private String horario;

    public static TallerDTO toDTO(TallerEntity entity) {
        if (entity == null) return null;

        TallerDTO dto = new TallerDTO();
        dto.setDireccion(entity.getDireccion());
        dto.setNumero(entity.getNumero());
        dto.setHorario(entity.getHorario());
        dto.setMantenimiento(null);

        return dto;
    }

    public static TallerEntity toEntity(TallerDTO dto) {
        if (dto == null) return null;

        TallerEntity entity = new TallerEntity();
        entity.setDireccion(dto.getDireccion());
        entity.setNumero(dto.getNumero());
        entity.setHorario(dto.getHorario());

        // Para evitar ciclos, puedes comentar o limitar esto:
        entity.setMantenimiento(null);

        return entity;
    }
}

