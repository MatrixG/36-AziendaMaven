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
import it.alfasoft.bean.Cartella;
import it.alfasoft.bean.CartellaJSON;
import it.alfasoft.service.ServiziCartelle;

@WebServlet(urlPatterns = { "/dipendente/creaCartella", "/cliente/creaCartella" })
public class CreaCartellaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ServiziCartelle service = new ServiziCartelle();
		PrintWriter out = response.getWriter();
		JsonArray jArray = new JsonArray();
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		TreeMap<String, Cartella> cartelle = (TreeMap<String, Cartella>) session.getAttribute("listaCartelle");

		// Leggo i parametri in request
		String cartellaAperta = request.getParameter("key");
		String newName = request.getParameter("newName");
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		//Controllo che la cartella aperta non sia il root
		if (cartelle.get(cartellaAperta).getNome().equals("root")){
			
			jArray.add("Non e' possibile aggiungere al di fuori di root!");
			out.println(jArray.toString());
			out.close();
			return;
		}

		//Controllo che la cartella non esista già
		for (Cartella c : cartelle.get(cartellaAperta).getFigli()){
			if (c.getNome().compareToIgnoreCase(newName) == 0){
				
				jArray.add("La cartella esiste gia'!");
				out.println(jArray.toString());
				out.close();
				return;
			}
		}
		
		// Creo un nuova cartella e la riempo
		Cartella nuova = new Cartella();
		nuova.setNome(newName);
		nuova.setIdProprietario(cartelle.get(cartellaAperta).getIdProprietario());
		nuova.setPadre(cartelle.get(cartellaAperta));

		// Aggiungo la cartella al padre
		cartelle.get(cartellaAperta).getFigli().add(nuova);

		// Aggiorno il database. Passo la cartella nuova e la cartella del padre
		// aggiornata
		if (service.aggiungiCartella(nuova, cartelle.get(cartellaAperta))) {

			// nuova mappa delle cartelle
			List<Cartella> nuovaLista = service.getCartelle(userId);
			if (cartelle != null && !cartelle.isEmpty()) {

				Map<String, Cartella> treeMapFolder = new TreeMap<String, Cartella>();
				for (Cartella c : nuovaLista) {
					treeMapFolder.put(c.getNome() + c.getPadre().getId(), c);
				}

				// Pulisco gli attributi della sessione
				session.removeAttribute("listaCartelle");
				session.setAttribute("listaCartelle", treeMapFolder);
				
				//Aggiungo un ok per la creazione come messaggio di ritorno
				jArray.add("ok");

				// Inserisco le nuova lista di cartelle nella risposta
				for (Cartella c : treeMapFolder.get(cartellaAperta).getFigli()) {

					CartellaJSON temp = new CartellaJSON();
					temp.setNome(c.getNome());
					JsonElement jsel = gson.toJsonTree(temp);
					jArray.add(gson.toJsonTree(jsel));
				}
			}
		}

		System.out.println(jArray.toString());
		out.println(jArray.toString());
		out.close();
	}
}
