package co.edu.udistrital.mdp.carmotor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class AsesorVehiculoService {
    
    @Autowired
    private AsesorVehiculoService asesorVehiculoService;

    @Autowired
    private TestEntityManager entityManager;

}
