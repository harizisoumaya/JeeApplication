package tn.essat.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import at.favre.lib.crypto.bcrypt.BCrypt;
import tn.essat.model.Candidature;
import tn.essat.model.Entreprise;
import tn.essat.model.Offre;
import tn.essat.model.Utilisateur;

public class GestionImp implements IGestion {
	
	private Session session;
	
	public GestionImp() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata =  new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();	
		session=sessionFactory.openSession();
	}
	@Override
	public List<Offre> getAllOffres() {
		Query<Offre> queryOffre = session.createQuery("Select o from Offre o");
		return queryOffre.getResultList(); 
	}

	@Override
	public void addOffre(Offre o) {
		session.getTransaction().begin();
		session.save(o);
		session.getTransaction().commit();
	}

	@Override
	public void deleteOffre(int id) {
		Offre o = session.load(Offre.class, id);
		session.getTransaction().begin();
		session.delete(o);
		session.getTransaction().commit();
	}

	@Override
	public Offre getOffreById(int id) {
		return session.load(Offre.class, id);
	}

	@Override
	public List<Entreprise> getAllEntreprises() {
		Query<Entreprise> q = session.createQuery("Select e from Entreprise e");
		return q.getResultList(); 
	}

	@Override
	public void addEntreprise(Entreprise e) {
		session.getTransaction().begin();
		session.save(e);
		session.getTransaction().commit();
	}

	@Override
	public void deleteEntreprise(int id) {
		Entreprise e = session.load(Entreprise.class, id);
		session.getTransaction().begin();
		session.delete(e);
		session.getTransaction().commit();
	}

	@Override
	public Entreprise getEntrepriseById(int id) {
		return session.load(Entreprise.class, id);
	}

	@Override
	public List<Candidature> getAllCandidaturesByOffre(int id_offre) {
		Query<Candidature> queryCandidature = session.createQuery("Select c from Candidature c where c.offre.id =?1");
		queryCandidature.setParameter(1, id_offre);
		return queryCandidature.getResultList();
	}
	@Override
	public void addCandidature(Candidature c) {
		session.getTransaction().begin();
		session.save(c);
		session.getTransaction().commit();
		
	}
	@Override
	public void deleteCandidature(int id) {
		Candidature c = session.load(Candidature.class, id);
		session.getTransaction().begin();
		session.delete(c);
		session.getTransaction().commit();
		
	}

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		Query<Utilisateur> q = session.createQuery("Select u from Utilisateur u");
		return q.getResultList(); 
	}

	@Override
	public void addUtilisateur(Utilisateur u) {
		session.getTransaction().begin();
		session.save(u);
		session.getTransaction().commit();	
	}

	@Override
	public void deleteUtilisateur(int id) {
		Utilisateur u = session.load(Utilisateur.class, id);
		session.getTransaction().begin();
		session.delete(u);
		session.getTransaction().commit();
	}

	@Override
	public Utilisateur getUtilisateurById(int id) {
		return session.load(Utilisateur.class, id);
	}

	@Override
	public Utilisateur verifUtilisateur(String login, String password) {
		Utilisateur u=null;
		try {	
			Query<Utilisateur> queryUser = session.createQuery("Select u from Utilisateur u where u.login=?1");
			queryUser.setParameter(1, login);
			List<Utilisateur> listUser = queryUser.getResultList();
			for (Utilisateur ur:listUser) {
				BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), ur.getPassword());
				if(result.verified==true) {
					u=ur;
				}
			}
		}catch (NoResultException e ) {
			u=null;
		}
		return u;
	}
	@Override
	public Candidature getCandidatureById(int id) {
		return session.load(Candidature.class, id);
	}
	@Override
	public List<Offre> getAllOffresByEntreprise(int id_entreprise) {
		Query<Offre> queryOffre = session.createQuery("Select o from Offre o where o.entreprise.id =?1");
		queryOffre.setParameter(1, id_entreprise);
		return queryOffre.getResultList();
	}



}
