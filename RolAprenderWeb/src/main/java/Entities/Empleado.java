package Entities;

import java.util.LinkedList;

public class Empleado {
	String dni;
	String nombre;
	String apellido;
	LinkedList<Rol>roles = new LinkedList<Rol>(); 
	
	public void addRol(Rol r) {
		roles.add(r);
	}
	
	
	
	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public Empleado() {
		
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Empleado(String dni, String nombre, LinkedList<Rol> roles) {
		this.dni = dni;
		this.nombre = nombre;
		this.roles = roles;
		
	}
	
	public void getInfo() {
		System.out.println("Nombre: " + this.nombre + " dni " + this.dni );
		this.getInfoRoles();
	}
	
	public void getInfoRoles() {
		for (Rol r : roles) {
			System.out.println("rol adquerido " + r.getDescripcion());
		}
	}
	
}
