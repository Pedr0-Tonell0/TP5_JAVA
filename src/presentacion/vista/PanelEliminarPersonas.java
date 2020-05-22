package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class PanelEliminarPersonas extends JPanel {
	
	private JLabel lblEliminar;
	private JButton btnEliminar;
	private DefaultListModel<Persona> modelPersonas;
	private String[] nombreColumnas = {"DNI","Nombre","Apeliido"};
	private JList<Persona> listaPersonas;
	
	public JList getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(JList listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public DefaultListModel<Persona> getModelPersonas() 
	{
		return modelPersonas;
	}

	public void setModelPersonas(DefaultListModel<Persona> modelPersonas) {
		this.modelPersonas = modelPersonas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public PanelEliminarPersonas() {
		setLayout(null);
		
		lblEliminar = new JLabel("Eliminar usuario");
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEliminar.setBounds(149, 37, 127, 16);
		add(lblEliminar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(149, 223, 97, 25);
		add(btnEliminar);
		
		listaPersonas = new JList();
		listaPersonas.setBounds(60, 68, 317, 141);
		add(listaPersonas);
		
		modelPersonas = new DefaultListModel<Persona>();
		
				
		
	}
	

	public JLabel getLblEliminar() {
		return lblEliminar;
	}
	public void setLblEliminar(JLabel lblEliminar) {
		this.lblEliminar = lblEliminar;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public void llenarTabla(DefaultListModel<Persona> personasEnTabla) {
		/*this.modelPersonas.setRowCount(0); //Para vaciar la tabla
		this.modelPersonas.setColumnCount(0);
		this.modelPersonas.setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String DNI = p.getDNI();
			String nombre = p.getNombre();
			String Apellido = p.getApellido();
			Object[] fila = {DNI,nombre, Apellido};
			this.getModelPersonas().addRow(fila);
		}*/
		this.listaPersonas.removeAll();
		
		listaPersonas.setModel(personasEnTabla);
	}

	
}
