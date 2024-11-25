<c:set var="usr" value="${sessionScope.user }"></c:set>
<div class="row" style="margin-top:10px;">
        <div class="col-12">
            <div class="card bg-info text-white">
                <div class="card-header">
                    <h1>Agence Emploi (ESSAT2024)<font size="5pt" > </font></h1>
					<div class="text-right">						
						<h1 >Bienvenue ${usr.nom } ${usr.prenom } (<a href="Logout">Déconnexion</a>)</h1>						
					</div>
                </div>
            </div>
        </div>
    </div>
