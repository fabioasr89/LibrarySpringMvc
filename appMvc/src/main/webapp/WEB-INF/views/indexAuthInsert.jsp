<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
	
	<div class="container modulTitolo">
		<hr>
		<p>Modulo inserimento Autore</p>
		<hr>
	</div>
	<div class="col-9" style="width:100%;">
		<c:if test="${requestScope.messageSuccess!=null}">
			<div class="successMessage" style="width:100%;background-color:green;color:white; font-weight:700;">
				<c:out value="${requestScope.messageSuccess}"></c:out>
			</div>
		</c:if>	
		<form:form action="insertIndexEndAuth" method="POST" class="insert"  modelAttribute="autoreBean">
			<div class="form-group">
					<div class="col-9">
						<label>Nome</label>
					</div>
					<div class="col-9">
						<form:input path="nome" cssClass="form-control" />
					</div>
					<div class="col-9">
						<label>Cognome</label>
					</div>
					<div class="col-9">
						<form:input path="cognome" cssClass="form-control" />
					</div>
					<div class="col-12">
						<div class="col-3"></div>
						<div class="col-9">
							<input type="submit" class="btn btn-primary" id="btnInsertAuth" style="float:right;margin-top:2vh;" value="Inserisci">
						</div>
					</div>
			</div>
		</form:form>
	</div>