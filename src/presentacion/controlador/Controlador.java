package presentacion.controlador;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelListarPersonas;
import presentacion.vista.PanelModificarPersonas;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.PanelAgregarPersonas;

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlIngresoPersonas;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PanelModificarPersonas pnlModificarPersonas;
	private PanelListarPersonas pnlListarPersonas;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;

	// Constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
		// Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;

		// Instancio los paneles
		this.pnlIngresoPersonas = new PanelAgregarPersonas();
		this.pnlEliminarPersonas = new PanelEliminarPersonas();
		this.pnlModificarPersonas = new PanelModificarPersonas();
		this.pnlListarPersonas = new PanelListarPersonas();

		// Enlazo todos los eventos

		// Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a -> EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a -> EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMntmListar().addActionListener(a -> EventoClickMenu_AbrirPanel_ListarPersona(a));

		// Eventos PanelAgregarPersonas
		this.pnlIngresoPersonas.getBtnAgregar()
				.addActionListener(a -> EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));

		// Evento PanelIliminarPersonas boton eliminar
		this.pnlEliminarPersonas.getBtnEliminar()
				.addActionListener(a -> EventoClickBoton_EliminarPersona_PanelEliminarPersona(a));

		// Eventos PanelModificarPersonas

		this.pnlModificarPersonas.getListaPersonas().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnlModificarPersonas.getTxtApellido()
						.setText((pnlModificarPersonas.getListaPersonas().getSelectedValue().getApellido()));
				pnlModificarPersonas.getTxtNombre()
						.setText((pnlModificarPersonas.getListaPersonas().getSelectedValue().getNombre()));
				pnlModificarPersonas.getTxtDni()
						.setText((pnlModificarPersonas.getListaPersonas().getSelectedValue().getDNI()));
			}

		});

		this.pnlModificarPersonas.getBtnModificar()
				.addActionListener(a -> EventoClickBoton_Modifi_PanelModificarPersona(a));
	}

	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		refrescarTablaModificar();
	}

	public void EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		refrescarTablaListar();

	}

	private void refrescarTablaListar() {
		this.personasEnTabla = (ArrayList<Persona>) pNeg.Listar();
		this.pnlListarPersonas.llenarTabla(this.personasEnTabla);
	}

	private void refrescarTablaModificar() {
		ArrayList<Persona> arrayPer = new ArrayList<Persona>();
		arrayPer = (ArrayList<Persona>) pNeg.Listar();

		this.pnlModificarPersonas.getModelPersonas().clear();

		for (int i = 0; i < arrayPer.size(); i++) {
			this.pnlModificarPersonas.getModelPersonas().addElement(arrayPer.get(i));

		}
		this.pnlModificarPersonas.llenarTabla(this.pnlModificarPersonas.getModelPersonas());

	}

	private void EventoClickBoton_Modifi_PanelModificarPersona(ActionEvent a) {
		String mensaje;
		Persona persona_Vieja = new Persona();
		Persona persona_nueva = new Persona();

		if (!this.pnlModificarPersonas.getListaPersonas().isSelectionEmpty()) {
			if (!this.pnlModificarPersonas.getTxtApellido().getText().isEmpty()
					&& !this.pnlModificarPersonas.getTxtNombre().getText().isEmpty()
					&& !this.pnlModificarPersonas.getTxtDni().getText().isEmpty()) {

				persona_Vieja.setApellido(pnlModificarPersonas.getListaPersonas().getSelectedValue().getApellido());
				persona_Vieja.setNombre(pnlModificarPersonas.getListaPersonas().getSelectedValue().getNombre());
				persona_Vieja.setDNI(pnlModificarPersonas.getListaPersonas().getSelectedValue().getDNI());

				String nombre = this.pnlModificarPersonas.getTxtNombre().getText();
				String Apellido = this.pnlModificarPersonas.getTxtApellido().getText();
				String DNI = this.pnlModificarPersonas.getTxtDni().getText();

				persona_nueva.setNombre(nombre);
				persona_nueva.setApellido(Apellido);
				persona_nueva.setDNI(DNI);
				boolean estado = pNeg.Modificar(persona_Vieja, persona_nueva);

				if (estado) {
					mensaje = "Se modifico correctamente la persona";
					this.pnlModificarPersonas.mostrarMensaje(mensaje);
					limpiarTablaModificar();
					refrescarTablaModificar();
					limpiar();

				} else {
					mensaje = "Error al modificar la persona";
					this.pnlModificarPersonas.mostrarMensaje(mensaje);
				}
			} else {
				mensaje = "Debe completar todos los campos";
				this.pnlModificarPersonas.mostrarMensaje(mensaje);
			}
		} else {
			mensaje = "Antes debe seleccionar una persona de la lista";
			this.pnlModificarPersonas.mostrarMensaje(mensaje);
			limpiar();
		}
	}

	private void limpiarTablaModificar() {
		ArrayList<Persona> arrayPer = new ArrayList<Persona>();
		arrayPer = (ArrayList<Persona>) pNeg.Listar();

		for (int i = 0; i < arrayPer.size(); i++) {

			this.pnlModificarPersonas.getModelPersonas().clear();

		}
	}

	public void limpiar() {
		pnlModificarPersonas.getTxtApellido().setText(null);
		pnlModificarPersonas.getTxtNombre().setText(null);
		pnlModificarPersonas.getTxtDni().setText(null);
	}

	private void EventoClickBoton_EliminarPersona_PanelEliminarPersona(ActionEvent a) {

		String mensaje;

		if (!this.pnlEliminarPersonas.getListaPersonas().isSelectionEmpty()) {
			Persona persona = new Persona();
			persona = (Persona) this.pnlEliminarPersonas.getListaPersonas().getSelectedValue();

			boolean estado = pNeg.Eliminar(persona);
			if (estado) {
				mensaje = "Se elimino correctamente la persona";
				this.pnlIngresoPersonas.mostrarMensaje(mensaje);
				refrescarTabla();
			} else {
				mensaje = "error al eliminar la persona";
				this.pnlIngresoPersonas.mostrarMensaje(mensaje);
			}
		} else {
			mensaje = "Antes debe seleccionar una persona";
			this.pnlIngresoPersonas.mostrarMensaje(mensaje);
		}

	}

	// EventoClickMenu abrir PanelAgregarPersonas
	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	// EventoClickMenu abrir PanelEliminarPersonas
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		refrescarTabla();
	}

	// EventoClickBoton agregar persona en PanelAgregarPersonas
	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		
		String mensaje;
		
	
		Persona personabuscada = new Persona();
		Persona personaencontrada = new Persona();
		personabuscada.setDNI(this.pnlIngresoPersonas.getTxtDNI().getText());
		personaencontrada = pNeg.Buscar_Persona(personabuscada);

		if (personaencontrada.getDNI() == null )
		{
			if (!this.pnlIngresoPersonas.getTxtApellido().getText().isEmpty()
					&& !this.pnlIngresoPersonas.getTxtNombre().getText().isEmpty()
					&& !this.pnlIngresoPersonas.getTxtDNI().getText().isEmpty()) {
				String nombre = this.pnlIngresoPersonas.getTxtNombre().getText();
				String Apellido = this.pnlIngresoPersonas.getTxtApellido().getText();
				String DNI = this.pnlIngresoPersonas.getTxtDNI().getText();
				Persona nuevaPersona = new Persona(DNI, nombre, Apellido);

				boolean estado = pNeg.insert(nuevaPersona);
				if (estado == true) {
					mensaje = "Persona agregada con exito";
					this.pnlIngresoPersonas.getTxtNombre().setText("");
					this.pnlIngresoPersonas.getTxtApellido().setText("");
					this.pnlIngresoPersonas.getTxtDNI().setText("");
				} else
					mensaje = "Persona no agregada, complete todos los campos";

				this.pnlIngresoPersonas.mostrarMensaje(mensaje);
			} else {
				mensaje = "Por favor complete todos los campos";
				this.pnlIngresoPersonas.mostrarMensaje(mensaje);
			}
		}
		else 
		{
			mensaje = "El DNI ingresado ya se encuentra dado de alta";
			this.pnlIngresoPersonas.mostrarMensaje(mensaje);
		}

	}

	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);
		;
	}

	private void refrescarTabla() {
		ArrayList<Persona> arrayPer = new ArrayList<Persona>();
		arrayPer = (ArrayList<Persona>) pNeg.Listar();

		this.pnlEliminarPersonas.getModelPersonas().removeAllElements();

		for (int i = 0; i < arrayPer.size(); i++) {

			this.pnlEliminarPersonas.getModelPersonas().addElement(arrayPer.get(i));

		}

		this.pnlEliminarPersonas.llenarTabla(this.pnlEliminarPersonas.getModelPersonas());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
