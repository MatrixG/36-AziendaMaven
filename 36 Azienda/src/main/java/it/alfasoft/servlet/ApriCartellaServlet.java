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
//		JsonObject jobj = new JsonObject();
		JsonArray jArray = new JsonArray();
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		TreeMap<String, Cartella> cartelle = (TreeMap<String, Cartella>) session.getAttribute("listaCartelle");
		String  parentId = request.getParameter("parentId");
		String folder = request.getParameter("folder");
		
		Cartella destFolder = cartelle.get(folder + parentId);
		
		if (destFolder != null){
			
//			jobj.addProperty("success", true);
//			jobj.addProperty("parentId", destFolder.getPadre().getId());
			jArray.add(destFolder.getPadre().getId());
			
			for (Cartella c : destFolder.getFigli()){
				
				CartellaJSON temp = new CartellaJSON();
				temp.setNome(c.getNome());
				JsonElement jsel = gson.toJsonTree(temp);
				jArray.add(gson.toJsonTree(jsel));
				
			}
			
		} else {

//			jobj.addProperty("success", false);
		}
		System.out.println(jArray.toString());
		out.println(jArray.toString());
		out.close();	
		
	}
}
