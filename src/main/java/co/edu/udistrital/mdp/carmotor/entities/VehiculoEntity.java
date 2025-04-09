package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class VehiculoEntity extends BaseEntity{
    private String marca;
    private String serie;
    private String placa;
    private String modelo;
    private String tipo;
    private String capacidadPasajeros;
    private Integer precio;

}
