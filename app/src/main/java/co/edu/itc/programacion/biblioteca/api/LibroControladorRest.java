package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.api.mapper.RecursoMapper;
import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.representacion.LibroRepresentacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libros")
public class LibroControladorRest {

    private final ServicioBiblioteca biblioteca;

    public LibroControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public LibroRepresentacion obtenerPorId(@PathVariable Integer id) {
        Libro libro = biblioteca.obtenerLibro(id);
        return (LibroRepresentacion) RecursoMapper.aRepresentacion(libro);
    }

    @PostMapping
    public void crear(@RequestBody LibroRepresentacion dto) {
        Libro libro = (Libro) RecursoMapper.aEntidad(dto);
        biblioteca.agregar(libro);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable Integer id,
                           @RequestBody LibroRepresentacion dto) {
        Libro libro = (Libro) RecursoMapper.aEntidad(dto);
        biblioteca.modificar(id, libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        biblioteca.eliminarLibro(id);
    }
}

