package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.api.mapper.RecursoMapper;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;
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
        Periodico p = biblioteca.obtenerPeriodico(id);
        return (PeriodicoRepresentacion) RecursoMapper.aRepresentacion(p);
    }

    @PostMapping
    public void crear(@RequestBody PeriodicoRepresentacion dto) {
        Periodico p = (Periodico) RecursoMapper.aEntidad(dto);
        biblioteca.agregar(p);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable Integer id,
                           @RequestBody PeriodicoRepresentacion dto) {
        Periodico p = (Periodico) RecursoMapper.aEntidad(dto);
        biblioteca.modificar(id, p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        biblioteca.eliminarPeriodico(id);
    }
}
