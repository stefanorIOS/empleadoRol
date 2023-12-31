package Session;

import java.io.PrintStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.Empleado;

/**
 * Servlet implementation class validarServlet
 */
@WebServlet("/menuServlet")
public class menuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recuperamos la session de nuevo
		HttpSession session = request.getSession(); 
		//recuperamos el objeto enviado en el "validarSesion" (servlet)
		Empleado usuario = (Empleado) session.getAttribute("usuario");
		
		if (usuario == null) {
			request.getRequestDispatcher("noFound.html").forward(request, response);
		}
		else {
			
			//aqui enviamos el usuario al jsp como atributo
			request.setAttribute("usuario", usuario);
			//aqui trataremos de enviar la sesion para obtener el atributo
			session.setAttribute("usuario", usuario);
			request.getRequestDispatcher("WEB-INF/infoUser.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
