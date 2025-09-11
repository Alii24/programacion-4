package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;

public interface RepositorioRecurso<T> {
    T guardar(T recurso);
    T actualizar(int id, T recurso);
    boolean eliminar(int id);
    T obtener(int id);
    List<T> listarTodos();
    List<T> buscarPorCriterio(String criterio);
}