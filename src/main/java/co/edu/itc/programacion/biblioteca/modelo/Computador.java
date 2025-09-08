package co.edu.itc.programacion.biblioteca.modelo;

public class Computador extends Recurso {
    private String marca;
    private String modelo;
    private TipoComputador tipo;

    public Computador(int id, String nombre, String marca, String modelo, TipoComputador tipo){
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

    public String toString(){
        return "La Marca es: " + marca + "El Modelo es: " + modelo + "El Tipo es: " + tipo;
    }
}
