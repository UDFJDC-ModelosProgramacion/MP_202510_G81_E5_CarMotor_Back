package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Taller extends BaseEntity {
    private String direccion;
    private String numero;
    private String horario;
}