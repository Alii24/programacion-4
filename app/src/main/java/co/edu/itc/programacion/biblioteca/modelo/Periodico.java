package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.relational.core.mapping.Table;

@Table("PERIODICO")
public class Periodico extends Recurso{
    private String editorial;
    private Integer anio;
    
    public Periodico(Integer id, String nombre, String editorial, Integer anio){
        super(id, nombre);
        this.editorial = editorial;
        this.anio = anio;
    }

    public String getEditorial(){
        return editorial;
    }

    public Integer getAnio(){
        return anio;
    }

    @Override
    public String toString(){
        return "Periodico [ id = " + getId() + ", nombre = " + getNombre() + ", Editorial = " + editorial + ", año = " + anio;
    }
}
