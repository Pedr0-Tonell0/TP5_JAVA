package entidad;

public class Persona 
{
	@Override
	public String toString() {
		return  DNI + " " + nombre + " " + Apellido ;
	}


	private String DNI;
	private String nombre;
	private String Apellido;

	public Persona()
	{
		
	}
			
	public Persona(String DNI, String nombre, String Apellido)
	{
		this.DNI = DNI;
		this.nombre = nombre;
		this.Apellido = Apellido;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	
}
