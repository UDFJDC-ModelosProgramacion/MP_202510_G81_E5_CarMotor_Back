package co.edu.udistrital.mdp.carmotor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional
@Import(SedeService.class)


public class SedeServiceTest {
    
    @Autowired
    private SedeService sedeService;

    @Autowired
    private TestEntityManager entityManager;

}
