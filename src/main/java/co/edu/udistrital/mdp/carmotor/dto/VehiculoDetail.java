package co.edu.udistrital.mdp.carmotor.dto;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data

public class VehiculoDetail {
    private List<ImagenDTO> imagenes = new ArrayList<>();

	private List<MantenimientoDTO> mantenimientos = new ArrayList<>();

}
