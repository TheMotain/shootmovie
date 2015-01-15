<!DOCTYPE html>
<html lang="fr">
<head>
<title>ShootFilm - Pseudo</title>
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
	
	<%@ include file="/elements/menu.jsp" %>
	<!-- ----------------- FIN MENU HAUT ------------------- -->
	
	<form method="post" action="modifierProfil">
		<input type="hidden" name="change" value="1" />
		<p>
			<label for="pseudo">Changer de Pseudo :</label>		
		      	<input type="text" name="pseudo" id="pseudo" placeholder="Ex : toto"/>
		</p>

		<p>
			<label for="mdp">Changer de Mot de Passe :</label>
			<input type="text" name="mdp" id="mdp"/>
		</p>

		<p>
			<label for="mdpVerif">Confirmation Mot de Passe :</label>
			<input type="text" name="mdpVerif" id="mdpVerif"/>
		</p>

		<p>
			<label for="email">Changer d'email :</label>
			<input type="email" name="email" id="email"/>
		</p>

		<p>
			<label for="des">Description du profil :</label>
			<textarea name="des" id="des "></textarea>
		</p>

		<p>Vos Resals Socials :
			<label for="fb">Facebook : </label>
			<input type="url" name="fb" id="fb"/>
		</p>

		<p>
			<label for="twitter">Twitter :</label>
			<input type="url" name="twitter" id="twitter"/>
		</p>

		<p>
			<label for="gplus">Google+ ? :</label>
			<input type="url" name="gplus" id="gplus"/>
		</p>

		<p>
			<input type="button" name="rea" id="rea" value="Demander à devenir un réalisateur"/>
		</p>

		<p>
			<input type="submit" name="send" id="send" value="Envoyer"/>
		</p>

	</form>
