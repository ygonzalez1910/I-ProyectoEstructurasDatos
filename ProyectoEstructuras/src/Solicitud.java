public class Solicitud {
    private Cliente cliente;
    private boolean tipoCuenta;
    private int estado;

    public void setEstado(int estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Solicitud{" +
                "cliente=" + cliente.toString() +
                ", tipoCuenta=" + tipoCuenta +
                ", estado=" + estado +
                '}';
    }
}
