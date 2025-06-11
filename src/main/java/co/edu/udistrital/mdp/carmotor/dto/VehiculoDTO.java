package co.edu.udistrital.mdp.carmotor.dto;

import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;
import lombok.Data;

@Data
public class VehiculoDTO {
    private String marca;
    private String serie;
    private String placa;
    private String modelo;
    private String tipo;
    private String capacidadPasajeros;
    private Integer precio;

    private AsesorVehiculoDTO asesorVehiculo;
    private SedeDTO sede;

    public static VehiculoDTO toDTO(VehiculoEntity entity) {
        if (entity == null) return null;
        VehiculoDTO dto = new VehiculoDTO();
        dto.setMarca(entity.getMarca());
        dto.setSerie(entity.getSerie());
        dto.setPlaca(entity.getPlaca());
        dto.setModelo(entity.getModelo());
        dto.setTipo(entity.getTipo());
        dto.setCapacidadPasajeros(entity.getCapacidadPasajeros());
        dto.setPrecio(entity.getPrecio());
        dto.setAsesorVehiculo(AsesorVehiculoDTO.toDTO(entity.getAsesorVehiculo()));
        dto.setSede(SedeDTO.toDTO(entity.getSede()));
        return dto;
    }

    public static VehiculoEntity toEntity(VehiculoDTO dto) {
        if (dto == null) return null;
        VehiculoEntity entity = new VehiculoEntity();
        entity.setMarca(dto.getMarca());
        entity.setSerie(dto.getSerie());
        entity.setPlaca(dto.getPlaca());
        entity.setModelo(dto.getModelo());
        entity.setTipo(dto.getTipo());
        entity.setCapacidadPasajeros(dto.getCapacidadPasajeros());
        entity.setPrecio(dto.getPrecio());
        entity.setAsesorVehiculo(dto.getAsesorVehiculo() != null ? AsesorVehiculoDTO.toEntity(dto.getAsesorVehiculo()) : null);
        entity.setSede(dto.getSede() != null ? SedeDTO.toEntity(dto.getSede()) : null);
        return entity;
    }
}

