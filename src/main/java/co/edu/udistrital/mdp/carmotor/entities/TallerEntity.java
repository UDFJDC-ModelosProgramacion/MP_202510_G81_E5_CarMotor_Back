package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class TallerEntity extends BaseEntity {

    //1 a 1 con mantenimiento
    @PodamExclude
    @OneToOne
    private MantenimientoEntity mantenimiento;

    private String direccion;
    private String numero;
    private String horario;
}