import java.util.List;

//Prueba

public class Cliente {
    private String cedula;
    private String nombre;
    private String numeroTelefonico;
    private CuentaBancaria cuentaBancaria;
    private static CuentaCredito cuentaCredito;
    private List<Solicitud> historialSolicitudes;

    public Cliente(String nombre, String cedula, String noTelefono) {
        this.cuentaBancaria = new CuentaBancaria();
        this.nombre = nombre;
        this.cedula = cedula;
        this.numeroTelefonico = noTelefono;

    }

    public static CuentaCredito getCuentaCredito() {
        return cuentaCredito;
    }

   public void crearCuentaDebito(){

   }
   public void crearCuentaCredito(){

       this.cuentaCredito = new CuentaCredito(nombre, cedula, numeroTelefonico);

   }
   public String generarDeposito(double montoDeposito){

       return "";
   }

   public void mostrarHistorial(){

   }
   public void mostrarCuentas(){

   }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numeroTelefonico='" + numeroTelefonico + '\'' +
                ", cuentaBancaria=" + cuentaBancaria.toString() +
                ", historialSolicitudes=" + historialSolicitudes +
                '}';
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
}