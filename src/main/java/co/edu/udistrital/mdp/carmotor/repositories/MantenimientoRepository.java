package co.edu.udistrital.mdp.carmotor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.mdp.carmotor.entities.MantenimientoEntity;

@Repository
public interface MantenimientoRepository extends JpaRepository<MantenimientoEntity, Long>{
    
    List<MantenimientoEntity>findByFechaDeServicio(String fechaDeServicio);
    List<MantenimientoEntity> findByTipoDeServicio(String tipoDeServicio);
    
    void deleteByFechaDeServicio(String direccion);
    void deleteByTipoDeServicio(String horario);
    

    void deleteById(long id);


}
