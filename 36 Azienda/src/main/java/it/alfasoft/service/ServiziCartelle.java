package it.alfasoft.service;

import java.util.List;

import it.alfasoft.bean.Cartella;
import it.alfasoft.dao.CartelleDAO;

public class ServiziCartelle {

	private CartelleDAO cDAO = new CartelleDAO();
	
	public List<Cartella> getCartelle(int userId) {
		
		
		return cDAO.getRootId(userId);
	}

	public List<Cartella> aggiungiRoot(int UserId) {
		
		Servizi serv = new Servizi();
		serv.
		
		return null;
	}

}
