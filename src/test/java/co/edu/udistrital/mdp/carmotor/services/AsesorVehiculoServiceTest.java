package co.edu.udistrital.mdp.carmotor.services;

import co.edu.udistrital.mdp.carmotor.entities.AsesorVehiculoEntity;
import co.edu.udistrital.mdp.carmotor.repositories.AsesorVehiculoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
@Import(AsesorVehiculoService.class)
public class AsesorVehiculoServiceTest {

    @Autowired
    private AsesorVehiculoService asesorVehiculoService;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AsesorVehiculoRepository asesorVehiculoRepository;

}
