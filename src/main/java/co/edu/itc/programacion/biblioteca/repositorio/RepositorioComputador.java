package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import java.util.ArrayList;
import java.util.List;

public class RepositorioComputador extends RepositorioRecursoBase<Computador>{

    public RepositorioComputador() {
        super();
    }

    @Override
    public List<Computador> buscarPorCriterio(String criterio) {
        List<Computador> busqueda = new ArrayList<>();
        for (Computador compu : getListaRecurso()){
            if(compu.getMarca().contains(criterio) || compu.getModelo().contains(criterio) || compu.getNombre().contains(criterio)){
                busqueda.add(compu);
            }
        }
        return busqueda;
    }
}