package it.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;
import it.alfasoft.bean.Cliente;
import it.alfasoft.service.Servizi;
import it.alfasoft.utils.CheckValues;

/**
 * Servlet implementation class ModificaClienteServlet
 */
@WebServlet("/admin/modificaCliente")
public class ModificaClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Servizi service = new Servizi();
		Cliente c = new Cliente();

		c.setNome(request.getParameter("nome"));
		c.setCognome(request.getParameter("cognome"));
		c.setpIva(request.getParameter("pIva"));
		c.setRagSociale(request.getParameter("ragioneSociale"));
		c.setUsername(request.getParameter("email"));
				
		PrintWriter out = response.getWriter();
		JsonObject jobj = new JsonObject();
		String userVecchia = request.getParameter("emailUser");
		if (isValid(c) && service.modificaUtente((Object) c, 2, userVecchia)) {

			jobj.addProperty("success", true);
		} else {

			jobj.addProperty("success", false);
		}
		out.println(jobj.toString());
		out.close();
	}

	private boolean isValid(Cliente c) {

		if (CheckValues.checkString(c.getNome()) && CheckValues.checkString(c.getCognome())
				&& CheckValues.checkString(c.getpIva()) && CheckValues.checkString(c.getUsername())
				&& CheckValues.checkString(c.getRagSociale()))
			return true;

		return false;

	}

}
