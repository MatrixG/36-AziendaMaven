package it.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;
import it.alfasoft.service.Servizi;

@WebServlet("/admin/cancellaCliente")
public class CancellaClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Servizi service = new Servizi();
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();
		JsonObject jobj = new JsonObject();

		if (email != null && service.cancellaUtente(email)) {

			jobj.addProperty("success", true);
		} else {

			jobj.addProperty("success", false);
		}
		out.println(jobj.toString());
		out.close();
	}

}
