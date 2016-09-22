<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">

	<div class="col-xs-12 col-sm-6">
		<form:form action="save" method="post" commandName="ejemplar">
			<c:if test="${!empty ejemplar }">
				<form:hidden path="codigo" />
			</c:if>
			<div class="form-group">
				<form:label path="editorial">
					<spring:message code="ejemplar.editorial" />:
				</form:label>
				<form:input path="editorial" cssClass="form-control" cssErrorClass="" />
				<form:errors cssClass="text-danger" path="editorial" />
			</div>
			<div class="form-group">
				<form:label path="paginas">
					<spring:message code="ejemplar.paginas" />:
				</form:label>
				<form:input path="paginas" cssClass="form-control" cssErrorClass="" />
				<form:errors cssClass="text-danger" path="paginas" />
			</div>
			<div class="form-group">
				<a href="<c:url value='/ejemplars'/>" class="btn btn-danger">ATRAS</a>
				<c:set var="msgBoton" value="CREAR" />
				<c:if test="${ejemplar.codigo > 0}">
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