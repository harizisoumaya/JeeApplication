package tn.essat.dao;

import java.util.List;

import tn.essat.model.Candidature;
import tn.essat.model.Entreprise;
import tn.essat.model.Offre;
import tn.essat.model.Utilisateur;


public interface IGestion {
	
	public List<Offre> getAllOffres();
	public void addOffre(Offre o);
	public void deleteOffre(int id);
	public Offre getOffreById(int id);
	public List<Offre> getAllOffresByEntreprise(int id_entreprise);
	
	
	public List<Entreprise> getAllEntreprises();
	public void addEntreprise(Entreprise e);
	public void deleteEntreprise(int id);
	public Entreprise getEntrepriseById(int id);
	
	public List<Candidature> getAllCandidaturesByOffre(int id_offre);
	public void addCandidature(Candidature c);
	public void deleteCandidature(int id);
	public Candidature getCandidatureById(int id);
	
	public List<Utilisateur> getAllUtilisateurs();
	public void addUtilisateur(Utilisateur u);
	public void deleteUtilisateur(int id);
	public Utilisateur getUtilisateurById(int id);
	public Utilisateur verifUtilisateur(String login, String password);
	

}
