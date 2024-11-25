<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="bootstrap4/css/bootstrap.min.css"  rel="stylesheet" >
    <script type="text/javascript" src="bootstrap4/js/jquery.min.js" ></script>
    <script type="text/javascript" src="bootstrap4/js/bootstrap.min.js" ></script>
    <link href="fontawesome/css/all.css" rel="stylesheet">

</head>
<body>
<div class="container-fluid">

  <%@include file="entete.jsp" %> 

    <div class="row" style="margin-top:10px;">
        
        <%@include file="gauche.jsp" %>

        <div class="col-9" >            
                <div class="card text-white">
                    <div class="card-header bg-success"> <h5>Liste des candidats pour une offre d'emploi </h5></div>
					<div class="card-body">
					
					<div class="alert alert-info"> 
							<h6> Poste : <u> ${selectedOffre.poste} </u></h6>
							<h6> Entreprise : ${selectedOffre.entreprise.titre}</h6>
							<h6> Emplacement de l'entreprise : ${selectedOffre.entreprise.ville}</h6>
							<h6> Date d'ajout : ${selectedOffre.date_embauche}</h6>
							<h6> Salaire : ${selectedOffre.salaire}</h6>
					</div>				 
					
					 
                    <table class="table table-hover table-bordered">
                        <thead class="thead-light">
                          <tr><th>Nom et prénom</th><th>Dernier Poste	</th><th>Expérience</th> <th></th>
						  </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${listC}" var="c">
                            	<tr>			
									<td> ${c.user.nom} ${c.user.prenom} </td>   
									<td> ${c.dernier_poste} </td> 
									<td> ${c.nbre_annee} ans</td> 															
									<td>
									<a href="DeleteCandidature?idDel=${c.id}" class="btn btn-danger">Delete</a>							
									</td>								
                           		</tr>
                            </c:forEach>						
							
                        </tbody>

                    </table>

             </div>


            </div>


        </div>

    </div>

</div>


</body>
</html>