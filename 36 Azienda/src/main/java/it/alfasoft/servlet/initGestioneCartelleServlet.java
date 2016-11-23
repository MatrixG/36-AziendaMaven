package it.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import it.alfasoft.bean.Cartella;
import it.alfasoft.bean.CartellaJSON;
import it.alfasoft.service.ServiziCartelle;

@WebServlet(urlPatterns = {"/dipendente/initGestioneCartelle", "/cliente/initGestioneCartelle"})
public class initGestioneCartelleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		ServiziCartelle service = new ServiziCartelle();
		int userId = Integer.parseInt(request.getParameter("set"));
		PrintWriter out = response.getWriter();
		JsonObject jobj = new JsonObject();
		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();
		
		Cartella root = service.getRootFolder(userId);
		if (root == null){
			
			root = service.aggiungiRoot(userId);
			
		}
		
		List <Cartella> cartelle = service.getCartelle(userId);
		if (cartelle != null && !cartelle.isEmpty()) {
			
			Map<String, Cartella> treeMapFolder = new TreeMap<String, Cartella>();
			for (Cartella c : cartelle){
				treeMapFolder.put(c.getNome()+c.getPadre().getId(), c);

			}
			
			HttpSession session = request.getSession();
			session.setAttribute("listaCartelle", treeMapFolder);
			
			jobj.addProperty("parentKey", root.getNome() + root.getId());
			jobj.addProperty("parentId", root.getId());
			jobj.addProperty("success", true);
			jArray.add(jobj);
			for (Cartella c : root.getFigli()){
			
				CartellaJSON temp = new CartellaJSON();
				temp.setNome(c.getNome());
				JsonElement jsel = gson.toJsonTree(temp);
				jArray.add(gson.toJsonTree(jsel));
				
			}
			
		} else {

			jobj.addProperty("success", false);
		}
		System.out.println(jArray.toString());
		out.println(jArray.toString());
		out.close();
	}
	
	
}
