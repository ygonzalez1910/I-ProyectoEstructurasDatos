import java.util.Random;

public class CuentaBancaria {
  private long numCuenta;
  private double saldo;
  private String nombreCliente;
  private String cedulaCliente;
  private String numeroTelefonoCliente;



    private long generarNumCuenta(){
        Random r = new Random();
        StringBuilder numCuenta = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            long digito = r.nextInt(10);
            numCuenta.append(digito);
        }
        return Long.parseLong(numCuenta.toString());
    }


    public double getSaldo() {
        return saldo;
    }

    public void setNombreCliente(String nombre) {
        this.nombreCliente = nombre;
    }

    public void setCedulaCliente(String cedula) {
        this.cedulaCliente = cedula;
    }

    public void setNumeroTelefonoCliente(String numeroTelefono) {
        this.numeroTelefonoCliente = numeroTelefono;
    }


    //constructor con parametros para poder heredar a cuentaCredito
    public CuentaBancaria(String numCuenta, double saldo) {
        this.numCuenta = generarNumCuenta();
        this.saldo = 0;
    }
    public CuentaBancaria() {
        this.numCuenta = generarNumCuenta();
        this.saldo = 0;
    }

    public double deposito(double montoDeposito){
        saldo += montoDeposito;
        return saldo;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numCuenta=" + numCuenta +
                ", saldo=" + saldo +
                '}';
    }
}

