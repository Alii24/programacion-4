package co.edu.itc.programacion.biblioteca.servicio;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import co.edu.itc.programacion.biblioteca.modelo.Recurso;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioComputador;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioLibro;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioPeriodico;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioRecurso;
import java.util.ArrayList;
import java.util.List;

public class ServicioBiblioteca <T> {
    private RepositorioRecurso<Libro> repositorioLibro = new RepositorioLibro();
    private RepositorioRecurso<Periodico> repositorioPeriodico = new RepositorioPeriodico();
    private RepositorioRecurso<Computador> repositorioComputador = new RepositorioComputador();

    public ServicioBiblioteca(){
        
    }

    public Recurso agregar(Recurso recurso) {
        if (recurso == null) throw new IllegalArgumentException("el recurso es nulo");

        if (recurso instanceof Libro) {
            repositorioLibro.guardar((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            repositorioPeriodico.guardar((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            repositorioComputador.guardar((Computador) recurso);
        } else {
            throw new IllegalArgumentException("no se reconoce el recurso");
        }
        return recurso;
    }

    public Recurso modificar(Integer id, Recurso recurso) {
        if (recurso == null) throw new IllegalArgumentException("el recurso es nulo\"");

        if (recurso instanceof Libro) {
            repositorioLibro.actualizar(id, (Libro) recurso);
        } else if (recurso instanceof Periodico) {
            repositorioPeriodico.actualizar(id, (Periodico) recurso);
        } else if (recurso instanceof Computador) {
            repositorioComputador.actualizar(id, (Computador) recurso);
        } else {
            throw new IllegalArgumentException("no se reconoce el recurso");
        }
        return recurso;
    }

    public boolean eliminarLibro(Integer id) {
         if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        return repositorioLibro.eliminar(id);
    }

    public boolean eliminarPeriodico(Integer id) {
        if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        return repositorioPeriodico.eliminar(id);
    }

    public boolean eliminarComputador(Integer id) {
        if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        return repositorioComputador.eliminar(id);
    }

    public List<Recurso> listarTodos() {
        List<Recurso> todos = new ArrayList<>();
        todos.addAll(repositorioLibro.listarTodos());
        todos.addAll(repositorioPeriodico.listarTodos());
        todos.addAll(repositorioComputador.listarTodos());
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

        return repositorioLibro.obtener(id);
    }

    public Periodico obtenerPeriodico(Integer id) {
        if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        return repositorioPeriodico.obtener(id);
    }

    public Computador obtenerComputador(Integer id) {
        if (id == null) 
            throw new IllegalArgumentException("el id es nulo");

        return repositorioComputador.obtener(id);
    }
}
