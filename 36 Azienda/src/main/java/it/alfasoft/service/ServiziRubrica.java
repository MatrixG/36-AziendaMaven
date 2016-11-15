package it.alfasoft.service;

import java.util.List;
import it.alfasoft.bean.Voce;
import it.alfasoft.dao.VoceDAO;

public class ServiziRubrica {

	private VoceDAO vDao = new VoceDAO();

	// Registra una voce
	public boolean aggiungiVoce(Voce v) {
		
		return vDao.aggiungiVoce(v);
	}

	public boolean aggiornaVoce(String nome, String nuovoNome, String cognome, String nuovoCognome, String telefono) {
		// Voce v = vDao.trovaVoce(nome, cognome, r.getIdRubrica());
		// v.setNome(nuovoNome);
		// v.setCognome(nuovoCognome);
		// v.setTelefono(telefono);
		// boolean result = vDao.aggiornaVoce(v);
		//
		return false;
	}

	// metodo per prendere tutte le voci di rubrica
	public List<Voce> getVoci(int id) {
		// List<Voce> voci = rdao.getVociRubrica(int);

		return vDao.getVoci(id);
	}

	// metodo per eliminare una voce
	public boolean eliminaVoce(String nome, String cognome) {
		// Voce v = vDao.trovaVoce(nome, cognome, r.getIdRubrica());
		// boolean result = vDao.eliminaVoce(v);
		return false;
	}
}
