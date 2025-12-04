package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.representacion.ComputadorRepresentacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/computadores")
public class ComputadorControladorRest {

    private final ServicioBiblioteca biblioteca;

    public ComputadorControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public ComputadorRepresentacion obtenerPorId(@PathVariable Integer id) {
        return biblioteca.obtenerComputadorDTO(id);
    }

    @PostMapping
    public void crear(@RequestBody ComputadorRepresentacion computador) {
        biblioteca.crearComputadorDTO(computador);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable Integer id,
                          @RequestBody ComputadorRepresentacion computador) {
        biblioteca.modificarComputadorDTO(id, computador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        biblioteca.eliminarComputador(id);
    }
}
