package co.edu.udistrital.mdp.carmotor.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data

public class SedeDetailDTO extends SedeDTO{
    private List<VehiculoDTO> vehiculos = new ArrayList<>();

	private List<AsesorVehiculoDTO> asesores = new ArrayList<>();
}
