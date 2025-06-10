package co.edu.udistrital.mdp.carmotor.services;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional
@Import(AsesorVehiculoService.class)

public class AsesorVehiculoServiceTest {
    
}
