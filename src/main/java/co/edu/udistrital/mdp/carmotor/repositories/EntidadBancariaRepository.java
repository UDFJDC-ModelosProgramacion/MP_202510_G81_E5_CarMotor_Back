package co.edu.udistrital.mdp.carmotor.repositories;

import co.edu.udistrital.mdp.carmotor.entities.EntidadBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntidadBancariaRepository extends JpaRepository<EntidadBancaria, Long> {

    // Buscar por nombre exacto
    @Query("SELECT e FROM EntidadBancaria e WHERE e.nombre = ?1")
    List<EntidadBancaria> findByNombre(String nombre);

    // Buscar bancos cuyo nombre contenga una cadena
    @Query("SELECT e FROM EntidadBancaria e WHERE LOWER(e.nombre) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<EntidadBancaria> searchByNombre(String nombreParcial);

    // Buscar por número de teléfono del asesor
    @Query("SELECT e FROM EntidadBancaria e WHERE e.numeroTelefonoAsesor = ?1")
    EntidadBancaria findByNumeroTelefonoAsesor(String telefono);

    // Contar cuántas entidades bancarias hay con un nombre específico
    @Query("SELECT COUNT(e) FROM EntidadBancaria e WHERE e.nombre = ?1")
    long countByNombre(String nombre);
}

