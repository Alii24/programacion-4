package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.representacion.RecursoRepresentacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoControladorRest {

    private final ServicioBiblioteca biblioteca;

    public RecursoControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping
    public List<RecursoRepresentacion> listar() {
        return biblioteca.listarTodosDTO();
    }
}
