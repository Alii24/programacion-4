package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioRecursoBase<T> implements RepositorioRecurso<T> {
    private ArrayList<T> listaRecurso;

    protected  RepositorioRecursoBase() {
        this.listaRecurso = new ArrayList<>();
    }

    protected List<T> getListaRecurso(){
        return listaRecurso;
    }

    @Override
    public T guardar(T recurso){
        listaRecurso.add(recurso); 
        return recurso;
    }

    @Override
    public T actualizar(int id, T recurso){
        listaRecurso.set(id, recurso);
        return recurso;
    }

    @Override
    public boolean eliminar(int id){
        if (id < listaRecurso.size()){
            listaRecurso.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T obtener(int id){
        if (id < listaRecurso.size()){
            return listaRecurso.get(id);
        } else {
            return null;
        }
    }

    @Override
    public List<T> listarTodos(){
        return new ArrayList<>(listaRecurso);
    }
}
