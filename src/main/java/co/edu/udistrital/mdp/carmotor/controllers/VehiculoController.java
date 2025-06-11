package co.edu.udistrital.mdp.carmotor.controllers;

<<<<<<< HEAD
import co.edu.udistrital.mdp.carmotor.dto.VehiculoDetailDTO;
import co.edu.udistrital.mdp.carmotor.services.VehiculoService;
=======
import java.util.List;

>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.List;
=======
import co.edu.udistrital.mdp.carmotor.entities.VehiculoEntity;
import co.edu.udistrital.mdp.carmotor.services.VehiculoService;
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
<<<<<<< HEAD
=======
    
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<VehiculoDetailDTO> create(@RequestBody VehiculoDetailDTO dto) {
        return ResponseEntity.ok(vehiculoService.createVehiculo(dto));
    }

    @GetMapping
    public List<VehiculoDetailDTO> getAll() {
        return vehiculoService.getVehiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDetailDTO> getById(@PathVariable Long id) {
=======
    public ResponseEntity<VehiculoEntity> createVehiculo(@RequestBody VehiculoEntity vehiculo) {
        return ResponseEntity.ok(vehiculoService.createVehiculo(vehiculo));
    }

    @GetMapping
    public ResponseEntity<List<VehiculoEntity>> getVehiculos() {
        return ResponseEntity.ok(vehiculoService.getVehiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoEntity> getVehiculo(@PathVariable Long id) {
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
        return ResponseEntity.ok(vehiculoService.getVehiculo(id));
    }

    @PutMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<VehiculoDetailDTO> update(@PathVariable Long id, @RequestBody VehiculoDetailDTO dto) {
        return ResponseEntity.ok(vehiculoService.updateVehiculo(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehiculoService.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }
}
=======
    public ResponseEntity<VehiculoEntity> updateVehiculo(@PathVariable Long id, @RequestBody VehiculoEntity vehiculo) {
        return ResponseEntity.ok(vehiculoService.updateVehiculo(id, vehiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable Long id) {
        vehiculoService.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/marca")
    public ResponseEntity<List<VehiculoEntity>> findByMarca(@RequestParam String marca) {
        return ResponseEntity.ok(vehiculoService.findByMarca(marca));
    }

    @GetMapping("/buscar/serie")
    public ResponseEntity<List<VehiculoEntity>> findBySerie(@RequestParam String serie) {
        return ResponseEntity.ok(vehiculoService.findBySerie(serie));
    }

    @GetMapping("/buscar/placa")
    public ResponseEntity<List<VehiculoEntity>> findByPlaca(@RequestParam String placa) {
        return ResponseEntity.ok(vehiculoService.findByPlaca(placa));
    }

    @GetMapping("/buscar/modelo")
    public ResponseEntity<List<VehiculoEntity>> findByModelo(@RequestParam String modelo) {
        return ResponseEntity.ok(vehiculoService.findByModelo(modelo));
    }

    @GetMapping("/buscar/tipo")
    public ResponseEntity<List<VehiculoEntity>> findByTipo(@RequestParam String tipo) {
        return ResponseEntity.ok(vehiculoService.findByTipo(tipo));
    }

    @GetMapping("/buscar/capacidad")
    public ResponseEntity<List<VehiculoEntity>> findByCapacidadPasajeros(@RequestParam String capacidadPasajeros) {
        return ResponseEntity.ok(vehiculoService.findByCapacidadPasajeros(capacidadPasajeros));
    }

    @GetMapping("/buscar/precio")
    public ResponseEntity<List<VehiculoEntity>> findByPrecio(@RequestParam Integer precio) {
        return ResponseEntity.ok(vehiculoService.findByPrecio(precio));
    }

    @DeleteMapping("/eliminar/marca")
    public ResponseEntity<Void> deleteByMarca(@RequestParam String marca) {
        vehiculoService.deleteByMarca(marca);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/serie")
    public ResponseEntity<Void> deleteBySerie(@RequestParam String serie) {
        vehiculoService.deleteBySerie(serie);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/placa")
    public ResponseEntity<Void> deleteByPlaca(@RequestParam String placa) {
        vehiculoService.deleteByPlaca(placa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/modelo")
    public ResponseEntity<Void> deleteByModelo(@RequestParam String modelo) {
        vehiculoService.deleteByModelo(modelo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/tipo")
    public ResponseEntity<Void> deleteByTipo(@RequestParam String tipo) {
        vehiculoService.deleteByTipo(tipo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/capacidad")
    public ResponseEntity<Void> deleteByCapacidadPasajeros(@RequestParam String capacidadPasajeros) {
        vehiculoService.deleteByCapacidadPasajeros(capacidadPasajeros);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/precio")
    public ResponseEntity<Void> deleteByPrecio(@RequestParam Integer precio) {
        vehiculoService.deleteByPrecio(precio);
        return ResponseEntity.noContent().build();
    }
}
>>>>>>> 2487b603985a876132e68e85065d28b75ad85ace
