<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="NoticiaServlet" method="post">
	<input type="hidden" name="codigo" value="${noticia.id}"> 
	<input type="hidden" name="opcao" value="editar"> 
		Titulo: <input type="text" name="titulo" value="${noticia.titulo}"> 
		<br> Texto: <input name="texto" value="${noticia.texto}">
		 <br> <input type="submit" value="ok">
	</form>
</body>
</html>