package it.alfasoft.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "help_seq", sequenceName = "help_seq", allocationSize = 1, initialValue = 1)
public class UtenteHelp implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "help_seq")
	private int id;
	private String cognome;
	private String nome;
	private String email;
	private String problema;
	@Column(length = 500)
	private String messaggio;
	private String provenienzaHelp;
	private String dataInserimento;

	public UtenteHelp() {

	}

	public UtenteHelp(int id, String cognome, String nome, String email, String problema, String messaggio,
			String provenienzaHelp) {

		this.cognome = cognome;
		this.nome = nome;
		this.email = email;
		this.problema = problema;
		this.messaggio = messaggio;
		this.provenienzaHelp = provenienzaHelp;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getProvenienzaHelp() {
		return provenienzaHelp;
	}

	public void setProvenienzaHelp(String provenienzaHelp) {
		this.provenienzaHelp = provenienzaHelp;
	}

	public String getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
}
