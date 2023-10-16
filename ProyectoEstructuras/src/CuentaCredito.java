public class CuentaCredito extends CuentaBancaria{
    private double limite;

    public CuentaCredito(String numCuenta, double saldo,double limite) {
        super(numCuenta,saldo);
        this.limite = limite;
    }
}
