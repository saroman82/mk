<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Página de Catalogos</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Añade un Catalogo
</h1>

<c:url var="addAction" value="/muestrarios/crea" ></c:url>

<form:form action="${addAction}" commandName="muestrario">
<table>
	<c:if test="${!empty muestrario.ruta}">
	<tr>
		<td>
			<form:label path="id_qr">
				<spring:message text="id_qr"/>
			</form:label>
		</td>
		<td>
			<form:input path="id_qr" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id_qr" />
		</td> 
	</tr>
	</c:if>
	
	<tr>
		<td>
			<form:label path="id_proveedor">
				<spring:message text="id_proveedor"/>
			</form:label>
		</td>
		<td>
			<form:input path="id_proveedor" />
		</td>
	</tr>

        <tr>
		<td>
			<form:label path="tipo_mueble">
				<spring:message text="Tipo"/>
			</form:label>
		</td>
		<td>
			<form:input path="tipo_mueble" />
		</td> 
	</tr>
        
        <tr>
		<td>
			<form:label path="ruta">
				<spring:message text="Ruta"/>
			</form:label>
		</td>
		<td>
			<form:input path="ruta" />
		</td>
	</tr>
          
	<tr>
		<td colspan="2">
			<c:if test="${!empty muestrario.ruta}">
				<input type="submit"
					value="<spring:message text="Edita"/>" />
			</c:if>
			<c:if test="${empty muestrario.ruta}">
				<input type="submit"
					value="<spring:message text="Crea"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de Catalogos</h3>
<c:if test="${!empty listaMuestrarios}">
	<table class="tg">
	<tr>
		<th width="80">Id Cata</th>
		<th width="120">Id proveedor</th>
		<th width="120">Tipo mueble</th>
                <th width="120">Ruta</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listaMuestrarios}" var="muestrario">
		<tr>
			
			<td>${muestrario.id_qr}</td>
                        <td>${muestrario.id_proveedor}</td>
			<td>${muestrario.tipo_mueble}</td>
                        <td>${muestrario.ruta}</td>
                        <td>
                        <form action="qrservlet" method="get">
                            <input name="qrtext" type="hidden" value="${muestrario.ruta}">
                         <input value="Generate QR Code" type="submit">
                        </form>
                         </td>
			<td><a href="<c:url value='/muestrarios/edita/${muestrario.id_qr}' />" >Edita</a></td>
			<td><a href="<c:url value='/muestrarios/elimina/${muestrario.id_qr}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
