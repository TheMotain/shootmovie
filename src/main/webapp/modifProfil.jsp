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
							<input type="text" name="pseudo" class="form-control" id="pseudo" value= 
									<%
										String pseudo = (String) request.getAttribute("name");
										out.println(pseudo);
									%>
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
							de Passe (vérification) :</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="mdpVerif"
								id="mdpVerif" />
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">E-mail :</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" name="email" id="email" value=
									<%
										String email = (String) request.getAttribute("email");
										out.println(email);
									%> 
							/>
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="des" class="col-sm-2 control-label">Description
							:</label>
						<div class="col-sm-10">
							<textarea name="des" class="form-control" rows=5 id="des" value=
									<%
										String des = (String) request.getAttribute("des");
										out.println(des);
									%>>
							</textarea>
						</div>
					</div>

					<hr>

					<div class="form-group">
						<label for="fb" class="col-sm-2 control-label">Facebook :</label>
						<div class="col-sm-10">
							<input type="url" class="form-control" name="fb" id="fb" value=
									<%
										String fb = (String) request.getAttribute("facebook");
										out.println(fb);
									%>
							/>
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="twitter" class="col-sm-2 control-label">Twitter
							:</label>
						<div class="col-sm-10">
							<input type="url" class="form-control" name="twitter"
								id="twitter" value=
									<%
										String twitter = (String) request.getAttribute("twitter");
										out.println(twitter);
									%>
							/>
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="gplus" class="col-sm-2 control-label">Google +
							:</label>
						<div class="col-sm-10">
							<input type="url" class="form-control" name="gplus" id="gplus" value=
									<%
										String gplus = (String) request.getAttribute("gplus");
										out.println(gplus);
									%>
							/>
						</div>
					</div>

					<br> <input type="submit" class="btn btn-default btn-block"
						name="send" id="send" value="Envoyer" />

				</form>
				<br>
				<button type="button" class="btn btn-success pull-right"
					data-toggle="modal" data-target="#realisateur">Devenir
					réalisateur</button>
				<div style="clear: both"></div>

			</div>
		</div>
	</div>

	<div class="modal fade" id="realisateur" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">Devenir réalisateur</h4>
				</div>
				<div class="modal-body">
					<p>Pour pouvoir <b>devenir réalisateur</b>, vous devez simplement
						ajouter <b>un lien vers votre chaine de publication de vos vidéos</b>.
						Grace à ça, nos équipes vont pouvoir vérifier que vous êtes bien
						propriétaire du compte, et aussi vérifier que vous faites bien des
						réalisations en correspondance avec le thème du site.</p>

						<form action="realisateur" method="post" id="ask" onsubmit="return valider()">
							<div class="form-group">
								<input type='text' class="form-control" name='link' placeholder="Lien de la chaîne"><br>
							</div>
							<input class="btn btn-block btn-success" type='submit'
							value="Devenir réalisateur">
						</form>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function valider(){
			form=document.forms["ask"];
			if(form.elements["link"].value !== ""){
				return true;
			}
			else{
				alert("Veuillez mettre un lien vers vos réalisations");
				return false;
			}
		}
	</script>
</body>
</html>
