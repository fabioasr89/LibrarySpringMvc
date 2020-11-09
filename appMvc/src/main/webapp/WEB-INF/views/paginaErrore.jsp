<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page isELIgnored="false" %>
<div class="col-9">
	<c:if test="${requestScope.messageError!=null}">
		<div class="errorMessage" style="width:100%;background-color:red;color:white; font-weight:700;">
			<c:out value="${requestScope.messageError}"></c:out>
		</div>
	</c:if>	

</div>