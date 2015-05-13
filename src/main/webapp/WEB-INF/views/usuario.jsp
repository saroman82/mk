<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Página de Usuarios</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Añade un Usuario
</h1>
     <form action="qrservlet" method="get">
        <p>Enter Text to create QR Code</p>
        <input name="qrtext" type="text">
        <input value="Generate QR Code" type="submit">
    </form>

<c:url var="addAction" value="/usuario/crea" ></c:url>

 

<form:form action="${addAction}" commandName="usuario">
<table>
	<c:if test="${!empty usuario.nombre}">
	<tr>
		<td>
			<form:label path="id_user">
				<spring:message text="id_user"/>
			</form:label>
		</td>
		<td>
			<form:input path="id_user" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id_user" />
		</td> 
	</tr>
	</c:if>
	
	<tr>
		<td>
			<form:label path="login">
				<spring:message text="Login"/>
			</form:label>
		</td>
		<td>
			<form:input path="login" />
		</td>
	</tr>

        <tr>
		<td>
			<form:label path="nombre">
				<spring:message text="Nombre"/>
			</form:label>
		</td>
		<td>
			<form:input path="nombre" />
		</td> 
	</tr>
        
        <tr>
		<td>
			<form:label path="apellidos">
				<spring:message text="Apellidos"/>
			</form:label>
		</td>
		<td>
			<form:input path="apellidos" />
		</td>
	</tr>
          <tr>
		<td>
			<form:label path="pass">
				<spring:message text="Pass"/>
			</form:label>
		</td>
		<td>
			<form:input path="pass" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty usuario.nombre}">
				<input type="submit"
					value="<spring:message text="Edita Usuario"/>" />
			</c:if>
			<c:if test="${empty usuario.nombre}">
				<input type="submit"
					value="<spring:message text="Crea Usuario"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de Usuarios</h3>
<c:if test="${!empty listaUsuarios}">
	<table class="tg">
	<tr>
		<th width="80">Id Usuario</th>
		<th width="120">Login Usuario</th>
		<th width="120">Pass Usuario</th>
                <th width="120">Nombre Usuario</th>
                <th width="120">Apellido Usuario</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listaUsuarios}" var="usuario">
		<tr>
			
			<td>${usuario.login}</td>
                        <td>${usuario.nombre}</td>
			<td>${usuario.apellidos}</td>
			<td><a href="<c:url value='/edita/${usuario.id_user}' />" >Edita</a></td>
			<td><a href="<c:url value='/elimina/${usuario.id_user}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
