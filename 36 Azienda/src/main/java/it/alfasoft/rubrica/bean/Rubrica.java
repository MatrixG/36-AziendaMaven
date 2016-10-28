package it.alfasoft.rubrica.bean;


import javax.persistence.*;


@Entity
public class Rubrica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_Rubrica;
	
//	@OneToMany (mappedBy = "id", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
//	@NotFound(action=NotFoundAction.IGNORE)
//	private Set<Voce> voci = new HashSet<Voce>();

	public Rubrica() { 
	}

	public int getIdRubrica() {
		return id_Rubrica;
	}

	public void setIdRubrica(int idRubrica) {
		this.id_Rubrica = idRubrica;
	}
	
//	public Set<Voce> getListaVoci() {
//		return voci;
//	}
//
//	public void setListaVoci(Set<Voce> listaVoci) {
//		this.voci = listaVoci;
//	}
//
//	public boolean addVoce(Voce v){
//		return voci.add(v);
//	}
}
