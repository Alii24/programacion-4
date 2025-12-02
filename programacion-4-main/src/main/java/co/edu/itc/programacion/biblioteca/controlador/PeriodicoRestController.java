package co.edu.itc.programacion.biblioteca.controlador;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.representacion.PeriodicoRepresentacion;

@RestController
@RequestMapping("/api/periodicos")
public class PeriodicoRestController {

    private ServicioBiblioteca servicio = new ServicioBiblioteca();

    @GetMapping
    public List<PeriodicoRepresentacion> listar() {
        return servicio.listarTodos().stream()
                .filter(r -> r instanceof Periodico)
                .map(r -> {
                    Periodico p = (Periodico) r;
                    return new PeriodicoRepresentacion(
                        p.getId(),
                        p.getNombre(),
                        p.getEditorial(),
                        p.getAnio()
                    );
                })
                .toList();
    }

    @GetMapping("/{id}")
    public PeriodicoRepresentacion obtener(@PathVariable Integer id) {
        Periodico p = servicio.obtenerPeriodico(id);
        return new PeriodicoRepresentacion(p.getId(), p.getNombre(), p.getEditorial(), p.getAnio());
    }

    @PostMapping
    public void crear(@RequestBody PeriodicoRepresentacion dto) {
        servicio.agregar(new Periodico(null, dto.nombre, dto.editorial, dto.anio));
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable Integer id, @RequestBody PeriodicoRepresentacion dto) {
        servicio.modificar(id, new Periodico(id, dto.nombre, dto.editorial, dto.anio));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminarPeriodico(id);
    }
}
