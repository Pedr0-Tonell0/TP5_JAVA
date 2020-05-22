package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entidad.Persona;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelModificarPersonas extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JScrollPane scrollPane;
	private JList<Persona> listaPersonas;
	private DefaultListModel<Persona> modelPersonas;
	private JButton btnModificar;
	

	public PanelModificarPersonas() {
		this.setBounds(100, 100, 424, 292);
		this.setLayout(null);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(307, 218, 89, 23);
		add(btnModificar);

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

		txtNombre.setBounds(23, 219, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

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
		txtApellido.setBounds(115, 219, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				// Verificar si la tecla pulsada no es un digito
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume(); // ignorar el evento de teclado
				}
			}
		});
		txtDni.setBounds(211, 219, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);

	

		JLabel lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea modificar:");
		lblSeleccioneLaPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccioneLaPersona.setBounds(23, 11, 393, 14);
		add(lblSeleccioneLaPersona);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		listaPersonas = new JList<Persona>();
		listaPersonas.setBounds(60, 68, 317, 141);
		add(listaPersonas);
		
		modelPersonas = new DefaultListModel<Persona>();

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


	public JTextField getTxtDni() {
		return txtDni;
	}


	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	public JList<Persona> getListaPersonas() {
		return listaPersonas;
	}


	public void setListaPersonas(JList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}


	public DefaultListModel<Persona> getModelPersonas() {
		return modelPersonas;
	}


	public void setModelPersonas(DefaultListModel<Persona> modelPersonas) {
		this.modelPersonas = modelPersonas;
	}


	public JButton getBtnModificar() {
		return btnModificar;
	}


	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}


	public void llenarTabla(DefaultListModel<Persona> personasEnTabla) {
	
		this.listaPersonas.removeAll();
		
		listaPersonas.setModel(personasEnTabla);
		listaPersonas.updateUI();

	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
