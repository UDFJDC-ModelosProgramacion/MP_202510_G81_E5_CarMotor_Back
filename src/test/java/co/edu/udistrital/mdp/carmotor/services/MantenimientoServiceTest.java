package co.edu.udistrital.mdp.carmotor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional
@Import(MantenimientoService.class)


public class MantenimientoServiceTest {
 
    @Autowired
    private MantenimientoService mantenimientoService;

    @Autowired
    private TestEntityManager entityManager;

}
