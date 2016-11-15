package it.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;
import it.alfasoft.bean.UtenteHelp;
import it.alfasoft.service.Servizi;

//Init the DB for AJAX query

@WebServlet(urlPatterns = {"/richiestaAiuto"})
public class RichiestaAiutoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Servizi service = new Servizi();
		PrintWriter out = response.getWriter();
		JsonObject jobj = new JsonObject();
		
		UtenteHelp u = new UtenteHelp();
		u.setNome(request.getParameter("nome"));
		u.setCognome(request.getParameter("cognome"));
		u.setEmail(request.getParameter("email"));
		u.setProblema(request.getParameter("problema"));
		u.setMessaggio(request.getParameter("messaggio"));
		u.setProvenienzaHelp(request.getParameter("from"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(new Date());
		u.setDataInserimento(date);
		
		if (service.addHelp(u)) {
			
			jobj.addProperty("success", true);
			
		} else {

			jobj.addProperty("success", false);
		}
		out.println(jobj.toString());
		out.close();
	}
}
