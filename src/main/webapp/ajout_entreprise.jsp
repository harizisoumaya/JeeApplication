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
        
        <%@include file="gauche2.jsp" %>

        <div class="col-9" >            
                <div class="card ">
                    <div class="card-header bg-success text-white"> <h5>Ajouter une Entreprise </h5></div>
					<div class="card-body">
					           			
                    
					
					 <form method="POST" action="PostAjoutEntreprise"> 

						<div class="form-group">
                            <label ><b>Entreprise</b> </label>
                             <input name="titre" type="text" class="form-control" >                       
					   </div>	
						                        
						<div class="form-group">
                            <label ><b>Domaine</b> </label>
                            <input name="domaine" type="text" class="form-control" >
                        </div>
						<div class="form-group">
                            <label ><b>Ville</b> </label>
                            <input name="ville" type="text" class="form-control" >
                        </div>			
                       
                        <button type="submit" class="btn btn-info">Ajouter</button>
						
                      </form>
					
					

                    </div>


                </div>


        </div>

    </div>

</div>


</body>
</html>