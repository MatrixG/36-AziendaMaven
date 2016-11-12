package it.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.JsonObject;

//Init the DB for AJAX query

@WebServlet(urlPatterns = {"/richiestaAiuto"})
public class RichiestaAiutoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//		ServiziRubrica service = new ServiziRubrica();
//		int id = Integer.parseInt(request.getParameter("set"));
		PrintWriter out = response.getWriter();
		JsonObject jobj = new JsonObject();
//		List<Voce> contatti = service.getVoci(id);
		
		jobj.addProperty("success", false);
//		if (contatti != null) {
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("listaVoci", contatti);
//			
//			jobj.addProperty("success", true);
//			
//		} else {
//
//			jobj.addProperty("success", false);
//		}
		out.println(jobj.toString());
		out.close();
	}
}
