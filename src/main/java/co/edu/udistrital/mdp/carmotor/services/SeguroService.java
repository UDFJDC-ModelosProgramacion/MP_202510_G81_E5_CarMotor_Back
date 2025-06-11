package co.edu.udistrital.mdp.carmotor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.mdp.carmotor.entities.SeguroEntity;
import co.edu.udistrital.mdp.carmotor.repositories.SeguroRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    /**
     * Crea un nuevo seguro.
     */
    public SeguroEntity createSeguro(SeguroEntity seguro) {
        return seguroRepository.save(seguro);
    }

    /**
     * Obtiene todos los seguros.
     */
    public List<SeguroEntity> getSeguros() {
        return seguroRepository.findAll();
    }

    /**
     * Obtiene un seguro por su ID.
     */
    public SeguroEntity getSeguro(Long id) {
        return seguroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seguro no encontrado con ID: " + id));
    }

    /**
     * Actualiza los datos de un seguro.
     */
    public SeguroEntity updateSeguro(Long id, SeguroEntity seguro) {
        SeguroEntity existente = getSeguro(id);
        existente.setValorAnual(seguro.getValorAnual());
        existente.setEntidadAseguradora(seguro.getEntidadAseguradora());
        existente.setVehiculo(seguro.getVehiculo());
        return seguroRepository.save(existente);
    }

    /**
     * Elimina un seguro por su ID.
     */
    public void deleteSeguro(Long id) {
        SeguroEntity seguro = getSeguro(id);
        seguroRepository.delete(seguro);
    }

    /**
     * Busca seguros por valor anual.
     */
    public List<SeguroEntity> findByValorAnual(String valorAnual) {
        return seguroRepository.findByValorAnual(valorAnual);
    }

    /**
     * Busca seguros por entidad aseguradora.
     */
    public List<SeguroEntity> findByEntidadAseguradora(String entidadAseguradora) {
        return seguroRepository.findByEntidadAseguradora(entidadAseguradora);
    }

    /**
     * Elimina seguros por valor anual.
     */
    @Transactional
    public void deleteByValorAnual(String valorAnual) {
        seguroRepository.deleteByValorAnual(valorAnual);
    }

    /**
     * Elimina seguros por entidad aseguradora.
     */
    @Transactional
    public void deleteByEntidadAseguradora(String entidadAseguradora) {
        seguroRepository.deleteByEntidadAseguradora(entidadAseguradora);
    }
}
