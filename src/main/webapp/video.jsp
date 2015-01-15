<!DOCTYPE html>
<html lang="fr">
	<head>
		<title>ShootFilm - Titre de la vidéo</title>
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
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">ShootMovie</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="index.html">Accueil <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="#">Vidéos</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Espace Membres <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="login.html">Connexion</a></li>
            <li><a href="#">Inscription</a></li>
            <li class="divider"></li>
            <li><a href="#">Mot de passe perdu ?</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- ----------------- FIN MENU HAUT ------------------- -->

	<div class="container">
	<div class="video-player">
					<iframe width="100%;" height="620" src="<%
					String url = (String) request.getAttribute("url");
					out.print(url);
					%>" frameborder="0" allowfullscreen></iframe>
				</div>
		<div class="panel panel-default">
			<div class="panel-heading"><%
			String titre = (String) request.getAttribute("titre");
			out.print(titre);
			%></div>
			<div class="panel-body">
				<p>Synopsis :</p>
				<p><%String description = (String) request.getAttribute("description");
				out.print(description);
				%></p>
				<p>Date Upload : <%
				String date = (String) request.getAttribute("date");
				out.print(date);
				%></p>
				<p>Realisateur : <%
				String realisateur = (String) request.getAttribute("realisateur");
				out.print(realisateur);
				%></p>
				<p>Note : <%
				Double note = (Double) request.getAttribute("note");
				out.print(note);
				%></p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4">
					<div class="panel panel-default">
					  <div class="panel-heading"><span id="realisateur"></span></div>
					  <div class="panel-body">
					    Contenu
					  </div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="panel panel-default">
					  <div class="panel-heading">Commentaires</div>
					  <div class="panel-body">
					  
					  <!-- A  rÃ©peter pour chaque commentaire -->
					  
					<%
						String coms = (String) request.getAttribute("commentaires");
						String tmp[] = coms.split("\\|");
						String tmp2[];
						if(!tmp[0].equals("")) {
						for(int i = 0; i < tmp.length; i++){
							tmp2 = tmp[i].split(" ");
					%>
					  <div class="commentaire-box">
					  	<div class="row">
					  		<div class="col-md-2">
					  			<img src="http://placehold.it/100x100" />
								<a href="#"><%
								out.print(tmp2[0]); %></a><br>
					  		</div>
					  		<div class="col-md-10">
					  			<span class="commentaire-date">Posté le <%
					  			out.print(tmp2[2]+" à "+tmp2[3]); %></span><br>
					  			<p><%
					  			out.print(tmp2[1]); %></p>
					  		</div>
					  	</div>
					  	<hr>
					  </div>
					  <%
					  }}
					  %>
					  
					  <!-- Fin de répétition -->
					  
					  	<form method="post" class="form-horizontal">
					    	<textarea id="textarea" rows="5" class="form-control" placeholder="Commentez la vidéo ..." name="comm"></textarea><br>
   							<input type="button" class="btn btn-block btn-default" id="boutonaffi" value="Afficher"/>
   						</form>
					  </div>
					</div>
				</div>
				
			</div>

		<script type="text/javascript">
			
			$("#boutonaffi").click(function() {
				msg = $("#textarea").val();
				alert(msg);
				});

			modificationVariables();
		</script>
	</div>
	</body>
</html>

