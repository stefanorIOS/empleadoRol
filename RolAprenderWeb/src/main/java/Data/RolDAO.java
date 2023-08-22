package Data;
import java.sql.*;
import java.util.LinkedList;

import Entities.Empleado;
//import entities.Empleado;
import Entities.Rol;


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
	
	public Rol getRol(Rol rol) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		Rol r = null;
		
		try {
			st = DbConnector.getInstancia().getConn().prepareStatement("Select * from Rol WHERE descripcion=?");
			st.setString(1, rol.getDescripcion());

			rs = st.executeQuery();

			if (rs != null & rs.next()) {
				
				r = new Rol();
				r.setId(rs.getInt("id_rol"));
				r.setDescripcion(rs.getString("descripcion"));
			}

		} catch (SQLException e) {
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

		return r;
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

public void newRol(Rol rol) {
	
	PreparedStatement st = null;
	
	try {
		st = DbConnector.getInstancia().getConn()
				.prepareStatement("INSERT INTO Rol (id_rol, descripcion) VALUES (?,?)");
		st.setString(2, rol.getDescripcion());
		st.setInt(1, rol.getId());
		st.executeUpdate();
		
	}  catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (st != null) {
				st.close();
			}
			DbConnector.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

public void updateRol(Rol rol) {
	PreparedStatement st = null;
	
	try {
		st =  DbConnector.getInstancia().getConn()
			.prepareStatement("UPDATE rol SET descripcion=? WHERE id_rol=?");
		 st.setString(1, rol.getDescripcion());
		 st.setInt(2, rol.getId());
		 
		 st.executeUpdate();
		
	}  catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (st != null) {
				st.close();
			}
			DbConnector.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

public void deleteRol(Rol rol) {
	
	PreparedStatement st = null;
	try {

		st = DbConnector.getInstancia().getConn().prepareStatement("DELETE from rol WHERE descripcion=?");
		st.setString(1, rol.getDescripcion());
		st.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (st != null) {
				st.close();
			}
			DbConnector.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

public void deleteRolEmpleado(Empleado emp) {
	
	PreparedStatement st = null;
	try {

		st = DbConnector.getInstancia().getConn().prepareStatement("DELETE from empleado_rol WHERE dni_empleado=?");
		st.setString(1, emp.getDni());
		st.executeUpdate();
		System.out.println("Se elimino la fk");

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (st != null) {
				st.close();
			}
			DbConnector.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}








	
	
}