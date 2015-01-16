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
					action="changeAvatar">
					<div class="form-group">
						<label for="inputPassword" class="col-sm-1 control-label">Avatar</label>
						<div class="col-sm-11">
							<input type="text" class="form-control" name="avatar">
						</div>
					</div>
				</form>
				<form method="post" class="form-horizontal"
					action="changeBaniere">
					<div class="form-group">
						<label for="inputPassword" class="col-sm-1 control-label">Banière</label>
						<div class="col-sm-11">
							<input type="text" class="form-control" name="baniere">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>