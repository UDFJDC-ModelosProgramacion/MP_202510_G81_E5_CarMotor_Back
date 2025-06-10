package co.edu.udistrital.mdp.carmotor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.mdp.carmotor.repositories.VehiculoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class VehiculoService {
 
    @Autowired
    VehiculoRepository vehiculoRepository;
}
