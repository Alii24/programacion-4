package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("LIBRO")
public class Libro extends Recurso {
    private String autor;
    private Integer anio;
    private String isbn;

    public Libro(Integer id, String nombre, String autor, Integer anio, String isbn){
        super(id, nombre);
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public String getAutor(){
        return autor;
    }

    public Integer getAnio(){
        return anio;
    }

    public String getIsbn(){
        return isbn;
    }
    @Override
    public String toString(){
        return "Libro [ id = " + getId() + ", nombre = " + getNombre() + ", autor = " + autor + ", año = " + anio + ", isbn = " + isbn;
    }
}
