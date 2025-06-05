package co.edu.udistrital.mdp.carmotor.dto;
import lombok.Data;

@Data
public class MantenimientoDTO {
    
    private TallerDTO taller;
    private String fechaDeServicio;
    private String tipoDeServicio;
}
