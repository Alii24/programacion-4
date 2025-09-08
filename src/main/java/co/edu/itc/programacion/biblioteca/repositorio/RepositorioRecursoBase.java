package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;

public abstract class RepositorioRecursoBase<T> implements RepositorioRecurso<T> {
    private List<T> listaRecurso;

    protected  RepositorioRecursoBase() {
    }

    public T guardar(T recurso){

    }

    public T actualizar(int id, T recurso){

    }

    public boolean eliminar(int id){

    }

    public T obtener(int id){

    }

    public List<T> listarTodos(){

    }
}
