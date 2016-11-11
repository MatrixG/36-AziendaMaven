package it.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import it.alfasoft.bean.Voce;
import it.alfasoft.service.ServiziRubrica;

//Init the DB for AJAX query

@WebServlet(urlPatterns = {"/dipendente/initCercaVoce", "/cliente/initCercaVoce"})
public class InitCercaVoceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ServiziRubrica service = new ServiziRubrica();
		int id = Integer.parseInt(request.getParameter("set"));
		PrintWriter out = response.getWriter();
		JsonObject jobj = new JsonObject();
		List<Voce> contatti = service.getVoci(id);
		
		
		if (contatti != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("listaVoci", contatti);
			
			jobj.addProperty("success", true);
			
		} else {

			jobj.addProperty("success", false);
		}
		out.println(jobj.toString());
		out.close();
	}
}
