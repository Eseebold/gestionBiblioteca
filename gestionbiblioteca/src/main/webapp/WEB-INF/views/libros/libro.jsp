<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">

	<div class="col-xs-12 col-sm-6">
		<form:form action="save" method="post" commandName="libro">
			<c:if test="${!empty libro }">
				<form:hidden path="codigo" />
			</c:if>
			<div class="form-group">
				<form:label path="titulo">
					<spring:message code="libro.titulo" />:
				</form:label>
				<form:input path="titulo" cssClass="form-control" cssErrorClass="" />
				<form:errors cssClass="text-danger" path="titulo" />
			</div>
			<div class="form-group">
				<form:label path="autor">
					<spring:message code="libro.autor" />:
				</form:label>
				<form:input path="autor" cssClass="form-control" cssErrorClass="" />
				<form:errors cssClass="text-danger" path="autor" />
			</div>
			<div class="form-group">
				<form:label path="isbn">
					<spring:message code="libro.isbn" />:
				</form:label>
				<form:input path="isbn" cssClass="form-control" cssErrorClass="" />
				<form:errors cssClass="text-danger" path="isbn" />
			</div>
			<div class="form-group">
				<a href="<c:url value='/libros'/>" class="btn btn-danger">ATRAS</a>
				<c:set var="msgBoton" value="CREAR" />
				<c:if test="${libro.codigo > 0}">
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