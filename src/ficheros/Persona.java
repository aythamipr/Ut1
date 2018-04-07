package ficheros;

import ficheros.Direccion;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private String apellidos;
	private int dni;
	private int edad;
	private Direccion direccion;
	
	//Constructor
	
	public Persona(String nombre, String apellidos, int dni, int edad, String calle, int numero, int cp, String provincia) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.direccion = new Direccion(calle, numero, cp, provincia);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	
	public String toString() {
		return "Nombre: " + nombre + "\nApellidos: " + apellidos + "\nDNI: " + dni + "\nEdad: " + edad + getDireccion() + "\n";
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public int compareTo(Persona s) {
		return (this.nombre).compareTo(s.getNombre());
	}
	
}
