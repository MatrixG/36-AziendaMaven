package it.alfasoft.service;

import java.util.List;

import it.alfasoft.bean.Cartella;
import it.alfasoft.bean.Utente;
import it.alfasoft.dao.CartelleDAO;

public class ServiziCartelle {

	private CartelleDAO cDAO = new CartelleDAO();
	
	public List<Cartella> getCartelle(int userId) {
		
		return cDAO.getRootId(userId);
	}

	public List<Cartella> aggiungiRoot(int userId) {
		
		Servizi serv = new Servizi();
		Utente u = serv.getUtenteFromId(userId);
		Cartella cartella = new Cartella();
		cartella.setNome("root");
		cartella.setPadre(cartella);
		cartella.setIdProprietario(u);
		if (cDAO.aggiungiCartella(cartella)){
			return cDAO.getRootId(userId);
		}
		return null;
	}

}
