<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="bootstrap4/css/bootstrap.min.css"  rel="stylesheet" >
    <script type="text/javascript" src="bootstrap4/js/jquery.min.js" ></script>
    <script type="text/javascript" src="bootstrap4/js/bootstrap.min.js" ></script>
    <link href="fontawesome/css/all.css" rel="stylesheet">

</head>
<body>

<%@include file="entete.jsp" %>    	
    	
<div class="container-fluid">


    <div class="row" style="margin-top:10px;">
       
       <%@include file="gauche.jsp" %>

        <div class="col-9" >            
                <div class="card text-white">
                    <div class="card-header bg-success"> <h5>Liste des offres d'emploi </h5></div>
					<div class="card-body">
						<c:if test="${usr.role==\"user\" }">
					            <a href="PrePostuler" class="btn btn-primary mb-3">Postuler pour une offre d'emploi</a>
					    </c:if>
					    <c:if test="${usr.role==\"admin\" }">
								<a href="PreAjout" class="btn btn-danger mb-3">Ajouter une offre d'emploi</a>
						</c:if>  					
                    <table class="table table-hover table-bordered">
                        <thead class="thead-light">
                          <tr><th>Poste</th><th>Entreprise</th><th>Date_Embauche</th> 
						      <th>Salaire</th><th></th>
						  </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${liste}" var="o">
                            <tr>				
								<td> ${o.poste }</td>
                                <td> ${o.entreprise.titre }</td>   
								<td> ${o.date_embauche }</td> 
								<td> ${o.salaire }</td> 								
								<td>
								<c:if test="${usr.role==\"admin\" }">
									<a href="PreCandidature?id=${o.id}" class="btn btn-info">Liste des candidats</a> 
									<a href="" class="btn btn-danger">DELETE</a>	
								</c:if>							
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