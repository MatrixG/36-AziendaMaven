package it.alfasoft.service;

import java.util.List;

import it.alfasoft.bean.Cartella;
import it.alfasoft.bean.Utente;
import it.alfasoft.dao.CartelleDAO;

public class ServiziCartelle {

	private CartelleDAO cDAO = new CartelleDAO();
	
	public List<Cartella> getCartelle(int userId) {
		
		return cDAO.getCartelleUtente(userId);
	}

	public Cartella aggiungiRoot(int userId) {
		
		Servizi serv = new Servizi();
		Utente u = serv.getUtenteFromId(userId);
		Cartella cartella = new Cartella();
		cartella.setNome("root");
		cartella.setPadre(cartella);
		cartella.setIdProprietario(u);
		if (cDAO.aggiungiCartella(cartella)){
			return cDAO.getRootFolder(userId);
		}
		return null;
	}
	
	public Cartella getRootFolder(int userId){
		
		return cDAO.getRootFolder(userId);
	}

	public boolean aggiungiCartella(Cartella nuova, Cartella padre) {
		
		return cDAO.aggiungiCartella(nuova, padre);	
	}
	
	public Cartella getFolder(String nome, int idPadre){
		return cDAO.getFolder(nome, idPadre);
	}

}
