public class CuentaDebito extends CuentaBancaria {
    public CuentaDebito(String numCuenta, double saldo) {
        super(numCuenta, saldo);
    }

    //llamar al saldo de la clase base de cuentaBancaria para actualizarlo
    public boolean transferencia(double montoTransferencia){
        //saldo += montoTransferencia;
        return true;
    }
}
