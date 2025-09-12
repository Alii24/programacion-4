package co.edu.itc.programacion.biblioteca;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import co.edu.itc.programacion.biblioteca.modelo.TipoComputador;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioComputador;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioLibro;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioPeriodico;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;

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
    
        

        System.out.println("Recursos obtenidos: ");
        servicio.listarTodos().forEach(System.out::println);
    }
}
