package co.edu.itc.programacion.biblioteca.controlador;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.modelo.TipoComputador;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.representacion.ComputadorRepresentacion;

@RestController
@RequestMapping("/api/computadores")
public class ComputadorRestController {

    private ServicioBiblioteca servicio = new ServicioBiblioteca();

    @GetMapping
    public List<ComputadorRepresentacion> listar() {
        return servicio.listarTodos().stream()
                .filter(r -> r instanceof Computador)
                .map(r -> {
                    Computador c = (Computador) r;
                    return new ComputadorRepresentacion(
                        c.getId(),
                        c.getNombre(),
                        c.getMarca(),
                        c.getModelo(),
                        c.getTipo().name()
                    );
                })
                .toList();
    }

    @GetMapping("/{id}")
    public ComputadorRepresentacion obtener(@PathVariable Integer id) {
        Computador c = servicio.obtenerComputador(id);
        return new ComputadorRepresentacion(
            c.getId(), c.getNombre(), c.getMarca(), c.getModelo(), c.getTipo().name()
        );
    }

    @PostMapping
    public void crear(@RequestBody ComputadorRepresentacion dto) {
        servicio.agregar(
            new Computador(null, dto.nombre, dto.marca, dto.modelo, TipoComputador.valueOf(dto.tipoComputador))
        );
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable Integer id, @RequestBody ComputadorRepresentacion dto) {
        servicio.modificar(
            id,
            new Computador(id, dto.nombre, dto.marca, dto.modelo, TipoComputador.valueOf(dto.tipoComputador))
        );
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminarComputador(id);
    }
}
