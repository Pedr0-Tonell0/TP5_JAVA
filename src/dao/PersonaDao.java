package dao;

import java.util.List;

import entidad.Persona;


public interface PersonaDao 
{
	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public List<Persona> LeerPersonas();
	public List<Persona> Listar();
	public boolean update(Persona persona_Vieja, Persona persona_nueva);
	public Persona Busco_Persona(Persona Persona_A_Buscar);
}
