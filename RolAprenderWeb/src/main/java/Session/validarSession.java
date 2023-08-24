package Session;

import Entities.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.EmpleadoDAO;
import Entities.Empleado;

/**
 * Servlet implementation class validarSession
 */
@WebServlet("/validarSession")
public class validarSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validarSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recuperamos los datos ingresados en el formulario "index.2"
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		
		Empleado e = new Empleado();
		e.setDni(dni);
		e.setNombre(nombre);
		System.out.println(dni + nombre);	
		
		EmpleadoDAO edao = new EmpleadoDAO();
		Empleado emp = edao.login(e);
		
		
		
		// Si el empleado es encontrado, iniciamos objeto session yenviamos el atributo emp, con el 
		//nombre de usuario para el siguiente servlet
		if (emp != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", emp);
			//request.getSession().setAttribute("empleado", emp);
			//si pasa todo esto, nos vamos a menu servlet
			request.getRequestDispatcher("menuServlet").forward(request, response);
			
		} else {
			request.setAttribute("mensaje", "Las credenciales no coinciden con nuestros datos.");
			response.sendRedirect("noFound.html");
		//	request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}

		
	}

}
