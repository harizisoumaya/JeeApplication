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
public class Candidature {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date_diplome;	
	private String dernier_poste;
	private int nbre_annee;
	
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name = "offre_id", foreignKey = @ForeignKey(name="fk_candidature_offre", foreignKeyDefinition = "FOREIGN KEY (offre_id) REFERENCES Offre(id) ON DELETE CASCADE"))
	private Offre offre;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Utilisateur user;
	
	
	public Candidature(int id, String date_diplome, String dernier_poste, int nbre_annee, Offre offre,
			Utilisateur user) {
		super();
		this.id = id;
		this.date_diplome = date_diplome;
		this.dernier_poste = dernier_poste;
		this.nbre_annee = nbre_annee;
		this.offre = offre;
		this.user = user;
	}
	public Candidature() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate_diplome() {
		return date_diplome;
	}
	public void setDate_diplome(String date_diplome) {
		this.date_diplome = date_diplome;
	}
	public String getDernier_poste() {
		return dernier_poste;
	}
	public void setDernier_poste(String dernier_poste) {
		this.dernier_poste = dernier_poste;
	}
	public int getNbre_annee() {
		return nbre_annee;
	}
	public void setNbre_annee(int nbre_annee) {
		this.nbre_annee = nbre_annee;
	}
	public Offre getOffre() {
		return offre;
	}
	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	
	
	
}
