package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPeriodico extends RepositorioRecursoBase<Periodico>{

    public RepositorioPeriodico() {
        super();
    }

    @Override
    public List<Periodico> buscarPorCriterio(String criterio) {
        List<Periodico> busqueda = new ArrayList<>();
        for (Periodico peri : getListaRecurso()){
            if(peri.getEditorial().contains(criterio) ||  peri.getNombre().contains(criterio)){
                busqueda.add(peri);
            }
        }
        return busqueda;
    }
}