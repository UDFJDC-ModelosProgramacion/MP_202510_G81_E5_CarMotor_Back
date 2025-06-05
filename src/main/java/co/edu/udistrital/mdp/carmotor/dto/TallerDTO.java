package co.edu.udistrital.mdp.carmotor.dto;
import lombok.Data;

@Data
public class TallerDTO {
    private MantenimientoDTO mantenimiento;

    private String direccion;
    private String numero;
    private String horario;
}
