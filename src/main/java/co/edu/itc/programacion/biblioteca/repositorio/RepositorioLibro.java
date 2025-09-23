package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Libro;
import java.util.ArrayList;
import java.util.List;

public class RepositorioLibro extends RepositorioRecursoBase<Libro>{

    public RepositorioLibro() {
        super();
    }

    @Override
    public List<Libro> buscarPorCriterio(String criterio) {
        List<Libro> busqueda = new ArrayList<>();
        for (Libro lib : getListaRecurso()){
            if(lib.getAutor().contains(criterio) || lib.getIsbn().contains(criterio) || lib.getNombre().contains(criterio)){
                busqueda.add(lib);
            }
        }
        return busqueda;
    }
}

