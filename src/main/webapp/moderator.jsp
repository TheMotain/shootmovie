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
						<table class="table table-hover">
						<tr>
							<th>#</th>
							<th>Titre</th>
							<th>Réalisateur</th>
							<th>Action</th>
							
							<%
								String videosString = (String) request.getAttribute("videos");
								String[] videos = videosString.split("£");
								for(int i = 0; i < videos.length; i++){
									String[] infos = videos[i].split("§");
							%>
								<tr>
									<td><% out.println(infos[0]); %></td>
									<td><a href="video?id=<% out.println(infos[0]); %>"><% out.println(infos[1]); %></a></td>
									<td><% out.println(infos[2]); %></td>
									<td>
										<a class="btn btn-xs btn-default" href="#" role="button"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span></a>
										<a class="btn btn-xs btn-danger" href="deleteVideo?id=<% out.println(infos[0]); %>" role="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
									</td>
								</tr>
							<% 
								}
							%>
						</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">Derniers commentaires</div>
					<div class="panel-body">
						<table class="table table-hover">
						<tr>
							<th>#</th>
							<th>Pseudo</th>
							<th>Date</th>
							<th>Contenu</th>
							<th>Lien de vidéo</th>
							<th>Action</th>
							
						</tr>
						<tr>
						<td>
								<a class="btn btn-xs btn-danger" href="#" role="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
							</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Dernières inscriptions</div>
					<div class="panel-body">
						<table class="table table-hover">
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
								<a class="btn btn-xs btn-danger" href="#" role="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
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
					<%
					String demandesString = (String) request.getAttribute("demandes");
					if(demandesString != null){
						String[] demandes = demandesString.split("£");
					%>
						<table class="table table-hover">
						<tr>
							<th>#</th>
							<th>Pseudo</th>
							<th>Lien de chaine</th>
							<th>Action</th>
							
							<%
								for(int i = 0; i < demandes.length; i++){
									String[] infos = demandes[i].split("§");
									out.println(infos.length);
									out.println(demandes.length);
							%>
								
								<tr>
									<td><% out.println(infos[0]); %></td>
									<td><% out.println(infos[1]); %></td>
									<td><a href="<% out.println(infos[2]); %>">Lien</a></td>
									<td>
										<a class="btn btn-xs btn-success" href="addRealisateur?id=<% out.println(infos[0]); %>&success=1" role="button"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></a>
										<a class="btn btn-xs btn-danger" href="addRealisateur?id=<% out.println(infos[0]); %>&success=0" role="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
									</td>
								</tr>
							<% 
								}
							%>
						</table>
						<% } else { %>
							<p class="text-center">Aucune demande.</p>
						<% } %>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Signalement vidéo</div>
					<div class="panel-body">
						<table class="table table-hover">
						<tr>
							<th>#</th>
							<th>Pseudo</th>
							<th>E-mail</th>
							<th>Rang</th>
							<th>Date d'inscription</th>
							<th>Action</th>
							
						</tr>
						<tr>
						<td>
								<a class="btn btn-xs btn-danger" href="#" role="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
								<a class="btn btn-xs btn-danger" href="#" role="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Signalement profil</div>
					<div class="panel-body">
						<table class="table table-hover">
						<tr>
							<th>#</th>
							<th>Pseudo</th>
							<th>Lien de chaine</th>
							<th>Action</th>
							
							<tr>
							<td>
								<a class="btn btn-xs btn-danger" href="#" role="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
								<a class="btn btn-xs btn-danger" href="#" role="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							</td>
							</tr>
						</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
