package Entities;

public class Rol {
	int id;
	String descripcion;
	
	public Rol() {
		
	}
	
	public Rol(int id, String desc) {
		this.id = id;
		this.descripcion = desc;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public void getInfo() {
		System.out.println("Informacion del rol: " + this.descripcion + "Este es su id "  +  this.id);
	}
	
	
}


