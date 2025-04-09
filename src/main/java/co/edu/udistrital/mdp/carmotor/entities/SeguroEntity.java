package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class SeguroEntity {
    private String valorAnual;
    private String entidadAseguradora;
}
