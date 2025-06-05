package co.edu.udistrital.mdp.carmotor.dto;


import lombok.Data;

@Data
public class SedeDTO {
    private VehiculoDTO vehiculo;
    private AsesorVehiculoDTO asesorVehiculo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String horario;
}
