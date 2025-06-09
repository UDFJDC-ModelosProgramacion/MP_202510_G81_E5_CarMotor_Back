package co.edu.udistrital.mdp.carmotor.repositories;

import co.edu.udistrital.mdp.carmotor.entities.Taller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TallerRepository extends JpaRepository<Taller, Long> {

    // Buscar talleres por dirección exacta
    @Query("SELECT t FROM Taller t WHERE t.direccion = ?1")
    List<Taller> findByDireccion(String direccion);

    // Buscar talleres por número exacto
    @Query("SELECT t FROM Taller t WHERE t.numero = ?1")
    List<Taller> findByNumero(String numero);

    // Buscar talleres cuyo horario contenga una cadena (parcial)
    @Query("SELECT t FROM Taller t WHERE LOWER(t.horario) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Taller> searchByHorario(String horarioParcial);

    // Contar cuántos talleres hay con un número específico
    @Query("SELECT COUNT(t) FROM Taller t WHERE t.numero = ?1")
    long countByNumero(String numero);

    // Buscar todos los talleres con un horario exacto
    @Query("SELECT t FROM Taller t WHERE t.horario = ?1")
    List<Taller> findByHorarioExacto(String horario);
}
