package Access;
import java.util.LinkedList;

import Data.EmpleadoDAO;

import Entities.Empleado;
//import entities.Persona;


public class Access {

	public static void main(String[] args) {
		
		LinkedList<Empleado> empleados = new LinkedList<Empleado>();
		
		EmpleadoDAO edao = new EmpleadoDAO();
		empleados = edao.getAll();
		
	
		for (Empleado e : empleados) {
			e.getInfo();
		}
		
		
		
	}

}
