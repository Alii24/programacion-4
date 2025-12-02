package co.edu.itc.programacion.biblioteca;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import co.edu.itc.programacion.biblioteca.modelo.Recurso;
import co.edu.itc.programacion.biblioteca.modelo.TipoComputador;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioComputador;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioLibro;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioPeriodico;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import java.util.List;

public class ServicioBibliotec {
    public static void main(String [] args){

        RepositorioLibro Libro = new RepositorioLibro();
        RepositorioPeriodico Periodico = new RepositorioPeriodico();
        RepositorioComputador Computador = new RepositorioComputador();
        ServicioBiblioteca servicio = new ServicioBiblioteca();
        
        servicio.agregar(new Libro(1, "El olvido que seremos", "Hector Abad Faciolince", 2006, "978-9580420575"));
        servicio.agregar(new Libro(2,  "Delirio", "Laura Restrepo", 2004, "978-9580420773"));
        servicio.agregar(new Libro(3,  "La hojarasca", "Gabriel Garcia Márquez", 1955, "978-9583002904"));

        servicio.agregar(new Periodico(4, "El Tiempo", "Casa Editorial El Tiempo", 1911));
        servicio.agregar(new Periodico(5, "El Espectador", "Grupo Gilinski", 1887));
        servicio.agregar(new Periodico(6, "La Republica", "Editora La Republica S.A.", 1954));

        servicio.agregar(new Computador(7, "Galaxy Tab S8", "Samsung", "Galaxy Tab S8 11", TipoComputador.TABLET));
        servicio.agregar(new Computador(8, "Pavilion 15", "HP", "15-eh2006la", TipoComputador.PORTATIL));
        servicio.agregar(new Computador(9, "Inspiron Desktop", "Dell", "Inspiron 3891", TipoComputador.ESCRITORIO));
    
        List<Recurso> resultados = servicio.buscarPorCriterio("olvido");
        System.out.println("Recursos que tienen: 'olvido': ");
        for (Recurso result : resultados) {
            System.out.println(result);
        }
        
        if (!resultados.isEmpty()) {
            Recurso cambio = resultados.get(0);
            if (cambio instanceof Libro libro) {
                cambio = new Libro(libro.getId(), "Nos olvidamos de ti", libro.getAutor(), libro.getAnio(), libro.getIsbn());
            } else if (cambio instanceof Computador computador) {
                cambio = new Computador(computador.getId(), "Nos olvidamos de ti", computador.getMarca(), computador.getModelo(), computador.getTipo());
            } else if (cambio instanceof Periodico periodico) {
                cambio = new Periodico(periodico.getId(), "Nos olvidamos de ti", periodico.getEditorial(), periodico.getAnio());
            }
            servicio.modificar(cambio.getId(), cambio);
            System.out.println("Primer recurso modificado: " + cambio);
        } else {
            System.out.println("No se encontraron recursos con ese criterio");
        }

        List<Recurso> eliminar = servicio.buscarPorCriterio("hojarasca");
        if (!eliminar.isEmpty()) {
            for (Recurso elim : eliminar) {
                if (elim instanceof Computador) {
                    servicio.eliminarComputador(elim.getId());
                } else if (elim instanceof Libro) {
                    servicio.eliminarLibro(elim.getId());
                } else if (elim instanceof Periodico) {
                    servicio.eliminarPeriodico(elim.getId());
                }
                System.out.println("Recurso(s) eliminado(s): " + elim);
            }
        } else {
            System.out.println("No se encontraron recursos con ese criterio");
        }

        System.out.println("Recursos obtenidos: ");
        servicio.listarTodos().forEach(System.out::println);
    }
}
