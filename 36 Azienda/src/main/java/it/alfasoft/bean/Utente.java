package it.alfasoft.bean;

import java.io.Serializable;
import javax.persistence.*;
import it.alfasoft.utils.CheckValues;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
//@DiscriminatorColumn (discriminatorType = DiscriminatorType.STRING)
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	protected int id;
	protected String cognome;
	protected String nome;
	protected int ruolo;
	protected String username;
	protected String password;
	
	
	public Utente() {
		
		id = 0;
		cognome = "";
		nome = "";
		ruolo = 3;
		username = "";
		password = "";
	}
	
	public Utente(String cognome, String nome, int ruolo, String username, String password) {
		
		id = 0;
		this.cognome = cognome;
		this.nome = nome;
		this.ruolo = ruolo;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRuolo() {
		return ruolo;
	}

	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValid() {
		
		if (CheckValues.checkString(nome) && CheckValues.checkString(cognome) &&
				CheckValues.checkString(username) && CheckValues.checkString(password))
			return true;
		
		return false;
	}
}
