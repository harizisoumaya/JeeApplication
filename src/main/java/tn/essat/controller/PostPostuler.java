package tn.essat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Candidature;
import tn.essat.model.Offre;
import tn.essat.model.Utilisateur;

/**
 * Servlet implementation class PostPostuler
 */
public class PostPostuler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostPostuler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Utilisateur u=(Utilisateur) session.getAttribute("user");
		
		if(u==null) {
			session.setAttribute("erreur", "Please, Log in first !!");
			session.setAttribute("type", "danger");
			request.getRequestDispatcher("connexion.jsp").forward(request, response);
		}
		
		if(!u.getRole().equals("user")) {
			request.getRequestDispatcher("PreOffre").forward(request, response);
		}
		
		int id= Integer.parseInt(request.getParameter("offre"));
		String date1=request.getParameter("diplome");
		int nbre=Integer.parseInt(request.getParameter("annees"));
		String poste=request.getParameter("poste");
		
		IGestion dao = new GestionImp();
		
		Offre of = dao.getOffreById(id);
		Candidature c = new Candidature();
		
		c.setDate_diplome(date1);
		c.setNbre_annee(nbre);
		c.setDernier_poste(poste);
		c.setOffre(of);
		c.setUser(u);
		dao.addCandidature(c);
		
		request.getRequestDispatcher("PreOffre").forward(request, response);
		
	}

}
