package co.edu.udistrital.mdp.carmotor.dto;

import co.edu.udistrital.mdp.carmotor.entities.EntidadBancariaEntity;
import lombok.Data;

@Data
public class EntidadBancariaDTO {

    private ImagenDTO logo;

    private String nombre;
    private String numeroTelefonoAsesor;

    public static EntidadBancariaDTO toDTO(EntidadBancariaEntity entity) {
        if (entity == null) return null;

        EntidadBancariaDTO dto = new EntidadBancariaDTO();
        dto.setNombre(entity.getNombre());
        dto.setNumeroTelefonoAsesor(entity.getNumeroTelefonoAsesor());

        if (entity.getLogo() != null) {
            dto.setLogo(ImagenDTO.toDTO(entity.getLogo()));
        }

        return dto;
    }

    public static EntidadBancariaEntity toEntity(EntidadBancariaDTO dto) {
        if (dto == null) return null;

        EntidadBancariaEntity entity = new EntidadBancariaEntity();
        entity.setNombre(dto.getNombre());
        entity.setNumeroTelefonoAsesor(dto.getNumeroTelefonoAsesor());

        if (dto.getLogo() != null) {
            entity.setLogo(ImagenDTO.toEntity(dto.getLogo()));
        }

        return entity;
    }
}


