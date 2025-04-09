package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculo;
import co.edu.udistrital.mdp.carmotor.entities.Taller;

public interface TallerRepository extends JpaRepository<AsesorVehiculo, Long> {
    
    List<Taller>findByDireccion(String direccion);
    List<Taller> findByHorario(String horario);
    List<Taller> findByNumero(String numero);
    void deleteByDireccion(String direccion);
    void deleteByHorario(String horario);
    void deleteByNumero(String numero);
    void deleteById(long id);
    void addTaller(Taller taller);
    void updateTaller(Taller taller);
}