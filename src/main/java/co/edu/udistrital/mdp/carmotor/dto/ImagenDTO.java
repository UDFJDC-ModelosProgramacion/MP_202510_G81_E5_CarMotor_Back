package co.edu.udistrital.mdp.carmotor.dto;

import co.edu.udistrital.mdp.carmotor.entities.ImagenEntity;
import lombok.Data;

@Data
public class ImagenDTO {

    private EntidadBancariaDTO entidadBancaria;

    private String url;
    private String ancho;
    private String alto;

    public static ImagenDTO toDTO(ImagenEntity entity) {
        if (entity == null) return null;
        ImagenDTO dto = new ImagenDTO();
        dto.setUrl(entity.getUrl());
        dto.setAncho(entity.getAncho());
        dto.setAlto(entity.getAlto());

        // No incluir la entidad bancaria completa para evitar ciclos
        dto.setEntidadBancaria(null); // o crear una versión simplificada sin imagen

        return dto;
    }

    public static ImagenEntity toEntity(ImagenDTO dto) {
    if (dto == null) return null;

    ImagenEntity entity = new ImagenEntity();
    entity.setUrl(dto.getUrl());
    entity.setAncho(dto.getAncho());
    entity.setAlto(dto.getAlto());
    entity.setEntidadBancaria(null); // Previene ciclos

    return entity;
}

}

