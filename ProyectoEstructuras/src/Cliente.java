import java.util.Random;

public class Cliente {

    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.numCuenta = generarNumCuenta();
        this.saldo  = 0;
        this.estado = "Pendiente";
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
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Object[] toArray() {
        Object[] r = new Object[5];
        r[0] = cedula;
        r[1] = nombre;
        r[2] = numCuenta;
        r[3] = saldo;
        r[4] = estado;
        return r;
    }

    public static String[] nombreCampos() {
        return NOMBRE_CAMPOS;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ",N° Cuenta =" + numCuenta +
                ", saldo=" + saldo +
                ", estado='" + estado + '\'' +
                '}';
    }


    private static final String[] NOMBRE_CAMPOS = {"Cédula", "Nombre", "N° Cuenta", "Saldo", "Estado"};
    private String cedula;
    private String nombre;
    private long numCuenta;
    private int saldo;
    private String estado;


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