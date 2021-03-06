<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">

	<div class="col-xs-12 col-sm-6">
		<form:form action="save" method="post" commandName="usuario">
				<c:if test="${!empty usuario }">
					<form:hidden path="codigo" />
				</c:if>
				<div class="form-group">
					<form:label path="nombre">
						<spring:message code="usuario.nombre" />:
				</form:label>
					<form:input path="nombre" cssClass="form-control" cssErrorClass="" />
					<form:errors cssClass="text-danger" path="nombre" />
				</div>
				<div class="form-group">
					<form:label path="apellidos">
						<spring:message code="usuario.apellidos" />:
				</form:label>
					<form:input path="apellidos" cssClass="form-control"
						cssErrorClass="" />
					<form:errors cssClass="text-danger" path="apellidos" />
				</div>
				<div class="form-group">
					<form:label path="fnacimiento">
						<spring:message code="usuario.fnacimiento" />:
				</form:label>
					<form:input path="fnacimiento" placeholder="dd/MM/yyyy"
						cssClass="form-control" cssErrorClass=""
						pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" />
					<form:errors cssClass="text-danger" path="fnacimiento" />
				</div>
				<div class="form-group">
					<form:label path="email">
						<spring:message code="usuario.email" />:
				</form:label>
					<form:input path="email" cssClass="form-control" cssErrorClass="" />
					<form:errors cssClass="text-danger" path="email" />
				</div>
				<div class="form-group">
					<form:label path="usernick">
						<spring:message code="usuario.usernick" />:
				</form:label>
					<form:input path="usernick" cssClass="form-control" cssErrorClass="" />
					<form:errors cssClass="text-danger" path="usernick" />
				</div>
				<div class="form-group">
					<form:label path="userpass">
						<spring:message code="usuario.userpass" />:
				</form:label>
					<form:input type="password" path="userpass" cssClass="form-control" cssErrorClass="" />
					<form:errors cssClass="text-danger" path="userpass" />
				</div>
				<div class="form-group">
					<a href="<c:url value='/usuarios'/>" class="btn btn-danger">ATRAS</a>
					<c:set var="msgBoton" value="CREAR" />
					<c:if test="${usuario.codigo > 0}">
						<c:set var="msgBoton" value="EDITAR" />
					</c:if>
					<button type="submit" class="btn btn-success">
						<spring:message text="${msgBoton}" />
					</button>
				</div>
		</form:form>
	</div>
</div>

</body>
</html>