import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Empleado {
    private List<Cliente> clientes;
    private Queue<Solicitud> pendientes;
    private String nombre;
    private Stack<Cliente> commitments;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCliente(Cliente cliente) {
        //agrega los clientes a la lsta y a la pila
        if (cliente != null) {
            clientes.add(cliente);
            commitments.push(cliente);
        } else {
            System.out.println("No se puede agregar un cliente nulo.");
        }
    }

    public void eliminarCliente(String cedula) {

        //crea una variable para guardar el cliente que encuentre con la misma cedula
        Cliente clienteAEliminar = null;

        //utiliza un for para recorrer la lista y encontrar el que tenga la misma cedula
        for(Cliente cliente : clientes){
            if(cliente.getCedula().equals(cedula)){
                clienteAEliminar = cliente;
                break;
            }
        }

        //elimina el objeto de la lista y de la pila
        if(clienteAEliminar != null){
            clientes.remove(clienteAEliminar);
            commitments.pop();
            System.out.println("Cliente " + clienteAEliminar.getNombre() + " ha sido eliminado");
        }else{
            System.out.println("No se encontro el cliente con la cedula digitada");
        }
    }

    public void mostrarProximaSolicitud() {
    }

    public void gestionarProximaSolicitud(boolean estado) {
    }

    public boolean deshacerUltimoMovimiento() {
        return false;
    }
}
