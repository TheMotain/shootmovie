<!DOCTYPE html>
<html lang="fr">
<head>
<title>ShootFilm - Se connecter</title>
<meta charset='utf-8'>
<!-- jQuery -->
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>


<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/video.css">
<script src="js/bootstrap.min.js"></script>

<!-- Code local -->
<script src="all.js"></script>
</head>
<body>

	<!-- ----------------- MENU HAUT ------------------- -->
	<%@ include file="/elements/menu.jsp"%>
	<!-- ----------------- FIN MENU HAUT ------------------- -->
	<div class="container">
		<%
			if (request.getParameter("error") != null) {
		%>
		<div class="alert alert-danger" role="alert">Pseudo ou mot de
			passe incorrect.</div>
		<%
			} else if (request.getParameter("inscription") != null) {
		%>
		<div class="alert alert-success" role="alert">Inscription
			réussie, vous pouvez vous connecter à ShootMovie.</div>
		<%
			} else if (request.getParameter("connexion") != null) {
		%>
		<div class="alert alert-danger" role="alert">Vous devez être connecté pour accéder à cette page.</div>
		<%
			}
		%>

		<div class="panel panel-default" style="width: 400px; margin: 0 auto;">
			<div class="panel-heading">Connexion à ShootMovie</div>
			<div class="panel-body">
				<form action='signin' method='post' class="form-horizontal">
					<div class="form-group">
						<input type='text' style="width: 370px; margin-left: 15px"
							class="form-control" name='login' placeholder="Login"><br>
					</div>
					<div class="form-group">
						<input type='password' style="width: 370px; margin-left: 15px"
							class="form-control" name='mdp' placeholder="Mot de passe"><br>
					</div>
					<input class="btn btn-block btn-default" type='submit'
						value='Se connecter'>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
