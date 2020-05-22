package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnPersonas;
	private JMenuItem menuEliminar;
	private JMenuItem menuAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 330);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersonas = new JMenu("Persona");
		menuBar.add(mnPersonas);
		
		menuAgregar = new JMenuItem("Agregar");
		mnPersonas.add(menuAgregar);
		
		mntmModificar = new JMenuItem("Modificar");
		mnPersonas.add(mntmModificar);
		
		menuEliminar = new JMenuItem("Eliminar");
		mnPersonas.add(menuEliminar);
		
		mntmListar = new JMenuItem("Listar");
		mnPersonas.add(mntmListar);
	}


	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMnPersonas() {
		return mnPersonas;
	}

	public void setMnPersonas(JMenu mnPersonas) {
		this.mnPersonas = mnPersonas;
	}

	public JMenuItem getMenuEliminar() {
		return menuEliminar;
	}

	public void setMenuEliminar(JMenuItem menuEliminar) {
		this.menuEliminar = menuEliminar;
	}

	public JMenuItem getMenuAgregar() {
		return menuAgregar;
	}

	public void setMenuAgregar(JMenuItem menuAgregar) {
		this.menuAgregar = menuAgregar;
	}

	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}

	public void setMntmModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}

	public JMenuItem getMntmListar() {
		return mntmListar;
	}

	public void setMntmListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}

	
	
}
