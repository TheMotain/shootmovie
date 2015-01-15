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
      <a class="navbar-brand" href="/shootmovie">ShootMovie</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/shootmovie">Accueil <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Réalisations</a></li>
        <li><a href="#">Séries</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Espace Membres <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><button type="button" class="btn btn-link"
							data-toggle="modal" data-target="#connexion">Se connecter</button></li>
            <li><button type="button" class="btn btn-link"
							data-toggle="modal" data-target="#inscription">S'inscrire</button></li>
			<li><a href="signout">Déconnexion</a></li>
            <li class="divider"></li>
            <li><a href="#">Mot de passe perdu ?</a></li>
            <li class="divider"></li>
            <li><a href="myProfil">Profil</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="modal fade" id="connexion" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">Connexion</h4>
				</div>
				<div class="modal-body">
					<form action='signin' method='post' class="form-horizontal">
							<div class="form-group">
								<input type='text' style="width:370px;margin-left:15px" class="form-control" name='login' placeholder="Login"><br>
							</div>
							<div class="form-group">
								<input type='password' style="width:370px;margin-left:15px" class="form-control" name='mdp' placeholder="Mot de passe"><br>
							</div>
							<input class="btn btn-block btn-default" type='submit' value='Se connecter'>
						</form>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="inscription" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">Inscription</h4>
				</div>
				<div class="modal-body">
					<form action='signup' method='get' class="form-horizontal">
							<div class="form-group">
								<input type='text' style="width:370px;margin-left:15px" class="form-control" name='login' placeholder="Login"><br>
							</div>
							<div class="form-group">
								<input type='password' style="width:370px;margin-left:15px" class="form-control" name='mdp' placeholder="Mot de passe"><br>
							</div>
							<input class="btn btn-block btn-default" type='submit' value="S'inscrire">
						</form>
				</div>
			</div>
		</div>
	</div>