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
		<img src="http://placehold.it/1170x200" class="banniere" />
		<div class="panel panel-default header-profil" style="padding: 0">
			<div class="row">
				<div class="col-md-2">
					<img src="http://placehold.it/150x150" class="photo-profil img-circle" />
				</div>
				<div class="col-md-8" style="margin-top: 10px;">
					<span class="pseudo"><%
							String param = (String) request.getAttribute("name");
							out.println(param);
						%></span><br> <span
						class="date-inscription">Inscrit le 23/09/2016</span><br>
					<p class="description">Montius Emissa industria intepesceret
						tribunos sint e qui nec Eusebium si increpabat conperissent
						ducitur ostendens orator hi qui Pittacas armorum et dilancinantium
						et conperissent concitatus ab si Epigonum dilancinantium
						cognomento ducitur spiritum increpabat conperissent ducitur
						Epigonum sint manus nequid ducitur dignitatem hi promittentes
						dignitatem si Epigonum res aliquotiens intepesceret Eusebius.</p>
				</div>
				<div class="col-md-2" style="margin-top: 10px;padding-right:10px;">
					
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">Ses réalisations</div>
					<div class="panel-body">
						Une liste de vidéos
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Réseaux sociaux</div>
					<div class="panel-body">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
