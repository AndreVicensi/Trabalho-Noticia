<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${noticia.titulo}</h1>
	<p>${noticia.texto}</p>
	
	---------------------------------------
	<br>
	<br>
	<table>
		<tr>
			<td>Autor</td>
			<td>Texto</td>
		</tr>
		<c:forEach var="comentario" items="${noticia.comentarios}">
		<tr>
			<td>${comentario.autor}</td>
			<td>${comentario.texto}</td>
		</tr>	
		</c:forEach>
	</table>
	<br>
	<br>
	
	<form action="ComentarioServlet" method="post">
	<input type="hidden" value="${param.noticia.id}" name="id">
		Autor: <input type="text" name="autor">
   <br> Comentario: <input name="comentario"> 
		 <br> <input type="submit" value="ok">
	</form>
	
	

</body>
</html>