package it.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import it.alfasoft.bean.Voce;
import it.alfasoft.bean.VoceJSON;

//This Servlet Search a Contact from the database

@WebServlet(urlPatterns = { "/dipendente/cercaVoce" })
public class CercaVoceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String ricerca = request.getParameter("testo");
		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();

		if (!ricerca.isEmpty()) {

			HttpSession sessione = request.getSession();
			List<Voce> contatti = (List<Voce>) sessione.getAttribute("listaVoci");

			VoceJSON voce = new VoceJSON();
			List<Voce> vociMatching = cercaCorrispondenze(ricerca, contatti);
			for (Voce v : vociMatching) {

				voce.setCognome(v.getCognome());
				voce.setNome(v.getNome());
				voce.setTelefono(v.getTelefono());

				JsonElement voceJson = gson.toJsonTree(voce);
				jArray.add(voceJson);
			}
		}
		System.out.println(jArray.toString());
		out.println(jArray.toString());
		out.close();
	}


	public List<Voce> cercaCorrispondenze(String ricerca, List<Voce> contatti) {
		
		Map<String, Voce> out = new TreeMap<String, Voce>();
		
		for (Voce v : contatti){
			//System.out.println(v.getCognome() + v.getNome() + v.getTelefono());
			if (v.getNome().toLowerCase().contains(ricerca) || v.getCognome().toLowerCase().contains(ricerca) ||
				v.getTelefono().toLowerCase().contains(ricerca)) {
				out.put(v.getCognome(), v);
			}
		}
		return new ArrayList<Voce>(out.values());
	}

}
