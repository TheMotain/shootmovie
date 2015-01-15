<!DOCTYPE html>
<html lang="fr">
<head>
<title>ShootFilm - Modération</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- jQuery -->
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/profil.css">
<script src="js/bootstrap.min.js"></script>

<!-- Code local -->
<script src="all.js"></script>
</head>
<body>

	<!-- ----------------- MENU HAUT ------------------- -->
	
	<%@ include file="/elements/menu.jsp" %>
	
	<!-- ----------------- FIN MENU HAUT ------------------- -->
	<div class="container">
		<div class="row">
			<div class="col-md-7">
				<div class="panel panel-default">
					<div class="panel-heading">Dernières vidéos</div>
					<div class="panel-body">
						
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">Derniers commentaires</div>
					<div class="panel-body">
					
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Dernières inscriptions</div>
					<div class="panel-body">
						<table class="table table-hover table-bordered">
						<tr>
							<th>#</th>
							<th>Pseudo</th>
							<th>E-mail</th>
							<th>Rang</th>
							<th>Date d'inscription</th>
							<th>Action</th>
						</tr>
						<%
							String users = (String) request.getAttribute("users");
							String[] user = users.split("\\|");
							for(int i = 0; i < user.length; i++){
								String[] infos = user[i].split(":");
								out.println("<tr>");
								for(int j = 0; j < infos.length; j++){
									out.println("<td>"+infos[j]+"</td>");
								}
						%>
								<td>
								<a class="btn btn-xs btn-default" href="#" role="button"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span></a>
								<a class="btn btn-xs btn-danger" href="#" role="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
								</td>
						<%
								out.println("</tr>");
							}
						%>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Demandes de grade</div>
					<div class="panel-body">
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
