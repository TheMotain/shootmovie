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
	<%@ include file="/elements/menu.jsp" %>
	<!-- ----------------- FIN MENU HAUT ------------------- -->
	<div class="container">
			<%
				if(request.getParameter("error") != null){
			%>
				<div class="alert alert-danger" role="alert">Le pseudo existe déjà. Veuillez en utiliser un autre.</div>
			<%
				}
			%>
			<div class="panel panel-default" style="width:400px; margin:0 auto;">
					<div class="panel-heading">Inscription Ã  ShootMovie</div>
					<div class="panel-body">
						<form action='signup' method='get' class="form-horizontal">
							<div class="form-group">
								<input type='text' style="width:370px;margin-left:15px" class="form-control" name='login' placeholder="Login"><br>
							</div>
							<div class="form-group">
								<input type='password' style="width:370px;margin-left:15px" class="form-control" name='mdp' placeholder="Mot de passe"><br>
							</div>
							<div class="form-group">
								<input type='email' style="width:370px;margin-left:15px" class="form-control" name='email' placeholder="E-mail"><br>
							</div>
							<input class="btn btn-block btn-default" type='submit' value="S'inscrire">
							<input class="btn btn-block btn-default" type='reset' value='RÃ©initialiser'>
						</form>
					</div>
			</div>
			
	</div>
</body>
</html>