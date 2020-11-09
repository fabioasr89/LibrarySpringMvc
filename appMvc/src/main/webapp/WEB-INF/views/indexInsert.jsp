<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<style>
	label{
		    font-size: larger;
    		color: white;
    		font-weight: 500;
	}
	hr{
		color:white;
	}
</style>
<c:set var="allAutori" value="${requestScope.allAutori}"></c:set>
<c:set var="allGeneri" value="${requestScope.allGeneri}"></c:set>
	
	<div class="container modulTitolo">
		<hr>
		<p>Modulo inserimento libro</p>
		<hr>
	</div>
	<div class="col-9" style="width:100%;">
		<form:form action="insertEnd" method="POST" class="insert" id="insert" modelAttribute="libroForm" enctype="multipart/form-data">
			<div class="form-group">
					<div class="col-9">
						<label>Titolo</label>
					</div>
					<div class="col-9">
						<form:input path="titolo" cssClass="form-control" />
					</div>
					<div class="col-9">
						<label>Anno</label>
					</div>
					<div class="col-9">
						<form:input path="pubblicazione" cssClass="form-control" id="datePicker" />
					</div>
					<div class="col-9">
						<label>Autori</label>
					</div>
					<div class="col-9">
						<form:select path="autori" multiple="true" cssStyle="width:100%;">
							<form:option value="-1" label="Seleziona uno o più autori"/>
							<c:forEach var="gend" items="${allAutori}">
								<option value="${gend.idAutore}">${gend.descr}</option>
							</c:forEach>
						</form:select>
					</div>	
					<div class="col-9">
						<label>Generi</label>
					</div>
					<div class="col-9">
						<form:select path="genere" multiple="true" cssStyle="width:100%;">
							<form:option value="-1" label="Seleziona uno o più generi"/>
							<c:forEach var="gend" items="${allGeneri}">
								<option value="${gend.idGenere}">${gend.genere}</option>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-9">
						<label>Inserisci un'immagine di copertina</label>
					</div>
					<div class="col-9">
						<input type="file" name="fileUpload" class="form-control">
					</div>
					<div class="col-12">
						<div class="col-3"></div>
						<div class="col-9">
						<button class="btn btn-primary" id="btnInsertLibro" style="float:right;margin-top:2vh;">Inserisci</button>
						</div>
					</div>
			</div>
		</form:form>
	</div>

<script>
	$(document).ready(function(){
		$('#datePicker').datepicker();
		function valida(){
			
		}
		$('#btnInsertLibro').click(function(){
			
			
		});
		
	});

</script>