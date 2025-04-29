package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class TallerEntity extends BaseEntity {
    private String direccion;
    private String numero;
    private String horario;
}