package it.alfasoft.rubrica.service;

import java.util.List;

import it.alfasoft.rubrica.bean.Rubrica;
import it.alfasoft.rubrica.bean.Voce;
import it.alfasoft.rubrica.dao.RubricaDAO;
import it.alfasoft.rubrica.dao.VoceDAO;

public class ServiziRubrica {

	private VoceDAO vdao = new VoceDAO();
	private RubricaDAO rdao = new RubricaDAO();

	// Aggiungi rubrica
	public boolean registraRubrica(String nome) {
		boolean result = false;
		Rubrica r = new Rubrica();

		boolean b = rdao.creaRubrica(r);

		if (b == true) {
			result = true;
		}

		return result;
	}

	// Registra una voce
	public boolean aggiungiVoce(Rubrica r, String nome, String cognome, String telefono) {
		boolean result = false;

		Voce v = new Voce(nome, cognome, telefono);
		v.setRubrica(r);
//		r.addVoce(v);
		boolean b = vdao.aggiungiVoce(v);
		rdao.aggiornaRubrica(r);

		if (b == true) {
			result = true;
		}

		return result;

	}

	public boolean aggiornaVoce(Rubrica r, String nome, String nuovoNome, String cognome, String nuovoCognome,
			String telefono) {
		Voce v = vdao.trovaVoce(nome, cognome, r.getIdRubrica());
		v.setNome(nuovoNome);
		v.setCognome(nuovoCognome);
		v.setTelefono(telefono);
		boolean result = vdao.aggiornaVoce(v);

		return result;
	}

	// metodo per prendere tutte le voci di rubrica
	public List<Voce> getVoci(Rubrica r) {
//		List<Voce> voci = rdao.getVociRubrica(int);

		return null;
	}

	// metodo per eliminare una voce
	public boolean eliminaVoce(Rubrica r, String nome, String cognome) {
		Voce v = vdao.trovaVoce(nome, cognome, r.getIdRubrica());
		boolean result = vdao.eliminaVoce(v);
		return result;
	}

}
