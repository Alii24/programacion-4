package co.edu.itc.programacion.biblioteca.servicio;

import java.util.List;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import co.edu.itc.programacion.biblioteca.modelo.Recurso;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioRecurso;

public class ServicioBiblioteca <T> {
    private RepositorioRecurso<Libro> repositorioLibro;
    private RepositorioRecurso<Periodico> repositorioPeriodico;
    private RepositorioRecurso<Computador> repositorioComputador;

    public Recurso agregar(Recurso recurso) {
        
    }

    public Recurso modificar(Integer id, Recurso recurso) {
        
    }

    public boolean eliminarLibro(Integer id) {
        
    }

    public boolean eliminarPeriodico(Integer id) {
        
    }

    public boolean eliminarComputador(Integer id) {
        
    }

    public List<Recurso> listarTodos() {
        
    }

    public List<Recurso> buscarPorCriterio(String criterio) {
        
    }

    public Libro obtenerLibro(Integer id) {
        
    }

    public Periodico obtenerPeriodico(Integer id) {
        
    }

    public Computador obtenerComputador(Integer id) {
        
    }
}
