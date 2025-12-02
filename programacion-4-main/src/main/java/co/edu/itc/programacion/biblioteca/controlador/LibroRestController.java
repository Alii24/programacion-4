package co.edu.itc.programacion.biblioteca.controlador;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.representacion.LibroRepresentacion;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

    private ServicioBiblioteca servicio = new ServicioBiblioteca();

    @GetMapping
    public List<LibroRepresentacion> listar() {
        return servicio.listarTodos().stream()
                .filter(r -> r instanceof Libro)
                .map(r -> {
                    Libro l = (Libro) r;
                    return new LibroRepresentacion(
                        l.getId(),
                        l.getNombre(),
                        l.getAutor(),
                        l.getAnio(),
                        l.getIsbn()
                    );
                })
                .toList();
    }

    @GetMapping("/{id}")
    public LibroRepresentacion obtener(@PathVariable Integer id) {
        Libro l = servicio.obtenerLibro(id);
        return new LibroRepresentacion(l.getId(), l.getNombre(), l.getAutor(), l.getAnio(), l.getIsbn());
    }

    @PostMapping
    public void crear(@RequestBody LibroRepresentacion dto) {
        servicio.agregar(new Libro(null, dto.nombre, dto.autor, dto.anio, dto.isbn));
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable Integer id, @RequestBody LibroRepresentacion dto) {
        servicio.modificar(id, new Libro(id, dto.nombre, dto.autor, dto.anio, dto.isbn));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminarLibro(id);
    }
}
