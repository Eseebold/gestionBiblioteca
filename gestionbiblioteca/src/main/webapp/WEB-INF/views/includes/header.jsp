<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Biblioteca</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	type="text/css" rel="stylesheet" />

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-2.2.4.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body class="container">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!--       <a class="navbar-brand" href="#">Brand</a> -->
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value='/usuarios'/>">/usuarios</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>