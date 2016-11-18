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

import it.alfasoft.bean.Cartella;
import it.alfasoft.service.ServiziCartelle;

@WebServlet(urlPatterns = {"/dipendente/creaCartella", "/cliente/creaCartella"})
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
		
		//Leggo i parametri in request
		String key = request.getParameter("key");
		String newName = request.getParameter("name");
		
		//Creo un nuova cartella e la riempo
		Cartella nuova = new Cartella();
		nuova.setNome(newName);
		nuova.setIdProprietario(cartelle.get(key).getIdProprietario());
		nuova.setPadre(cartelle.get(key));
		
		//Aggiungo la cartella alla lista dei figli del padre
		cartelle.get(key).getFigli().add(nuova);
		
		//Aggiorno la mappa nella sessione
		session.setAttribute("listaCartelle", cartelle);
		
		//Aggiorno il database. Passo la cartella nuova e la cartella del padre aggiornata
		service.aggiungiCartella(nuova, cartelle.get(key));
		
		
		System.out.println(jArray.toString());
		out.println(jArray.toString());
		out.close();	
	}
}
