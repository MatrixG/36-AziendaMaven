package it.alfasoft.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import it.alfasoft.utils.CheckValues;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1, initialValue = 2)
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	protected int id;
	protected String cognome;
	protected String nome;
	protected int ruolo;
	protected String username;
	protected String password;

	@OneToMany (mappedBy = "utente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected List<Voce> listaContatti;

	public Utente() {

		id = 0;
		cognome = "";
		nome = "";
		ruolo = 3;
		username = "";
		password = "";
		listaContatti = new ArrayList<Voce>();
	}

	public Utente(String cognome, String nome, int ruolo, String username, String password, List<Voce> listaContatti) {

		id = 0;
		this.cognome = cognome;
		this.nome = nome;
		this.ruolo = ruolo;
		this.username = username;
		this.password = password;
		this.listaContatti = listaContatti;
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

	public List<Voce> getListaContatti() {
		return listaContatti;
	}

	public void setListaContatti(List<Voce> listaContatti) {
		this.listaContatti = listaContatti;
	}

	public boolean addContatto(Voce v) {

		return listaContatti.add(v);
	}

	public boolean removeContatto(Voce v) {

		return listaContatti.remove(v);
	}

	public boolean isValid() {

		if (CheckValues.checkString(nome) && CheckValues.checkString(cognome) && CheckValues.checkString(username)
				&& CheckValues.checkString(password))
			return true;

		return false;
	}
}
