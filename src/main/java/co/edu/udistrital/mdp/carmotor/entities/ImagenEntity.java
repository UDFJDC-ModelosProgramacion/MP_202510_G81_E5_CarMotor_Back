package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ImagenEntity {
    private String url;
    private String ancho;
    private String alto;
}
