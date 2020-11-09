<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<div class="col-3">
	<div class="operazioni" style="width: 100%;">
		<div class="title"
			style="color: white; font-size: large; font-weight: 700; background-color: cadetblue; text-align: center; border-radius: 10px;">
			<p>Operazioni disponibili</p>
		</div>
		<c:set var="parametro" value="${requestScope.param}" scope="request"></c:set>
		<div class="listaOperazioni">
			<ul>
				<c:choose>
					<c:when test="${parametro=='0'}">
						<li class="op"><a href="CrudController/insertIndex">Inserimento Libro</a></li>
						<li class="op"><a href="CrudController/updateIndex">Modifica Libro</a></li>
						<li class="op"><a href="CrudController/deleteIndex">Eliminazione Libro</a></li>
					</c:when>
					<c:otherwise>
						<li class="op"><a href="insertIndexAuth">Inserimento Autore</a></li>
						<li class="op"><a href="updateIndex">Modifica Autore</a></li>
						<li class="op"><a href="deleteIndex">Eliminazione Autore</a></li>
					</c:otherwise>
				</c:choose>
				<li class="op"><a href="SearchController/searchIndex">Ricerca</a></li>
			</ul>
		</div>
	</div>


</div>