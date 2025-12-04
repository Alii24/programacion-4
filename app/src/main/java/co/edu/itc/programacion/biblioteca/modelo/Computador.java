package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;


// CC-06: Anotar entidad concreta con @Table("COMPUTADOR") 
@Table("COMPUTADOR")
public class Computador extends Recurso {
    @Column("MARCA")
    private String marca;

    @Column("MODELO")
    private String modelo;

    @Column("TIPO")
    private TipoComputador tipo;

    public Computador(Integer id, String nombre, String marca, String modelo, TipoComputador tipo){
        super(id, nombre);
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public TipoComputador getTipo(){
        return tipo;
    }

    @Override
    public String toString(){
        return "Computador [ id = " + getId() + ", nombre = " + getNombre() + ", marca = " + marca + ", modelo = " + modelo + ", tipo = " + tipo + "]";
    }
}
