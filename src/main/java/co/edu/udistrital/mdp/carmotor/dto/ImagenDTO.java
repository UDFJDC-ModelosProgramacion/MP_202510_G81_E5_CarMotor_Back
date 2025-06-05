package co.edu.udistrital.mdp.carmotor.dto;
import lombok.Data;

@Data
public class ImagenDTO {
    private EntidadBancariaDTO entidadBancaria;

    private String url;
    private String ancho;
    private String alto;
}
