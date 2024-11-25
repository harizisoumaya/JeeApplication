<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="bootstrap4/css/bootstrap.min.css" rel="stylesheet">
    <c:set var="err" value="${sessionScope.erreur}"></c:set>
    <c:set var="err_type" value="${sessionScope.type}"></c:set> 
</head>
<body>
<p><a href="connexion.jsp"> Refresh </a></p>
<div class="container" style="margin-top:50px;">

    <div class="row justify-content-center ">
        <div class="col-6 bg-primary text-white">

            <div class="mt-6">
                <p><h1 style="text-align:center">Connexion</h1></p>
				<br>
                <form method="POST" action="Verif">
                    <div class="form-group">
                        <label>Username</label>
                        <input name="username" type="text" class="form-control" placeholder="Votre username">
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input name="pass" type="password" class="form-control" placeholder="Votre Mot de passe">
                    </div>
                    <button type="submit" class="btn btn-success mb-4">Se Connecter</button>
                </form>
            </div>
        </div>
        
    	</div>

</div>
    	<c:if test="${err != null}">
            	<div class="alert-${err_type}">
            		<p>${err}</p>
            	</div>
        </c:if>
	    <c:remove var="erreur" scope="session"/>
		<c:remove var="type" scope="session"/>
</body>
</html>
    