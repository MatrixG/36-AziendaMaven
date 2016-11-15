package it.alfasoft.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "folder_seq", sequenceName = "folder_seq", allocationSize = 1, initialValue = 2)
public class Cartella implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "folder_seq")
	private int id;
	private String nome;
	
	@OneToOne
	private Utente idProprietario;
	
	
	@OneToOne
	private Cartella padre;
	
	@OneToMany
	private List<Cartella> figli;

	public Cartella() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cartella> getFigli() {
		return figli;
	}

	public void setFigli(List<Cartella> figli) {
		this.figli = figli;
	}

	public Utente getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Utente idProprietario) {
		this.idProprietario = idProprietario;
	}

	public Cartella getPadre() {
		return padre;
	}

	public void setPadre(Cartella padre) {
		this.padre = padre;
	}

}
