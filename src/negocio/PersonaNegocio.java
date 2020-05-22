package negocio;

import java.util.ArrayList;
import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {

	public boolean insert(Persona persona);
	public List listarPersonas();
	public List<Persona> Listar();
	public boolean Eliminar(Persona persona);
	public boolean Modificar(Persona persona, Persona persona_nueva);
	public Persona Buscar_Persona (Persona persona);
}
