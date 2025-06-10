package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class SeguroEntity extends BaseEntity {

    @OneToOne
    private VehiculoEntity vehiculo;

    private String valorAnual;
    private String entidadAseguradora;
}
