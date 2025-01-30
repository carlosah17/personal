package es.cie.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cie.ordenadores.Ordenador;
import es.cie.repositories.OrdenadorRepository;
import es.cie.repositories.jdbc.OrdenadorRepositoryJDBC;

@WebServlet("/OrdenadoresServlet")
public class OrdenadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OrdenadorRepository repo = new OrdenadorRepositoryJDBC();
	List<Ordenador> lista = null;
//el metodo que se ejecuta cuando pido el servlet

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("comando") == null) {

			if (request.getParameter("orden") != null) {

				lista = repo.buscarTodosOrdenados(request.getParameter("orden"));
			} else {

				// los datos de los socios
				lista = repo.buscarTodos();
			}

				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("listaordenadoresjdbc.jsp");
				despachador.forward(request, response);
			
		} else {

			String comando = request.getParameter("comando");
			if (comando.equals("formularioordenadores")) {
				RequestDispatcher despachador = 
						request.getRequestDispatcher("formularioordenadores.html");
				despachador.forward(request, response);
			} else if (comando.equals("salvarordenador")) {

				
				String dni = request.getParameter("marca");
				String precio = request.getParameter("precio");
				int preciobueno = Integer.parseInt(precio);
				Ordenador o = new Ordenador(dni, preciobueno);
				OrdenadorRepository repo = new OrdenadorRepositoryJDBC();
				repo.insertar(o);
				lista = repo.buscarTodos();
				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("listaordenadoresjdbc.jsp");
				despachador.forward(request, response);
				
			}else if(comando.equals("borrarordenador")) {
				
				System.out.println("borrar");
				String marca=request.getParameter("marca");
				Ordenador o=new Ordenador(marca);
				OrdenadorRepository repo= new OrdenadorRepositoryJDBC();
				repo.borrar(o);;
				lista=repo.buscarTodos();
				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("listaordenadoresjdbc.jsp");
				despachador.forward(request, response);
				
				
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
