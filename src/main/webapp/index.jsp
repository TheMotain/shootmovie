<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Bonjour -->
<title>ShootMovie</title>
<meta charset='utf-8'>
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

		<div class="row" style="margin-top: 10px;">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">ShootMovie</div>
					<div class="panel-body">
						<p>ShootMovie est une plateforme de courts-métrages
							cinématographiques. Ici, vous pourrez trouver une multitude de
							courts-métrages de réalisateurs amateur. Vous pourrez noter et
							commentez les réalisations présentes sur le site, et vous abonner
							à vos réalisateurs, séries ou acteurs préférés. Vous pourrez même
							retrouver des réalisations inédites à ShootMovie et introuvable
							autre part sur internet !</p>
						<center><b>Vous êtes passioné de cinéma ou vous réalisez des courts-métrages ?<br>Alors <a href="inscription.html">rejoignez-nous</a>, c'est grauit !</b></center>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Nous contacter</div>
					<div class="panel-body">
						<a href="mailto:romain.hembert@gmail.com" role="button"
							class="btn btn-info btn-block">Nous contacter</a>
						<button type="button" class="btn btn-default btn-block"
							data-toggle="modal" data-target="#a-propos">A propos</button>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div class="modal fade" id="a-propos" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">ShootMovie</h4>
				</div>
				<div class="modal-body">
					<center style="color: red; font-weight: bold;">STILL IN
						DEVLOPMENT</center><br>
					<p>Projet réalisé lors de la semaine d'Agilité.</p>
					Equipe :
					<ul>
						<li>DALENCOURT Alex</li>
						<li>DECOCK Alexis</li>
						<li>GHESQUIERE Jérôme</li>
						<li>HEMBERT Romain</li>
						<li>MIGAN Karen</li>
						<li>REGNIER Camille</li>
						<li>ZAROURI Mohamed</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
