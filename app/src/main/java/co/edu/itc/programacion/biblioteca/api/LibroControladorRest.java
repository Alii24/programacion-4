package co.edu.itc.programacion.biblioteca.api;

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
        return biblioteca.obtenerLibroDTO(id);
    }

    @PostMapping
    public void crear(@RequestBody LibroRepresentacion libro) {
        biblioteca.crearLibroDTO(libro);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable Integer id, @RequestBody LibroRepresentacion libro) {
        biblioteca.modificarLibroDTO(id, libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        biblioteca.eliminarLibro(id);
    }
}
