package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;


public class PersonaDaoImpl implements PersonaDao
{
	private static final String insert = "INSERT INTO personas(DNI, nombre, Apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE DNI = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String update = "UPDATE bdPersonas.Personas SET Nombre = ? , Apellido = ? , DNI = ? where DNI  = ?";
	private static final String BuscoPersona = "SELECT * FROM personas where dni = ?";
		
	public boolean update(Persona persona_Vieja, Persona Persona_Nueva)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, Persona_Nueva.getNombre());
			statement.setString(2, Persona_Nueva.getApellido());
			statement.setString(3, Persona_Nueva.getDNI());
			statement.setString(4, persona_Vieja.getDNI());

			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isupdateExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isupdateExitoso;
	}
	public boolean insert(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDNI());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	public boolean delete(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, persona.getDNI());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	public boolean update(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setString(3, persona.getDNI());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isupdateExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isupdateExitoso;
	}
	public List<Persona> LeerPersonas()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String DNI = resultSet.getString("DNI");
		String nombre = resultSet.getString("Nombre");
		String Apellido = resultSet.getString("Apellido");
		return new Persona(DNI, nombre, Apellido);
	}
	
	@Override
	public List<Persona> Listar() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	@Override
	public Persona Busco_Persona(Persona Persona_A_Buscar) {
		
		Persona resultado = new Persona();
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(BuscoPersona);
			statement.setString(1, Persona_A_Buscar.getDNI());
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				resultado = getPersona(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultado;
	}
}
