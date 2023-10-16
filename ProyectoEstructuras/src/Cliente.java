import java.util.List;

//Prueba

public class Cliente {
    private String cedula;
    private String nombre;
    private String numeroTelefonico;
    private CuentaBancaria cuentaBancaria;
    private List<Solicitud> historialSolicitudes;

    public Cliente(CuentaBancaria cuentaBancaria, String nombre, String cedula, String noTelefono) {
        this.cuentaBancaria = cuentaBancaria;
        this.nombre = nombre;
        this.cedula = cedula;
        this.numeroTelefonico = noTelefono;

    }

   public void crearCuentaDebito(){

   }
   public void crearCuentaCredito(){

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



}