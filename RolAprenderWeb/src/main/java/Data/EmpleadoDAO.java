package Data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Entities.Empleado;

public class EmpleadoDAO {
	
	public LinkedList<Empleado> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Empleado> empleados = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT dni_empleado, nombre, apellido FROM Empleado ");
			RolDAO rdao = new RolDAO();
			
			if (rs != null) {
				while (rs.next()) {

					Empleado e = new Empleado();

					e.setDni(rs.getString("dni_empleado"));
					e.setNombre(rs.getString("nombre"));
					e.setApellido(rs.getString("apellido"));
					
					rdao.setRoles(e);
					
					empleados.add(e);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return empleados;

	}
	
	public Empleado login(Empleado emp) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Empleado e = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("Select dni_empleado,nombre, apellido from empleado WHERE dni_empleado=? and nombre=?");

			stmt.setString(1, emp.getDni());
			stmt.setString(2, emp.getNombre());

			rs = stmt.executeQuery();

			if (rs != null & rs.next()) {

				e = new Empleado();
				e.setDni(rs.getString("dni_empleado"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido(rs.getString("apellido"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return e;
	}
	
	
}