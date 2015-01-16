<!DOCTYPE html>
<html lang="fr">
<head>
<title>ShootFilm - Home</title>
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

	<%@ include file="/elements/menu.jsp"%>
	<!-- ----------------- FIN MENU HAUT ------------------- -->
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				Mes dernières vidéos
				<div style="float: right">
					<a class="btn btn-xs btn-success" href="addVideo" role="button"><span
						class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>Titre</th>
						<th>Réalisateur</th>
						<th>Date de publication</th>
					</tr>
					<%
						String videosString = (String) request.getAttribute("videos");
						if (!videosString.equals("")) {
							String[] videos = videosString.split("£");
							for (int i = 0; i < videos.length; i++) {
								String[] infos = videos[i].split("§");
					%>
					<tr>
						<td><a href="video?id=<%out.println(infos[0]);%>">
								<%
									out.println(infos[1]);
								%>
						</a></td>
						<td>
							<%
								out.println(infos[2]);
							%>
						</td>
						<td>
							<%
								out.println(infos[3]);
							%>
						</td>
					</tr>
					<%
						}
						}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
