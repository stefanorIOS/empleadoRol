package Data;
import java.sql.*;
import java.util.LinkedList;

import Entities.Empleado;
//import entities.Empleado;
import Entities.Rol;
import Data.DbConnector;
import Entities.Empleado;

public class RolDAO {

	public LinkedList<Rol> getAll(){
		
		Statement st = null;
		ResultSet rs = null;
		
		LinkedList<Rol> roles = new LinkedList<Rol>();
		
		try {
			st = DbConnector.getInstancia().getConn().createStatement();
			rs = st.executeQuery("SELECT * FROM Rol");
			
			if (rs != null) {
				while (rs.next()) {
					Rol r = new Rol();
					r.setId(rs.getInt("id_rol"));
					r.setDescripcion(rs.getString("descripcion"));
					roles.add(r);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return roles;
		
	}
	
public void setRoles(Empleado p) {
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement
			("select * from rol r inner join empleado_rol er on r.id_rol = er.id_rol where dni_empleado = ?");
			stmt.setString(1, p.getDni());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Rol r=new Rol();
					r.setId(rs.getInt("id_rol"));
					r.setDescripcion(rs.getString("descripcion"));
					p.addRol(r);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}