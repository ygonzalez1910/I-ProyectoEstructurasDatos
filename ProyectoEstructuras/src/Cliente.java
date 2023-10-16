import java.util.Random;

//Prueba
//probita
public class Cliente {
    private String cedula;
    private String nombre;
    private long numCuenta;
    private int saldo;

    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.numCuenta = generarNumCuenta();
        this.saldo  = 0;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public long getNumCuenta() {
        return numCuenta;
    }
    public int getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numCuenta=" + numCuenta +
                ", saldo=" + saldo +
                '}';
    }

    private long generarNumCuenta(){
        Random r = new Random();
        StringBuilder numCuenta = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            long digito = r.nextInt(10);
            numCuenta.append(digito);
        }
        return Long.parseLong(numCuenta.toString());
    }

}