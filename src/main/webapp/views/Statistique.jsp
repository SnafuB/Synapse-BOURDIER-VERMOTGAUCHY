<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Synapse Gaming | Forum</title>
    <!-- Meta -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- CSS -->
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/header.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/menu.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/stats.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/news.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/slider.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/forum.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/footer.css" />">
    <!-- JS -->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.0.3.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/menu.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/forum_events.js" />"></script>
</head>
<body>
<div id="page-wrapper">
	<div id="header-wrapper">
		<jsp:include page="portal/Header.jsp"/>
	</div>
	<div id="persistent-menu-wrapper">
		<jsp:include page="portal/PersistentMenu.jsp"/>
	</div>
	<div id="menu-wrapper">
		<jsp:include page="portal/Menu.jsp"/>
	</div>
	<div id="news-wrapper">
		<jsp:include page="portal/News.jsp"/>
	</div>
	<div id="stats-wrapper">
		<div id="stats-container">
			<c:if test="${ empty user || user.mail == null }">
				<div id="forum-info" class="info">Vous devez être identifié pour accèder aux statistiques ! <a href="<c:url value="/user/signin"/>">Se connecter</a>.</div>
			</c:if>
			<br/>
			<div id="stats">
			
			<table class="table-stats">
		     	<caption><h2>Les Classes les plus jouées</h2></caption>
		     		<thead>
			     		<tr>
			     			<th>
				     			Classe
				     		</th>
				     		<th>
				     			Nombre de personnes
				     		</th>
				     	</tr>
		     		</thead>
		     		<tbody>
					<div class="MostPlayedClasses">
						<c:forEach items="${mostPlayedClasses}" var="classMost">
				     		<tr>
					     		<td>
					     			${classMost.key}
					     		</td>
					     		<td>
					     			${classMost.value}
					     		</td>
				     		</tr>
						</c:forEach>
					</div>
					</tbody>
		     </table>
		     <hr></hr>
		     
		     <table class="table-stats">
		     	<caption><h2>Les Races les plus jouées</h2></caption>
		     		<thead>
			     		<tr>
			     			<th>
				     			Races
				     		</th>
				     		<th>
				     			Nombre de personnes
				     		</th>
				     	</tr>
		     		</thead>
		     		<tbody>
					<div class="mostPlayedRaces">
						<c:forEach items="${mostPlayedRaces}" var="raceMost">
				     		<tr>
					     		<td>
					     			${raceMost.key}
					     		</td>
					     		<td>
					     			${raceMost.value}
					     		</td>
				     		</tr>
						</c:forEach>
					</div>
					</tbody>
		     </table>
		     <hr></hr>
		     
		     <table class="table-stats">
		     	<caption><h2>Les Specialisations les plus utilisées</h2></caption>
		     		<thead>
			     		<tr>
			     			<th>
				     			Spécialisations
				     		</th>
				     		<th>
				     			Nombre de personnes
				     		</th>
				     	</tr>
		     		</thead>
		     		<tbody>
					<div class="mostPlayedRaces">
						<c:forEach items="${mostPlayedSpecializations}" var="speMost">
				     		<tr>
					     		<td>
					     			${speMost.key}
					     		</td>
					     		<td>
					     			${speMost.value}
					     		</td>
				     		</tr>
						</c:forEach>
					</div>
					</tbody>
		     </table>
		     <hr></hr>
		     
		     <table class="table-stats">
		     	<caption><h2>Les Utilisateurs sans avatar</h2></caption>
		     		<thead>
			     		<tr>
			     			<th>
				     			Utilisateurs
				     		</th>
				     		<th>
				     			Avatar
				     		</th>
				     	</tr>
		     		</thead>
		     		<tbody>
					<div class="Users">
						<c:forEach items="${usersWithoutAvatar}" var="userWithoutAvatar">
				     		<tr>
					     		<td>
					     			${userWithoutAvatar.name}
					     		</td>
					     		<td>
					     			<img src="${userWithoutAvatar.forumAvatar}" alt="${userWithoutAvatar.name}" />
					     		</td>
				     		</tr>
						</c:forEach>
					</div>
					</tbody>
		     </table>
		     <hr></hr>
		     
		     
		     <table class="table-stats">
		     	<caption><h2>Les Utilisateurs les plus actifs</h2></caption>
		     		<thead>
			     		<tr>
			     			<th>
				     			Utilisateurs
				     		</th>
				     		<th>
				     			Points
				     		</th>
				     	</tr>
		     		</thead>
		     		<tbody>
					<div class="Users">
						<c:forEach items="${mostActiveUsers}" var="mostActiveUsers">
				     		<tr>
					     		<td>
					     			${mostActiveUsers.key}
					     		</td>
					     		<td>
					     			${mostActiveUsers.value}
					     		</td>
				     		</tr>
						</c:forEach>
					</div>
					</tbody>
		     </table>
		     <hr></hr>
		     
		     
			</div>
		</div>
	</div>
	<div id="footer-wrapper">
		<jsp:include page="portal/Footer.jsp"/>
	</div>
</div>
</body>
</html>