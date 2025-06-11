package co.edu.udistrital.mdp.carmotor.dto;
import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class VehiculoDetailDTO extends VehiculoDTO {

    private List<ImagenDTO> imagenes = new ArrayList<>();
    private List<MantenimientoDTO> mantenimientos = new ArrayList<>();
    private SeguroDTO seguro;
    private EntidadBancariaDTO entidadBancaria;

    public static VehiculoDetailDTO toDTO(VehiculoEntity entity) {
        if (entity == null) return null;

        VehiculoDetailDTO dto = new VehiculoDetailDTO();

        // Heredado de VehiculoDTO
        dto.setMarca(entity.getMarca());
        dto.setSerie(entity.getSerie());
        dto.setPlaca(entity.getPlaca());
        dto.setModelo(entity.getModelo());
        dto.setTipo(entity.getTipo());
        dto.setCapacidadPasajeros(entity.getCapacidadPasajeros());
        dto.setPrecio(entity.getPrecio());
        dto.setAsesorVehiculo(AsesorVehiculoDTO.toDTO(entity.getAsesorVehiculo()));
        dto.setSede(SedeDTO.toDTO(entity.getSede()));

        // Listas
        if (entity.getImagenes() != null) {
            dto.setImagenes(entity.getImagenes().stream()
                .map(ImagenDTO::toDTO)
                .collect(Collectors.toList()));
        }

        if (entity.getMantenimientos() != null) {
            dto.setMantenimientos(entity.getMantenimientos().stream()
                .map(MantenimientoDTO::toDTO)
                .collect(Collectors.toList()));
        }

        // Relaciones 1 a 1
        dto.setEntidadBancaria(EntidadBancariaDTO.toDTO(entity.getEntidadBancaria()));
        dto.setSeguro(SeguroDTO.toDTO(entity.getSeguro()));

        return dto;
    }

    public static VehiculoEntity toEntity(VehiculoDetailDTO dto) {
        if (dto == null) return null;

        VehiculoEntity entity = new VehiculoEntity();

        // Heredado de VehiculoDTO
        entity.setMarca(dto.getMarca());
        entity.setSerie(dto.getSerie());
        entity.setPlaca(dto.getPlaca());
        entity.setModelo(dto.getModelo());
        entity.setTipo(dto.getTipo());
        entity.setCapacidadPasajeros(dto.getCapacidadPasajeros());
        entity.setPrecio(dto.getPrecio());
        entity.setAsesorVehiculo(dto.getAsesorVehiculo() != null ? AsesorVehiculoDTO.toEntity(dto.getAsesorVehiculo()) : null);
        entity.setSede(dto.getSede() != null ? SedeDTO.toEntity(dto.getSede()) : null);

        // Listas
        if (dto.getImagenes() != null) {
            entity.setImagenes(dto.getImagenes().stream()
                .map(ImagenDTO::toEntity)
                .collect(Collectors.toList()));
        }

        if (dto.getMantenimientos() != null) {
            entity.setMantenimientos(dto.getMantenimientos().stream()
                .map(MantenimientoDTO::toEntity)
                .collect(Collectors.toList()));
        }

        // Relaciones 1 a 1
        entity.setEntidadBancaria(dto.getEntidadBancaria() != null ? EntidadBancariaDTO.toEntity(dto.getEntidadBancaria()) : null);
        entity.setSeguro(dto.getSeguro() != null ? SeguroDTO.toEntity(dto.getSeguro()) : null);

        return entity;
    }
}

