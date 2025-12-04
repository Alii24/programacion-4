package co.edu.itc.programacion.biblioteca.representacion;

import java.time.LocalDateTime;

public class ComputadorRepresentacion extends RecursoRepresentacion {

    private final String marca;
    private final String modelo;
    private final String tipo; 

    public ComputadorRepresentacion(Integer id, String nombre, LocalDateTime fechaRegistro, String marca, String modelo, String tipo) {
        super(id, "COMPUTADOR", nombre, fechaRegistro);
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }
}
