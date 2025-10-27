package co.edu.itc.programacion.biblioteca.servicio;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import co.edu.itc.programacion.biblioteca.modelo.Recurso;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioComputador;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioLibro;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioPeriodico;

import org.springframework.stereotype.Service; 
import java.util.ArrayList;
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
        RepositorioComputador repositorioComputador) 
    {
        this.repositorioLibro = repositorioLibro;
        this.repositorioPeriodico = repositorioPeriodico;
        this.repositorioComputador = repositorioComputador;
    }

    public Recurso agregar(Recurso recurso) {
        if (recurso == null) throw new IllegalArgumentException("el recurso es nulo");

        if (recurso instanceof Libro) {
            return repositorioLibro.save((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.save((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.save((Computador) recurso);
        } else {
            throw new IllegalArgumentException("no se reconoce el recurso");
        }
    }

    public Recurso modificar(Integer id, Recurso recurso) {
        if (recurso == null) throw new IllegalArgumentException("el recurso es nulo");
        if (recurso instanceof Libro) {
             return repositorioLibro.save((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.save((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.save((Computador) recurso);
        } else {
            throw new IllegalArgumentException("no se reconoce el recurso");
        }
    }

    public boolean eliminarLibro(Integer id) {
         if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        repositorioLibro.deleteById(id);
        return !repositorioLibro.existsById(id); 
    }

    public boolean eliminarPeriodico(Integer id) {
        if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        repositorioPeriodico.deleteById(id);
        return !repositorioPeriodico.existsById(id);
    }

    public boolean eliminarComputador(Integer id) {
        if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        repositorioComputador.deleteById(id);
        return !repositorioComputador.existsById(id);
    }

    public List<Recurso> listarTodos() {
        List<Recurso> todos = new ArrayList<>();
        StreamSupport.stream(repositorioLibro.findAll().spliterator(), false).forEach(todos::add);
        StreamSupport.stream(repositorioPeriodico.findAll().spliterator(), false).forEach(todos::add);
        StreamSupport.stream(repositorioComputador.findAll().spliterator(), false).forEach(todos::add);
        
        return todos;
    }

    public List<Recurso> buscarPorCriterio(String criterio) {
        if (criterio == null) 
            throw new IllegalArgumentException("el criterio es nulo");
        List<Recurso> busqueda = new ArrayList<>();
        busqueda.addAll(repositorioLibro.buscarPorCriterio(criterio));
        busqueda.addAll(repositorioPeriodico.buscarPorCriterio(criterio));
        busqueda.addAll(repositorioComputador.buscarPorCriterio(criterio));
        return busqueda;
    }

    public Libro obtenerLibro(Integer id) {
        if (id == null) 
            throw new IllegalArgumentException("el id es nulo");
        return repositorioLibro.findById(id).orElse(null);
    }

    public Periodico obtenerPeriodico(Integer id) {
        if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        return repositorioPeriodico.findById(id).orElse(null);
    }

    public Computador obtenerComputador(Integer id) {
        if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        return repositorioComputador.findById(id).orElse(null);
    }
}