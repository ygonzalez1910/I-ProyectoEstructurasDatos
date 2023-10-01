import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;
import  java.util.Stack;


public class VentanaPrincipal extends JFrame {

    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton empleadoButton;
    private JTextField txtNombreNuevoCliente;
    private JTextField txtCedulaNuevoCliente;
    private JTextField txtNoCuentaNuevoCliente;
    private JTextField txtSaldoNuevoCliente;
    private JTextField txtCedulaBusqueda;
    private JButton buscarButton;
    private JTable table1;
    private JButton guardarButton;
    private JButton borrarButton;
    private JButton limpiarButton;
    private JButton clienteButton;
    private JButton deshacerClienteNuevoButton;
    private JButton deshacerClienteBorradoButton;
    private JButton atenderButton;
    private JTextField textFieldAgregarSaldo;
    private JButton agregarButton;
    private JTextField textFieldBuscarCedula;
    private JPanel panelSistemaBancario;
    private JPanel panelRegistroCliente;
    private JLabel nombreNuevoCliente;
    private JLabel cedulaNuevoCliente;
    private JLabel NoCuentaNuevoCliente;
    private JLabel saldoNuevoCliente;
    private JPanel busquedaPanel;
    private JLabel cedulaBusqueda;
    private JPanel panelListado;
    private ConjuntoClientes tiposDeClientes;
    private ModeloTablaClientes modeloTablaClientes;
    private Cliente cliente;
    private String cedulaGlobal;
    private Queue<Cliente> colaClientes;
    private Stack<Cliente> clientesAgredados;
    private Stack<Cliente> clientesBorrados;

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setMinimumSize(new Dimension(1400, 700));
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setContentPane(ventana.panel1);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Proyecto 1 Estructuras de Datos");
        ventana.setVisible(true);

    }

    public VentanaPrincipal(){

        tiposDeClientes = new ConjuntoClientes();
        modeloTablaClientes = new ModeloTablaClientes(tiposDeClientes);
        table1.setModel(modeloTablaClientes);
        colaClientes = new LinkedList<>();
        clientesAgredados = new Stack<>();
        clientesBorrados = new Stack<>();


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedulaNuevoCliente.getText();
                String nombre = txtNombreNuevoCliente.getText();
                cliente = new Cliente(cedula, nombre);
                tiposDeClientes.agregar(cliente);
                colaClientes.offer(cliente);
                clientesAgredados.push(cliente);
                modeloTablaClientes.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Cliente agregado");
            }

        });
        empleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarButton.setEnabled(true);
                limpiarButton.setEnabled(true);
                borrarButton.setEnabled(true);
                buscarButton.setEnabled(true);
                txtCedulaBusqueda.setEnabled(true);
                txtCedulaNuevoCliente.setEnabled(true);
                txtNombreNuevoCliente.setEnabled(true);
                table1.setEnabled(true);
                atenderButton.setEnabled(true);
                deshacerClienteBorradoButton.setEnabled(true);
                deshacerClienteNuevoButton.setEnabled(true);
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCedulaNuevoCliente.setText("");
                txtNombreNuevoCliente.setText("");
                txtNoCuentaNuevoCliente.setText("");
                txtSaldoNuevoCliente.setText("");
                txtCedulaBusqueda.setText("");
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tiposDeClientes.eliminar(cedulaGlobal);
                clientesBorrados.push(cliente);
                modeloTablaClientes.fireTableDataChanged();

                JOptionPane.showMessageDialog(null, "Cliente borrado");

            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = table1.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    String cedula = (String) table1.getValueAt(filaSeleccionada, 0);
                    String nombre = (String) table1.getValueAt(filaSeleccionada, 1);
                    long numCuenta = (long) table1.getValueAt(filaSeleccionada, 2);
                    int saldo = (int) table1.getValueAt(filaSeleccionada, 3);
                    String estado = (String) table1.getValueAt(filaSeleccionada, 4);

                    cedulaGlobal = cedula;
                    txtCedulaNuevoCliente.setText(cedula);
                    txtNombreNuevoCliente.setText(nombre);
                    txtNoCuentaNuevoCliente.setText(String.valueOf(numCuenta));
                    txtSaldoNuevoCliente.setText(String.valueOf(saldo));


                }
            }
        });
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarButton.setEnabled(false);
                limpiarButton.setEnabled(false);
                borrarButton.setEnabled(false);
                buscarButton.setEnabled(false);
                txtCedulaBusqueda.setEnabled(false);
                txtCedulaNuevoCliente.setEnabled(false);
                txtNombreNuevoCliente.setEnabled(false);
                table1.setEnabled(false);
                atenderButton.setEnabled(false);
                deshacerClienteBorradoButton.setEnabled(false);
                deshacerClienteNuevoButton.setEnabled(false);
            }
        });
        atenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!colaClientes.isEmpty()){
                    Cliente AtenderCliente = colaClientes.peek();
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea atender al cliente?\n" + "Cedula: " + AtenderCliente.getCedula() + "\nNombre: " + AtenderCliente.getNombre(), "Atender cliente", JOptionPane.YES_NO_OPTION);
                    if(opcion == JOptionPane.YES_OPTION){
                        AtenderCliente.setEstado("Aprobado");
                        colaClientes.poll();
                    }else{
                        AtenderCliente.setEstado("Rechazado");
                        colaClientes.poll();
                    }
                    modeloTablaClientes.fireTableDataChanged();
                }
            }
        });
        deshacerClienteNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!colaClientes.isEmpty()){
                    Cliente clienteDeshacer = clientesAgredados.pop();
                    tiposDeClientes.eliminar(clienteDeshacer.getCedula());
                    colaClientes.remove(clienteDeshacer);
                    modeloTablaClientes.fireTableDataChanged();
                    JOptionPane.showMessageDialog(null, "Cliente deshecho");
                }else{
                    JOptionPane.showMessageDialog(null, "No hay clientes para deshacer");
                }
            }
        });
        deshacerClienteBorradoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!colaClientes.isEmpty()){
                    Cliente clienteDeshacer = clientesBorrados.pop();
                    tiposDeClientes.agregar(clienteDeshacer);
                    colaClientes.offer(clienteDeshacer);
                    modeloTablaClientes.fireTableDataChanged();
                    JOptionPane.showMessageDialog(null, "Cliente borrado deshecho");
                }else{
                    JOptionPane.showMessageDialog(null, "No hay clientes borrados para deshacer");
                }
            }
        });


    }


}
