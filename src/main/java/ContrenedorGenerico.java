public class ContrenedorGenerico<O extends Number> {
    private O objeto;

    public ContrenedorGenerico(O objeto) {
        this.objeto = objeto;
    }

    public O getObjeto() {
        return objeto;
    }

    public void setObjeto(O objeto) {
        this.objeto = objeto;
    }
}