package tn.essat.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Offre {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String poste;
	private String date_embauche;
	private String salaire;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "entreprise_id", foreignKey = @ForeignKey(name = "fk_offre_entreprise", foreignKeyDefinition = "FOREIGN KEY (entreprise_id) REFERENCES Entreprise(id) ON DELETE CASCADE"))
	private Entreprise entreprise;

	
	public Offre(int id, String poste, String date_embauche, String salaire, Entreprise entreprise) {
		super();
		this.id = id;
		this.poste = poste;
		this.date_embauche = date_embauche;
		this.salaire = salaire;
		this.entreprise = entreprise;
	}
	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getDate_embauche() {
		return date_embauche;
	}
	public void setDate_embauche(String date_embauche) {
		this.date_embauche = date_embauche;
	}
	public String getSalaire() {
		return salaire;
	}
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	
	

}
