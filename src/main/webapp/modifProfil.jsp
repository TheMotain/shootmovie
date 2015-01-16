<!DOCTYPE html>
<html lang="fr">
<head>
<title>ShootFilm - Modifier mon profil</title>
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
			<div class="panel-heading">Modifier mon profil</div>
			<div class="panel-body">
				<form method="post" class="form-horizontal" action="modifierProfil">
					<input type="hidden" name="change" value="1" />
					<div class="form-group">
						<label for="pseudo" class="col-sm-2 control-label">Pseudo
							:</label>
						<div class="col-sm-10">
							<input type="text" name="pseudo" class="form-control" id="pseudo"
								placeholder="Ex : toto" />
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="mdp" class="col-sm-2 control-label">Mot de
							Passe :</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="mdp" id="mdp" />
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="mdpVerif" class="col-sm-2 control-label">Mot
							de Passe (v�rification) :</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="mdpVerif"
								id="mdpVerif" />
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">E-mail :</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" name="email" id="email" />
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="des" class="col-sm-2 control-label">Description
							:</label>
						<div class="col-sm-10">
							<textarea name="des" class="form-control" rows=5 id="des"></textarea>
						</div>
					</div>

					<hr>

					<div class="form-group">
						<label for="fb" class="col-sm-2 control-label">Facebook :</label>
						<div class="col-sm-10">
							<input type="url" class="form-control" name="fb" id="fb" />
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="twitter" class="col-sm-2 control-label">Twitter
							:</label>
						<div class="col-sm-10">
							<input type="url" class="form-control" name="twitter"
								id="twitter" />
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="gplus" class="col-sm-2 control-label">Google +
							:</label>
						<div class="col-sm-10">
							<input type="url" class="form-control" name="gplus" id="gplus" />
						</div>
					</div>

					<br> <input type="submit" class="btn btn-default btn-block"
						name="send" id="send" value="Envoyer" />

				</form>
				<br>
				<button type="button" class="btn btn-success pull-right"
					data-toggle="modal" data-target="#realisateur">Devenir
					r�alisateur</button>
				<div style="clear: both"></div>

			</div>
		</div>
	</div>

	<div class="modal fade" id="realisateur" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">Devenir r�alisateur</h4>
				</div>
				<div class="modal-body">
					<p>Pour pouvoir <b>devenir r�alisateur</b>, vous devez simplement
						ajouter <b>un lien vers votre chaine de publication de vos vid�os</b>.
						Grace � �a, nos �quipes vont pouvoir v�rifier que vous �tes bien
						propri�taire du compte, et aussi v�rifier que vous faites bien des
						r�alisations en correspondance avec le th�me du site.</p>

						<form action="realisateur" method="post">
							<div class="form-group">
								<input type='text' class="form-control" name='link' placeholder="Lien de la cha�ne"><br>
							</div>
							<input class="btn btn-block btn-success" type='submit'
							value="Devenir r�alisateur">
						</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>