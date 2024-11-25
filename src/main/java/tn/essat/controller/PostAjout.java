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
import tn.essat.model.Offre;
import tn.essat.model.Utilisateur;

/**
 * Servlet implementation class PostAjout
 */
public class PostAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAjout() {
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
		
		int idEnt = Integer.parseInt(request.getParameter("entreprise"));
		String poste = request.getParameter("poste");
		String salaire = request.getParameter("salaire");
		String date_embauche = request.getParameter("date_embauche");
		
		
		IGestion dao = new GestionImp();
		
		Entreprise e = dao.getEntrepriseById(idEnt);
		
		Offre o= new Offre();
		o.setPoste(poste);
		o.setDate_embauche(date_embauche);
		o.setSalaire(salaire);
		o.setEntreprise(e);
		dao.addOffre(o);
		
		request.getRequestDispatcher("PreOffre").forward(request, response);
	}

}
