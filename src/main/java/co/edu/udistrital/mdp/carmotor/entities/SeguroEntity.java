package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class SeguroEntity extends BaseEntity {
    private String valorAnual;
    private String entidadAseguradora;
}
