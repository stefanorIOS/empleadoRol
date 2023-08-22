package Access;
import java.util.LinkedList;
import java.util.Scanner;

import Data.EmpleadoDAO;
import Data.RolDAO;
import Entities.Empleado;
//import entities.Persona;
import Entities.Rol;


public class Access {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Rol r = new Rol();
		/*
		System.out.println("Aquí verá una lista de los empleados y sus roles");
		
		LinkedList<Empleado> empleados = new LinkedList<Empleado>();
		
		EmpleadoDAO edao = new EmpleadoDAO();
		empleados = edao.getAll();
		
	
		for (Empleado e : empleados) {
			e.getInfo();
		}
		
		
		System.out.println("Ingrese una descripcion de ROL y le diremos su ID");
		String desc = scanner.nextLine();
		
		Rol r = new Rol();
		Rol gR = new Rol();
		RolDAO rdao = new RolDAO();
		r.setDescripcion(desc);
		
		gR = rdao.getRol(r);
		System.out.println("Este es su rol traido \n");
		System.out.println(" Descripcion: " + gR.getDescripcion() + " id " + gR.getId() );
		
		System.out.println("Ingrese nuevo ROL");
		Rol r = new Rol();
		System.out.println("Ingrese una descripcion de ROL");
		String desc = scanner.nextLine();
		System.out.println("Ingrese un nuevo id");
		int id = Integer.parseInt(scanner.nextLine());
		r.setId(id);
		r.setDescripcion(desc);
		RolDAO rdao = new RolDAO();
		rdao.newRol(r);
		System.out.println("Mira en la db si se actualizó");
		*/
		
		System.out.println("Aquí verá una lista de los empleados y sus roles");
		LinkedList<Empleado> empleados = new LinkedList<Empleado>();
		EmpleadoDAO edao = new EmpleadoDAO();
		empleados = edao.getAll();
		for (Empleado e : empleados) {
			e.getInfo();
		}
		
		/*
		System.out.println("Ingrese un ID ROL para modificar");
		Rol r = new Rol();
		System.out.println("Ingrese una descripcion de ROL");
		String desc = scanner.nextLine();
		System.out.println("Ingrese un nuevo id");
		int id = Integer.parseInt(scanner.nextLine());
		*/
		
		/* no puedo elimar el rol por se clave foranea, si aun no lo tiene nadie, si me deja
		Rol r = new Rol();
		System.out.println("Ingrese un nombre de rol para borrar");
		String desc = scanner.nextLine();
		r.setDescripcion(desc);
		RolDAO rdao = new RolDAO();
		rdao.deleteRol(r);
		System.out.println("Mire si el rol fue eliminado");
		*/
		
		//ahora voy a crear un empelado y obtener un documento para borrar la clave foranea
		
		Empleado empleado = new Empleado();
		empleado.setDni("42033727");
		RolDAO rdao = new RolDAO();
		rdao.deleteRolEmpleado(empleado);
		System.out.println("Deberia borrar de empleado_rol donde tiene mi dni");
		//perfecto
		
		
		
		
		
		
		
		
		
	}

}
