package tn.essat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Utilisateur;

/**
 * Servlet implementation class Verif
 */
public class Verif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verif() {
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
		
		String lg = request.getParameter("username");
		String pw = request.getParameter("pass");
		
		IGestion dao= new GestionImp();
		
		Utilisateur u = dao.verifUtilisateur(lg, pw);
		HttpSession session=request.getSession();
		
		if(u==null) {
			session.setAttribute("erreur", "Wrong login or password");
			session.setAttribute("type", "warning");
			request.getRequestDispatcher("connexion.jsp").forward(request, response);
		}else {
			session.setAttribute("user",u);
			request.getRequestDispatcher("PreOffre").forward(request, response);
		}
	}

}
