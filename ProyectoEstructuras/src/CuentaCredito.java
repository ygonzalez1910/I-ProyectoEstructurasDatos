public class CuentaCredito extends CuentaBancaria {
    private double limite;

    public CuentaCredito(String nombre, String cedula, String noTelefono) {
        super();
        this.setNombreCliente(nombre);
        this.setCedulaCliente(cedula);
        this.setNumeroTelefonoCliente(noTelefono);
        this.deposito(1000000);
    }

    @Override
    public String toString() {
        return "Número de Cuenta de Crédito: " + super.toString(); // Agrega el prefijo al número de cuenta
    }

}


