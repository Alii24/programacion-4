package co.edu.itc.programacion.biblioteca.modelo;

public class Periodico extends Recurso{
    private String editorial;
    private int anio;
    
    public Periodico(int id, String nombre, String editorial, int anio){
        super(id, nombre);
        this.editorial = editorial;
        this.anio = anio;
    }

    public String getEditorial(){
        return editorial;
    }

    public int getAnio(){
        return anio;
    }

    @Override
    public String toString(){
        return "Periodico [ id = " + getId() + ", nombre = " + getNombre() + ", Editorial = " + editorial + ", año = " + anio;
    }
}
