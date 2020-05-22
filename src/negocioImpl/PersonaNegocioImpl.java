package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public List<Persona> listarPersonas() {

		return pdao.Listar();
		
	}

	@Override
	public List<Persona> Listar() {
		
		return pdao.Listar();
	}

	@Override
	public boolean Eliminar(Persona persona) {
		return pdao.delete(persona);
	}
	
	@Override
	public boolean Modificar(Persona persona_vieja, Persona persona_nueva) {
		return pdao.update(persona_vieja,persona_nueva);
	}

	@Override
	public Persona Buscar_Persona(Persona persona) {
		
		return pdao.Busco_Persona(persona);
	}

}
