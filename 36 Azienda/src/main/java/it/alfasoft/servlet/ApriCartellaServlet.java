package it.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import it.alfasoft.bean.Cartella;
import it.alfasoft.bean.CartellaJSON;

@WebServlet(urlPatterns = {"/dipendente/apriCartella", "/cliente/apriCartella"})
public class ApriCartellaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		JsonArray jArray = new JsonArray();
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		TreeMap<String, Cartella> cartelle = (TreeMap<String, Cartella>) session.getAttribute("listaCartelle");
		
		//Chiave della cartella a cui voglio accedere
		String key = request.getParameter("key");
		
		//Cartella che diventer� il nuovo padre
		Cartella destFolder = cartelle.get(key);
		
		if (destFolder != null){
			
			//Inserisco l'id del nuovo padre
			jArray.add(destFolder.getId());
			
			//Ritorno un lista json array di figli del nuovo padre
			for (Cartella c : destFolder.getFigli()){
				
				CartellaJSON temp = new CartellaJSON();
				temp.setNome(c.getNome());
				JsonElement jsel = gson.toJsonTree(temp);
				jArray.add(gson.toJsonTree(jsel));
			}
			
		}
		System.out.println(jArray.toString());
		out.println(jArray.toString());
		out.close();	
		
	}
}
