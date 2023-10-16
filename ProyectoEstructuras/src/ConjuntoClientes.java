import java.util.ArrayList;
public class ConjuntoClientes {
    //atributos
    private ArrayList<Cliente> clientes;
    public ConjuntoClientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    public void agregarCliente(String cedula, String nombre) {
        Cliente nuevoCliente = new Cliente(cedula, nombre);
        agregar(nuevoCliente);

    }
    public int numClientes() {
        return clientes.size();
    }

    public Cliente recuperar(int p) {
        return clientes.get(p);
    }
    public void eliminar(String cedula){
        for(int i=0; i < clientes.size(); i++){
            if(clientes.get(i).getCedula().equals(cedula)){
                clientes.remove(i);
            }
        }
    }
    public void agregar(Cliente nuevoCliente) {
        clientes.add(nuevoCliente);
    }

}
