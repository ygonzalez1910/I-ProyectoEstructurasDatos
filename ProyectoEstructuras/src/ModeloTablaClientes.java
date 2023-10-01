import javax.swing.table.AbstractTableModel;


public class ModeloTablaClientes extends AbstractTableModel {

    public ModeloTablaClientes(ConjuntoClientes clientes) {
        this.clientes = clientes;
    }


    @Override
    public int getRowCount() {
        return clientes.numClientes();

    }

    @Override
    public int getColumnCount() {
        return Cliente.nombreCampos().length;
    }

    @Override
    public String getColumnName(int col) {
        return Cliente.nombreCampos()[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return clientes.recuperar(rowIndex).toArray()[columnIndex];
    }

    private final ConjuntoClientes clientes;


}
