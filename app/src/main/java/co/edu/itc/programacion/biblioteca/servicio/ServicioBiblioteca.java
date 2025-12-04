package co.edu.itc.programacion.biblioteca.servicio;

import co.edu.itc.programacion.biblioteca.modelo.*;
import co.edu.itc.programacion.biblioteca.representacion.*;
import co.edu.itc.programacion.biblioteca.repositorio.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ServicioBiblioteca {

    private final RepositorioLibro repositorioLibro;
    private final RepositorioPeriodico repositorioPeriodico;
    private final RepositorioComputador repositorioComputador;

    public ServicioBiblioteca(
            RepositorioLibro repositorioLibro,
            RepositorioPeriodico repositorioPeriodico,
            RepositorioComputador repositorioComputador) {
        this.repositorioLibro = repositorioLibro;
        this.repositorioPeriodico = repositorioPeriodico;
        this.repositorioComputador = repositorioComputador;
    }

    private LibroRepresentacion mapearLibro(Libro l) {
        if (l == null) return null;
        LibroRepresentacion dto =
                new LibroRepresentacion(l.getId(), l.getNombre(), l.getAutor(), l.getAnio(), l.getIsbn());

        dto.setFechaRegistro(l.getFechaRegistro());
        dto.setTipoRecurso("LIBRO");
        return dto;
    }

    private PeriodicoRepresentacion mapearPeriodico(Periodico p) {
        if (p == null) return null;
        PeriodicoRepresentacion dto =
                new PeriodicoRepresentacion(p.getId(), p.getNombre(), p.getEditorial(), p.getAnio());

        dto.setFechaRegistro(p.getFechaRegistro());
        dto.setTipoRecurso("PERIODICO");
        return dto;
    }

    private ComputadorRepresentacion mapearComputador(Computador c) {
        if (c == null) return null;
        ComputadorRepresentacion dto =
                new ComputadorRepresentacion(c.getId(), c.getNombre(), c.getMarca(), c.getModelo(), c.getTipo().name());

        dto.setFechaRegistro(c.getFechaRegistro());
        dto.setTipoRecurso("COMPUTADOR");
        return dto;
    }


    private Libro mapearLibroEntidad(LibroRepresentacion dto) {
        return new Libro(dto.getId(), dto.getNombre(), dto.getAutor(), dto.getAnio(), dto.getIsbn());
    }

    private Periodico mapearPeriodicoEntidad(PeriodicoRepresentacion dto) {
        return new Periodico(dto.getId(), dto.getNombre(), dto.getEditorial(), dto.getAnio());
    }

    private Computador mapearComputadorEntidad(ComputadorRepresentacion dto) {
        return new Computador(dto.getId(), dto.getNombre(), dto.getMarca(), dto.getModelo(),
                TipoComputador.valueOf(dto.getTipo()));
    }


    public LibroRepresentacion obtenerLibroDTO(Integer id) {
        return repositorioLibro.findById(id).map(this::mapearLibro).orElse(null);
    }

    public void crearLibroDTO(LibroRepresentacion dto) {
        repositorioLibro.save(mapearLibroEntidad(dto));
    }

    public void modificarLibroDTO(Integer id, LibroRepresentacion dto) {
        dto.setId(id);
        repositorioLibro.save(mapearLibroEntidad(dto));
    }

    public void eliminarLibro(Integer id) {
        repositorioLibro.deleteById(id);
    }


    public PeriodicoRepresentacion obtenerPeriodicoDTO(Integer id) {
        return repositorioPeriodico.findById(id).map(this::mapearPeriodico).orElse(null);
    }

    public void crearPeriodicoDTO(PeriodicoRepresentacion dto) {
        repositorioPeriodico.save(mapearPeriodicoEntidad(dto));
    }

    public void modificarPeriodicoDTO(Integer id, PeriodicoRepresentacion dto) {
        dto.setId(id);
        repositorioPeriodico.save(mapearPeriodicoEntidad(dto));
    }

    public void eliminarPeriodico(Integer id) {
        repositorioPeriodico.deleteById(id);
    }

    public ComputadorRepresentacion obtenerComputadorDTO(Integer id) {
        return repositorioComputador.findById(id).map(this::mapearComputador).orElse(null);
    }

    public void crearComputadorDTO(ComputadorRepresentacion dto) {
        repositorioComputador.save(mapearComputadorEntidad(dto));
    }

    public void modificarComputadorDTO(Integer id, ComputadorRepresentacion dto) {
        dto.setId(id);
        repositorioComputador.save(mapearComputadorEntidad(dto));
    }

    public void eliminarComputador(Integer id) {
        repositorioComputador.deleteById(id);
    }

    public List<RecursoRepresentacion> listarTodosDTO() {

        List<RecursoRepresentacion> libros =
                StreamSupport.stream(repositorioLibro.findAll().spliterator(), false)
                        .map(this::mapearLibro)
                        .collect(Collectors.toList());

        List<RecursoRepresentacion> periodicos =
                StreamSupport.stream(repositorioPeriodico.findAll().spliterator(), false)
                        .map(this::mapearPeriodico)
                        .collect(Collectors.toList());

        List<RecursoRepresentacion> computadores =
                StreamSupport.stream(repositorioComputador.findAll().spliterator(), false)
                        .map(this::mapearComputador)
                        .collect(Collectors.toList());

        libros.addAll(periodicos);
        libros.addAll(computadores);

        return libros;
    }
}