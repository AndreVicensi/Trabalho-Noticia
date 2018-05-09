<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jornal</title>
</head>
<style type="text/css">
	ul {
		display: inline-block;
		list-style-type: none;
	}

 	ul li {
 		display: inline;
 		padding: 10px;
 	}
  </style>
<body>
	<ul>
	<li><a href="adicionar.jsp">adicionar noticia</a></li>
	</ul>
	<img alt="" src="https://jornalexpressaong.files.wordpress.com/2016/02/cropped-banner_jornal.jpg">
	<table>
		<tr>
			<th>Titulo</th>
		</tr>
		<c:forEach var="noticia" items="${noticias}">
		<tr>
			<td><a href="NoticiaServlet?
				opcao=carregar&codigo=${noticia.id}">${noticia.titulo}</a></td>  
		</tr>	
		</c:forEach>
	</table>
</body>
</html>