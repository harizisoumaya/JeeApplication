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
                <div class="card ">
                    <div class="card-header bg-success text-white"> <h5>Postuler pour une offre d'emploi </h5></div>
					<div class="card-body">
					           			
                    
					
					 <form method="POST" action="PostPostuler">
                       
						<div class="form-group">
                            <label ><b>Offre d'emploi</b></label>
                            <select class="form-control" name="offre">
                                <c:forEach items="${listOffre}" var="liste">
									<option value="${liste.id}">${liste.poste}</option>
								</c:forEach>
							 </select> 
                        </div>
                        
						<div class="form-group">
                            <label ><b>Date Diplome</b> </label>
                            <input name="diplome" type="date" class="form-control" >
                        </div>
						<div class="form-group">
                            <label ><b>Nombre d'années d'expertise ? </b></label>
                            <input name="annees" type="text" class="form-control" >
                        </div>
						<div class="form-group">
                            <label ><b>Dernier poste occupé</b> </label>
                             <select class="form-control" name="poste">
                                <option value="Pas de Poste Occupé">Pas de Poste Occupé</option>
								<option value="Ingénieur junior">Ingénieur junior</option>
								<option value="Ingénieur sénior">Ingénieur sénior</option>
								<option value="Stagaire">Stagiaire</option>
                            </select>
                        </div>						
                       
                        <button type="submit" class="btn btn-info">Postuler</button>
						
                      </form>
					
					

                    </div>


                </div>


        </div>

    </div>

</div>


</body>
</html>