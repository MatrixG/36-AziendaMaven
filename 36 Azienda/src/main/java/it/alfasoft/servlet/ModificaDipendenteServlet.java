package it.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;
import it.alfasoft.bean.Dipendente;
import it.alfasoft.service.Servizi;
import it.alfasoft.utils.CheckValues;

//This Servlet Modifies a User from the database

@WebServlet(urlPatterns = { "/admin/modificaDipendente" })
public class ModificaDipendenteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Servizi service = new Servizi();
		Dipendente d = new Dipendente();

		d.setNome(request.getParameter("nome"));
		d.setCognome(request.getParameter("cognome"));
		d.setStipendio(Integer.parseInt(request.getParameter("stipendio")));
		d.setPosizione(request.getParameter("posizione"));
		d.setUsername(request.getParameter("email"));
				
		PrintWriter out = response.getWriter();
		JsonObject jobj = new JsonObject();
		String userVecchia = request.getParameter("emailUser");
		if (isValid(d) && service.modificaUtente((Object) d, 1, userVecchia)) {

			jobj.addProperty("success", true);
		} else {

			jobj.addProperty("success", false);
		}
		out.println(jobj.toString());
		out.close();
	}

	private boolean isValid(Dipendente d) {

		if (CheckValues.checkString(d.getPosizione()) && CheckValues.checkString(d.getNome())
				&& CheckValues.checkString(d.getCognome()) && CheckValues.checkString(d.getUsername()))
			return true;

		return false;

	}

}