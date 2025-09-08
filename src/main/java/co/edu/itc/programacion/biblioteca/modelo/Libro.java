package co.edu.itc.programacion.biblioteca.modelo;

public class Libro extends Recurso {
    private String autor;
    private int anio;
    private String isbn;

    public Libro(int id, String nombre, String autor, int anio, String isbn){
        super(id, nombre);
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public String getAutor(){
        return autor;
    }

    public int getAnio(){
        return anio;
    }

    public String getIsbn(){
        return isbn;
    }

    public String toString(){
        return "El Autor del libro es: " + autor + " Fue publicado en el año " + anio + " Y su codigo ISBN es " + isbn;
    }
}
