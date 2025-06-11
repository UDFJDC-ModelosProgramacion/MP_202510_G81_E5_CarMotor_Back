package co.edu.udistrital.mdp.carmotor.dto;

import co.edu.udistrital.mdp.carmotor.entities.SedeEntity;
import lombok.Data;

@Data
public class SedeDTO {

    private VehiculoDTO vehiculo;
    private AsesorVehiculoDTO asesorVehiculo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String horario;

    public static SedeDTO toDTO(SedeEntity entity) {
        if (entity == null) return null;

        SedeDTO dto = new SedeDTO();
        dto.setNombre(entity.getNombre());
        dto.setDireccion(entity.getDireccion());
        dto.setTelefono(entity.getTelefono());
        dto.setHorario(entity.getHorario());

        // Evitar ciclos o carga profunda innecesaria
        dto.setVehiculo(null);
        dto.setAsesorVehiculo(null);

        return dto;
    }

    public static SedeEntity toEntity(SedeDTO dto) {
        if (dto == null) return null;

        SedeEntity entity = new SedeEntity();
        entity.setNombre(dto.getNombre());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setHorario(dto.getHorario());

        // Evitar ciclos o carga profunda innecesaria
        entity.setVehiculos(null);
        entity.setAsesores(null);

        return entity;
    }
}

