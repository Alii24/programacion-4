package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.representacion.PeriodicoRepresentacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/periodicos")
public class PeriodicoControladorRest {

    private final ServicioBiblioteca biblioteca;

    public PeriodicoControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public PeriodicoRepresentacion obtenerPorId(@PathVariable Integer id) {
        return biblioteca.obtenerPeriodicoDTO(id);
    }

    @PostMapping
    public void crear(@RequestBody PeriodicoRepresentacion periodico) {
        biblioteca.crearPeriodicoDTO(periodico);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable Integer id,
                          @RequestBody PeriodicoRepresentacion periodico) {
        biblioteca.modificarPeriodicoDTO(id, periodico);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        biblioteca.eliminarPeriodico(id);
    }
}
