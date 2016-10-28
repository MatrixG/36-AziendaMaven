package it.alfasoft.rubrica.bean;

import javax.persistence.Entity;
import it.alfasoft.bean.IsValid;
import it.alfasoft.utils.CheckValues;

import javax.persistence.*;

@Entity
public class Voce implements IsValid {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_Voce;
	private String nome;
	private String cognome;
	private String telefono;
	
	@ManyToOne
	private Rubrica rubrica;

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

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	
	public boolean isValid() {
		if (CheckValues.checkString(nome) && CheckValues.checkString(cognome) &&
				CheckValues.checkString(telefono))
			return true;
		return false;
	}
}
