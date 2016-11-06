package it.alfasoft.bean;

import it.alfasoft.utils.CheckValues;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "rubrica_seq", sequenceName = "rubrica_seq", allocationSize    = 1)
public class Voce implements IsValid {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rubrica_seq")
	private int id_Voce;
	private String nome;
	private String cognome;
	private String telefono;

	@ManyToOne
	private Utente utente;

	public Voce() {

		nome = "";
		cognome = "";
		telefono = "";
	}

	public Voce(String nome, String cognome, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}

	public int getId_Voce() {
		return id_Voce;
	}

	public void setId_Voce(int id_Voce) {
		this.id_Voce = id_Voce;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public boolean isValid() {
		if (CheckValues.checkString(nome) && CheckValues.checkString(cognome) && CheckValues.checkString(telefono))
			return true;
		return false;
	}
}
