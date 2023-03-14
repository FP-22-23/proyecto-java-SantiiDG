package fp.common;

public record Victima(String nombre, String apellidos, String profesion) {
	
	public Victima(String nombre, String apellidos, String profesion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.profesion = profesion;
		
	}
	
	

}
