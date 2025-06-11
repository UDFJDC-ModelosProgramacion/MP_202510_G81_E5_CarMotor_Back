package co.edu.udistrital.mdp.carmotor.dto;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculoEntity;
import co.edu.udistrital.mdp.carmotor.entities.ImagenEntity;
import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;
import lombok.Data;

@Data
public class AsesorVehiculoDTO {

    private String nombre;
    private String numeroContacto;
    private ImagenDTO imagen;
    private VehiculoDTO vehiculo;

    // =========================
    // Conversión: Entity → DTO
    // =========================
    public static AsesorVehiculoDTO toDTO(AsesorVehiculoEntity entity) {
        AsesorVehiculoDTO dto = new AsesorVehiculoDTO();
        dto.setNombre(entity.getNombre());
        dto.setNumeroContacto(entity.getNumeroContacto());

        if (entity.getImagen() != null) {
            dto.setImagen(ImagenDTO.toDTO(entity.getImagen()));
        }

        if (entity.getVehiculos() != null && !entity.getVehiculos().isEmpty()) {
            // Solo tomamos el primer vehículo si hay más de uno
            dto.setVehiculo(VehiculoDTO.toDTO(entity.getVehiculos().get(0)));
        }

        return dto;
    }

    // =========================
    // Conversión: DTO → Entity
    // =========================
    public static AsesorVehiculoEntity toEntity(AsesorVehiculoDTO dto) {
        AsesorVehiculoEntity entity = new AsesorVehiculoEntity();
        entity.setNombre(dto.getNombre());
        entity.setNumeroContacto(dto.getNumeroContacto());

        if (dto.getImagen() != null) {
            ImagenEntity imagen = ImagenDTO.toEntity(dto.getImagen());
            entity.setImagen(imagen);
        }

        if (dto.getVehiculo() != null) {
            VehiculoEntity vehiculo = VehiculoDTO.toEntity(dto.getVehiculo());
            entity.getVehiculos().add(vehiculo);
        }

        return entity;
    }
}

