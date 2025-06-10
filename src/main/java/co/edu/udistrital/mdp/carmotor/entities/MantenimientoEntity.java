package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class MantenimientoEntity extends BaseEntity{
    
    //1 a 1 con tallerentity
    @PodamExclude
    @OneToOne(mappedBy = "mantenimiento")
    private TallerEntity taller;

    @ManyToOne
    private VehiculoEntity vehiculo;

    private String fechaDeServicio;
    private String tipoDeServicio;
}
