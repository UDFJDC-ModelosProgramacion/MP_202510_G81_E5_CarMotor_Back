package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculoEntity;

@Repository
public interface AsesorVehiculoRepository extends JpaRepository<AsesorVehiculoEntity, Long> {

    List<AsesorVehiculoEntity>findByNombre(String nombre);
    List<AsesorVehiculoEntity> findByNumeroContacto(String numeroContacto);

    void deleteByNombre(String nombre);
    void deleteByNumeroContacto(String numeroContacto);

    void deleteById(long id);

}

