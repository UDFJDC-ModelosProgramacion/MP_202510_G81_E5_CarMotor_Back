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

    @Test
    void testCreateAndGetAsesor() {
        AsesorVehiculoEntity asesor = new AsesorVehiculoEntity();
        asesor.setNombre("Juan");
        asesor.setNumeroContacto("12345");
        entityManager.persistAndFlush(asesor);

        AsesorVehiculoEntity found = asesorVehiculoService.getAsesor(asesor.getId());
        assertEquals("Juan", found.getNombre());
        assertEquals("12345", found.getNumeroContacto());
    }

    @Test
    void testGetAsesores() {
        AsesorVehiculoEntity asesor1 = new AsesorVehiculoEntity();
        asesor1.setNombre("A");
        asesor1.setNumeroContacto("1");
        entityManager.persist(asesor1);

        AsesorVehiculoEntity asesor2 = new AsesorVehiculoEntity();
        asesor2.setNombre("B");
        asesor2.setNumeroContacto("2");
        entityManager.persist(asesor2);

        entityManager.flush();

        assertEquals(2, asesorVehiculoService.getAsesores().size());
    }

    @Test
    void testUpdateAsesor() {
        AsesorVehiculoEntity asesor = new AsesorVehiculoEntity();
        asesor.setNombre("Pedro");
        asesor.setNumeroContacto("999");
        entityManager.persistAndFlush(asesor);

        AsesorVehiculoEntity cambios = new AsesorVehiculoEntity();
        cambios.setNombre("Pedro Nuevo");
        cambios.setNumeroContacto("999");

        AsesorVehiculoEntity actualizado = asesorVehiculoService.updateAsesor(asesor.getId(), cambios);
        assertEquals("Pedro Nuevo", actualizado.getNombre());
    }

    @Test
    void testDeleteAsesor() {
        AsesorVehiculoEntity asesor = new AsesorVehiculoEntity();
        asesor.setNombre("Eliminar");
        asesor.setNumeroContacto("000");
        entityManager.persistAndFlush(asesor);

        asesorVehiculoRepository.delete(asesor);
        assertTrue(asesorVehiculoRepository.findAll().isEmpty());
    }
}
