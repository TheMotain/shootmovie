<!DOCTYPE html>
<html lang="fr">
<head>
<title>ShootFilm - Modifier la vidéo</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- jQuery -->
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
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
			<div class="panel-heading">Modifier la vidéo</div>
			<div class="panel-body">
				<form method="post" class="form-horizontal"
					action="setchangevideo?id=<%out.print(request.getParameter("id"));%>">
					<div class="form-group">
						<label for="inputPassword" class="col-sm-1 control-label">Titre</label>
						<div class="col-sm-11">
							<input type="text" class="form-control" name="titre" value="<%out.print((String)request.getAttribute("titre"));%>">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-1 control-label">Description</label>
						<div class="col-sm-11">
							<textarea class="form-control" name="description" rows="5"
								cols=""><%out.print((String)request.getAttribute("description"));%></textarea>
						</div>
					</div>
					<br> <input type="submit" class="btn btn-block btn-default"
						name="lien" value="Envoyer">
				</form>
			</div>
		</div>
	</div>
</body>
</html>