package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Entreprise {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String domaine;
	private String ville;
	
	public Entreprise(int id, String titre, String domaine, String ville) {
		super();
		this.id = id;
		this.titre = titre;
		this.domaine = domaine;
		this.ville = ville;
	}
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
