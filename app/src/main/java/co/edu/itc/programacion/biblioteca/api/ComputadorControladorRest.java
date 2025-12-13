package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.api.mapper.RecursoMapper;
import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.representacion.ComputadorRepresentacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;

@RestController
@RequestMapping("/api/computadores")
public class ComputadorControladorRest {

    private final ServicioBiblioteca biblioteca;

    public ComputadorControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public ComputadorRepresentacion obtenerPorId(@PathVariable Integer id) {
        Computador c = biblioteca.obtenerComputador(id);
        return (ComputadorRepresentacion) RecursoMapper.aRepresentacion(c);
    }

    @PostMapping
    public void crear(@RequestBody ComputadorRepresentacion dto) {
        Computador c = (Computador) RecursoMapper.aEntidad(dto);
        biblioteca.agregar(c);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable Integer id,
                           @RequestBody ComputadorRepresentacion dto) {
        Computador c = (Computador) RecursoMapper.aEntidad(dto);
        biblioteca.modificar(id, c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        biblioteca.eliminarComputador(id);
    }
}
