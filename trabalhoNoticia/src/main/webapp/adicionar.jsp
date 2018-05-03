<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Notícia</title>
</head>
<body>
<a href="NoticiaServlet?opcao=listar" style="float: right">voltar a lista</a>
	<img alt="" src="https://png.pngtree.com/thumb_back/fw800/back_pic/03/89/91/4157daaf5291cad.jpg">
	<hr>
	<form action="NoticiaServlet" method="post">
	<input type="hidden" name="opcao" value="adicionar"> 
		Titulo: <input type="text" name="titulo" value="${noticia.titulo}"> <br>
		<br> Texto: <br> <textarea name="texto" value="${noticia.texto}"></textarea>
		 <br> <input type="submit" value="ok" style="border-radius: 100%">
	</form>
</body>
</html>