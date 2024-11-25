package tn.essat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Entreprise;
import tn.essat.model.Utilisateur;

/**
 * Servlet implementation class PostAjoutEntreprise
 */
public class PostAjoutEntreprise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAjoutEntreprise() {
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
		
		if(!u.getRole().equals("admin")) {
			request.getRequestDispatcher("PreOffre").forward(request, response);
		}
		String titre = request.getParameter("titre");
		String domaine = request.getParameter("domaine");
		String ville = request.getParameter("ville");
		
		IGestion dao = new GestionImp();
		
		Entreprise e= new Entreprise();
		e.setTitre(titre);
		e.setDomaine(domaine);
		e.setVille(ville);
		dao.addEntreprise(e);
		
		request.getRequestDispatcher("PreEntreprise").forward(request, response);
	}

}
