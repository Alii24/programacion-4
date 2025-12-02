package co.edu.itc.programacion.biblioteca.controlador;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import co.edu.itc.programacion.biblioteca.modelo.*;
import co.edu.itc.programacion.biblioteca.representacion.RecursoRepresentacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;

@RestController
@RequestMapping("/api/recursos")
public class RecursoRestController {

    private ServicioBiblioteca servicio = new ServicioBiblioteca();

    @GetMapping
    public List<RecursoRepresentacion> listar() {
        return servicio.listarTodos().stream()
                .map(r -> {
                    if (r instanceof Libro) return new RecursoRepresentacion(r.getId(), r.getNombre(), "libro", r.toString());
                    if (r instanceof Periodico) return new RecursoRepresentacion(r.getId(), r.getNombre(), "periodico", r.toString());
                    if (r instanceof Computador) return new RecursoRepresentacion(r.getId(), r.getNombre(), "computador", r.toString());
                    return null;
                })
                .toList();
    }
}
