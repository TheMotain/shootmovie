<!DOCTYPE html>
<html lang="fr">
<head>
<title>ShootFilm - Titre de la vidï¿½o</title>
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
	<%@ include file="/elements/menu.jsp"%>
	<!-- ----------------- FIN MENU HAUT ------------------- -->

	<div class="container">
		<div class="video-player">
			<iframe width="100%;" height="620"
				src="<%String url = (String) request.getAttribute("url");
			out.print(url);%>"
				frameborder="0" allowfullscreen></iframe>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<%
					String titre = (String) request.getAttribute("titre");
					out.print(titre);
				%>
			</div>
			<div class="panel-body">
				<p>Synopsis :</p>
				<p>
					<%
						String description = (String) request.getAttribute("description");
						out.print(description);
					%>
				</p>
				<p>
					Date Upload :
					<%
					String date = (String) request.getAttribute("date");
					out.print(date);
				%>
				</p>
				<p>
					Realisateur :
					<%
					String realisateur = (String) request.getAttribute("realisateur");
					out.print(realisateur);
				%>
				</p>
				<p>
					Note :
					<%
					Double note = (Double) request.getAttribute("note");
					out.print(note);
				%>
				<%
					Integer log = (Integer) request.getAttribute("log");
					if (log == 1) {
				%>
				</p>
				<p>Noter la vidéo:
				<form action="/setNote?id=<%out.print(request.getParameter("id"));%>"
					method="post" class="form-horizontal">
					<input type="range" name="note" min="0" max="5" value="<%Integer vote = (Integer) request.getAttribute("vote");
					out.print(note);%>" step="1"
						onchange="showValue(this.value)"> <span id="range"><%out.print(note);%></span>
					<input type="submit" value="Noter">
				</form>
				</p>
				<%
				}
				%>
				<p>Vues : <%out.print(request.getAttribute("compteur")); %>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<span id="realisateur"></span>
					</div>
					<div class="panel-body">Contenu</div>
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
							if (!tmp[0].equals("")) {
								for (int i = 0; i < tmp.length; i++) {
									tmp2 = tmp[i].split(" ");
						%>
						<div class="commentaire-box">
							<div class="row">
								<div class="col-md-2">
									<img src="http://placehold.it/100x100" /> <a href="#"> <%
 									out.print(tmp2[0]);
 									%>
									</a><br>
								</div>
								<div class="col-md-10">
									<span class="commentaire-date">Postï¿½ le <%
										out.print(tmp2[2] + " ï¿½ " + tmp2[3]);
									%></span><br>
									<p>
										<%
											out.print(tmp2[1]);
										%>
									</p>
								</div>
							</div>
							<hr>
						</div>
						<%
							}
							}
						%>

						<!-- Fin de rï¿½pï¿½tition -->

						<%
							if (log == 1) {
						%>
						<form
							action="/setCommentaire?id=<%out.print(request.getParameter("id"));%>"
							method="post" class="form-horizontal">
							<textarea id="textarea" rows="5" class="form-control"
								placeholder="Commentez la vidï¿½o ..." name="comm"></textarea>
							<br> <input type="submit" class="btn btn-block btn-default"
								value="Poster" />
						</form>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function showValue(newValue) {
			document.getElementById("range").innerHTML = newValue;
		}
	</script>
</body>
</html>

