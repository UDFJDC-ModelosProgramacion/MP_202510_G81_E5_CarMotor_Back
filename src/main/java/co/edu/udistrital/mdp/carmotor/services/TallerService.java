package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.mdp.carmotor.entities.TallerEntity;
import co.edu.udistrital.mdp.carmotor.repositories.TallerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TallerService {

    @Autowired
    private TallerRepository tallerRepository;

    /**
     * Crea un nuevo taller.
     */
    public TallerEntity createTaller(TallerEntity taller) {
        return tallerRepository.save(taller);
    }

    /**
     * Obtiene todos los talleres.
     */
    public List<TallerEntity> getTalleres() {
        return tallerRepository.findAll();
    }

    /**
     * Obtiene un taller por su ID.
     */
    public TallerEntity getTaller(Long id) {
        return tallerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Taller no encontrado con ID: " + id));
    }

    /**
     * Actualiza los datos de un taller.
     */
    public TallerEntity updateTaller(Long id, TallerEntity taller) {
        TallerEntity existente = getTaller(id);
        existente.setDireccion(taller.getDireccion());
        existente.setHorario(taller.getHorario());
        existente.setNumero(taller.getNumero());
        existente.setMantenimiento(taller.getMantenimiento());
        return tallerRepository.save(existente);
    }

    /**
     * Elimina un taller por su ID.
     */
    public void deleteTaller(Long id) {
        TallerEntity taller = getTaller(id);
        tallerRepository.delete(taller);
    }

    /**
     * Busca talleres por dirección.
     */
    public List<TallerEntity> findByDireccion(String direccion) {
        return tallerRepository.findByDireccion(direccion);
    }

    /**
     * Busca talleres por horario.
     */
    public List<TallerEntity> findByHorario(String horario) {
        return tallerRepository.findByHorario(horario);
    }

    /**
     * Busca talleres por número.
     */
    public List<TallerEntity> findByNumero(String numero) {
        return tallerRepository.findByNumero(numero);
    }

    /**
     * Elimina talleres por dirección.
     */
    @Transactional
    public void deleteByDireccion(String direccion) {
        tallerRepository.deleteByDireccion(direccion);
    }

    /**
     * Elimina talleres por horario.
     */
    @Transactional
    public void deleteByHorario(String horario) {
        tallerRepository.deleteByHorario(horario);
    }

    /**
     * Elimina talleres por número.
     */
    @Transactional
    public void deleteByNumero(String numero) {
        tallerRepository.deleteByNumero(numero);
    }

    /**
     * Elimina un taller por su ID usando el método personalizado.
     */
    @Transactional
    public void deleteByIdCustom(long id) {
        tallerRepository.deleteById(id);
    }
}
