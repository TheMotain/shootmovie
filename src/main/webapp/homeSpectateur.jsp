<!DOCTYPE html>
<html lang="fr">
<head>
<title>ShootFilm - Home</title>
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
		<%
			String user = (String) request.getAttribute("user");
			out.println(user);
		%>
	</div>
</body>
</html>
