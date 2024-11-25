package tn.essat.controller;

import java.io.IOException;

import javax.persistence.CascadeType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Servlet implementation class DeleteEntreprise
 */
public class DeleteEntreprise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEntreprise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		IGestion dao= new GestionImp();
		
		int idDel=Integer.parseInt(request.getParameter("idDel"));
		/*
		List<Offre> ListOffre = dao.getAllOffresByEntreprise(idDel);
		for(Offre o:ListOffre){
			List<Candidature> ListC = dao.getAllCandidaturesByOffre(o.getId());
			for (Candidature c:ListC) {
				dao.deleteCandidature(c.getId());
			}
			dao.deleteOffre(o.getId());
		}
		/// we can change all of this by adding one line to @ManyToOne in class:
		 * Offre and Candidature
		 * 		@ManyToOne(cascade = CascadeType.REMOVE)
				@JoinColumn(name = "entreprise_id", foreignKey = @ForeignKey(name = "fk_offre_entreprise", foreignKeyDefinition = "FOREIGN KEY (entreprise_id) REFERENCES Entreprise(id) ON DELETE CASCADE"))
				private Entreprise entreprise;

	*/
		
		dao.deleteEntreprise(idDel);
		
		request.getRequestDispatcher("PreEntreprise").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
