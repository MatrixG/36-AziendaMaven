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

import it.alfasoft.bean.Cartella;
import it.alfasoft.service.ServiziCartelle;

@WebServlet(urlPatterns = {"/dipendente/initGestioneCartelle", "/cliente/initGestioneCartelle"})
public class initGestioneCartelleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		ServiziCartelle service = new ServiziCartelle();
		int userId = Integer.parseInt(request.getParameter("set"));
		PrintWriter out = response.getWriter();
		JsonObject jobj = new JsonObject();
		
		List <Cartella> cartelle = service.getCartelle(userId);
		if (cartelle == null){
			
			cartelle = service.aggiungiRoot(userId);
		}
		
		
		if (cartelle != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("listaCartelle", cartelle);
			
			jobj.addProperty("success", true);
			
		} else {

			jobj.addProperty("success", false);
		}
		out.println(jobj.toString());
		out.close();
	}
	
	
}
