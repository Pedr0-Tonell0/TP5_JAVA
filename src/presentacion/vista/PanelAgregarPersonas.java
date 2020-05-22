package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import daoImpl.Conexion;
import entidad.Persona;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelAgregarPersonas extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnAgregar;
	private JTextField txtDNI;
	
	 public PanelAgregarPersonas() {
	
		super();
		initialize();
	}
	
	private void initialize() 
	{
	
		this.setBounds(100, 100, 459, 235);
		this.setLayout(null);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(59, 110, 113, 14);
		add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(59, 72, 89, 14);
		add(lblNombre);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(59, 189, 138, 23);
		add(btnAgregar);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();

				if (Character.isDigit(car)) {
					getToolkit().beep();

					evt.consume();

				}

			}
		});
		txtApellido.setBounds(197, 107, 164, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();

				if (Character.isDigit(car)) {
					getToolkit().beep();

					evt.consume();

				}

			}
		});
		txtNombre.setBounds(197, 69, 164, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(59, 148, 113, 14);
		add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char caracter = evt.getKeyChar();

				// Verificar si la tecla pulsada no es un digito
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					evt.consume(); // ignorar el evento de teclado
				}

				}

		});
		
		
		txtDNI.setColumns(10);
		txtDNI.setBounds(197, 142, 164, 20);
		add(txtDNI);
	}
	
	public void show()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}

	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

	
}
