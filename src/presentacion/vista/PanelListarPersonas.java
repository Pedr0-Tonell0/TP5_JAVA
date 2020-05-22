package presentacion.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.JTable;

public class PanelListarPersonas extends JPanel {

	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"DNI","Nombre","Apeliido"};
	private JTable tablaPersonas;

	public PanelListarPersonas() {

		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);

        modelPersonas = new DefaultTableModel(null,nombreColumnas);
		
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(28, 75, 383, 126);
		add(spPersonas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
		

	}

	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}

	public void setModelPersonas(DefaultTableModel modelPersonas) {
		this.modelPersonas = modelPersonas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public void setTablaPersonas(JTable tablaPersonas) {
		this.tablaPersonas = tablaPersonas;
	}

	public void llenarTabla(ArrayList<Persona> personasEnTabla) {
		this.modelPersonas.setRowCount(0); //Para vaciar la tabla
		this.modelPersonas.setColumnCount(0);
		this.modelPersonas.setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String DNI = p.getDNI();
			String nombre = p.getNombre();
			String Apellido = p.getApellido();
			Object[] fila = {DNI,nombre, Apellido};
			this.getModelPersonas().addRow(fila);
		}

		
	}

	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
