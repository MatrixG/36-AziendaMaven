package it.alfasoft.bean;

import javax.persistence.*;
import it.alfasoft.utils.CheckValues;

@Entity
@DiscriminatorValue (value = "Cliente")
public class Cliente extends Utente implements IsValid {

	private static final long serialVersionUID = 1L;
	private String ragSociale;
	private String pIva;
	
	public Cliente() {
		
		super();
		ragSociale = "";
		pIva = "";
	}
	
	public Cliente(String ragSociale, String pIva) {
		super();
		this.ragSociale = ragSociale;
		this.pIva = pIva;
	}

	public String getRagSociale() {
		return ragSociale;
	}

	public void setRagSociale(String ragSociale) {
		this.ragSociale = ragSociale;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	public boolean isValid() {
		
		if (CheckValues.checkString(pIva) && CheckValues.checkString(ragSociale) &&
				CheckValues.checkString(nome) && CheckValues.checkString(cognome) &&
				CheckValues.checkString(username) && CheckValues.checkString(password))
			return true;
		
		return false;
	}
}
