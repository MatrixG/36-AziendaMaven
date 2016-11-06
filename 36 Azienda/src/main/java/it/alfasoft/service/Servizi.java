package it.alfasoft.service;

import java.util.List;
import it.alfasoft.bean.Cliente;
import it.alfasoft.bean.Dipendente;
import it.alfasoft.bean.Utente;
import it.alfasoft.dao.UtenteDAO;
import it.alfasoft.dao.ClienteDAO;
import it.alfasoft.dao.DipendenteDAO;
import it.alfasoft.utils.PSWEncoding;

/* Legenda per i ruoli
 * 
 * 0 -> Admin
 * 1 -> Dipendente
 * 2 -> Cliente
 * 3 -> Ruolo non assegnato
 */

//La classe Servizi gestisce l'interfacciamento alla base dati
public class Servizi {

	ClienteDAO cDAO = new ClienteDAO();
	DipendenteDAO dDAO = new DipendenteDAO();
	UtenteDAO uDAO = new UtenteDAO();
	
	// Metodo utile per riempire i campi di un Utente
	public Object riempiUtente(String username, int ruolo){
		
		switch (ruolo) {
		case 0:
			return (Object)uDAO.leggiUtente(username);
		case 1:
			return (Object)dDAO.leggiDipendente(username);
		case 2:
			return (Object)cDAO.leggiCliente(username);
		}
		return null;
	}
	
	//Funzione che controlla il login degli utenti
	public Utente loginUtente(Utente u){
		
		return uDAO.loginUtente(u);
	}

	// Effettua l'inserimento di un cliente nel DB
	public boolean registraCliente(Cliente c) {

		c.setRuolo(2);
		return cDAO.creaCliente(c);
	}

	// Restituisce tutti i Clienti nel DB
	public List<Cliente> getTuttiClienti() {

		return cDAO.getTuttiClienti();
	}

	// Effettua l'inserimento di un dipendente nel DB
	public boolean registraDipendente(Dipendente d) {

		d.setRuolo(1);
		return dDAO.creaDipendente(d);
	}

	// Restituisce tutti i Clienti nel DB
	public List<Dipendente> getTuttiDipendenti() {

		return dDAO.getTuttiDipendenti();
	}
	
	//Check se lo username è già usato
	public boolean checkUsername(String username) {
		
		return uDAO.checkUsername(username);
	}

	// Metodo per la cifratura della password
	public String convertiPsw(String psw) {

		return PSWEncoding.codificatePass(psw);
	}

	public boolean cancellaUtente(String email) {
		// TODO Auto-generated method stub
		return uDAO.rimuoviUtente(email);
	}
}
