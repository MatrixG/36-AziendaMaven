package it.alfasoft.bean;

import javax.persistence.*;
import it.alfasoft.utils.CheckValues;

@Entity
@DiscriminatorValue(value = "Dipendente")
public class Dipendente extends Utente implements IsValid {

	private static final long serialVersionUID = 1L;
	private int stipendio;
	private String posizione;

	public Dipendente() {

		stipendio = 0;
		posizione = "";
	}

	public Dipendente(int stipendio, String posizione) {

		super();
		this.stipendio = stipendio;
		this.posizione = posizione;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public boolean isValid() {

		if (CheckValues.checkString(posizione) && CheckValues.checkString(nome) && CheckValues.checkString(cognome)
				&& CheckValues.checkString(username) && CheckValues.checkString(password))
			return true;

		return false;
	}
}
