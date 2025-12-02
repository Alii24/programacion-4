package co.edu.itc.programacion.biblioteca.representacion;

public class ComputadorRepresentacion extends RecursoRepresentacion {
    public String marca;
    public String modelo;
    public String tipoComputador;

    public ComputadorRepresentacion(Integer id, String nombre, String marca, String modelo, String tipoComputador) {
        super(id, nombre, "computador", null);
        this.marca = marca;
        this.modelo = modelo;
        this.tipoComputador = tipoComputador;
    }
}
