package co.edu.udistrital.mdp.carmotor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.repositories.MantenimientoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class MantenimientoService {

    @Autowired
    MantenimientoRepository mantenimientoRepository;

}
