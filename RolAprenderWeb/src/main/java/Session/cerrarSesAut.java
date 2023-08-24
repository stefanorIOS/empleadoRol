package Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.Empleado;

/**
 * Servlet implementation class cerrarSesAut
 */
@WebServlet("/cerrarSesAut")
public class cerrarSesAut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cerrarSesAut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("usuario");
		
		
		// si hago esto me deja ir correctamente, pq la session sigue abierta y sigo pasando datos ...
		//Empleado usuario = (Empleado) session.getAttribute("usuario");
		//session.setAttribute("usuario", usuario);
		//request.getRequestDispatcher("WEB-INF/infoUser.jsp").forward(request, response);
		
		
		//con el flujo de datos normal, tengo q ir acá, pues si voy al jsp, y trato de recurar la sesion ya no existe.
		request.getRequestDispatcher("despedida.html").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
