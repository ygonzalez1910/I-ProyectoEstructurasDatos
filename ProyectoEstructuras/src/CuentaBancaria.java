public class CuentaBancaria {
    //preba

    //setters y getters
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteTrasaccion() {
        return limiteTrasaccion;
    }

    public void setLimiteTrasaccion(double limiteTrasaccion) {
        this.limiteTrasaccion = limiteTrasaccion;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    //implementacion de atributos
    private String tipoCuenta;
    private double saldo = 0;
    private double limiteTrasaccion;
    private Cliente propietario;
}
