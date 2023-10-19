import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Solicitar información del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese el número de teléfono del cliente: ");
        String numeroTelefono = scanner.nextLine();

        // Crear un cliente con la información ingresada
        Cliente cliente = new Cliente(nombre, cedula, numeroTelefono);

        // Mostrar información del cliente
        System.out.println("Información del cliente:");
        System.out.println(cliente);

        System.out.println("\nDesea abrir una cuenta de crédito (S/N)?");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            cliente.crearCuentaCredito();

            // Mostrar el saldo de la cuenta de crédito
            System.out.println("\nSaldo de la cuenta de crédito: $" + cliente.getCuentaCredito().getSaldo());
        } else {
            System.out.println("No se ha abierto una cuenta de crédito.");
        }

        // Mostrar información de cuenta de crédito
        System.out.println("Información de la cuenta de crédito:");
        if (cliente.getCuentaCredito() != null) {
            System.out.println(cliente.getCuentaCredito());
        } else {
            System.out.println("No se ha abierto una cuenta de crédito.");
        }


    }
}