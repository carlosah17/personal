<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.cie.ordenadores.Ordenador"%>

<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%
	List<Ordenador> lista=(List<Ordenador>) request.getAttribute("lista");
	

	
	%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<div class="container">

		<table class="table table-striped table-hover">
			<thead>
				<tr class="table-primary">
					<th><a href="?orden=marca">Marca</a></th>
					<th><a href="?orden=precio">Precio</a></th>
					<th>Borrar</th>
				</tr>
			</thead>

			<%
			for (Ordenador o : lista) {
			%>
			<!-- este es una fila -->
			<tr>
				<!-- este es una columna o fila -->
				<td><%=o.getMarca()%></td>
				<td><%=o.getPrecio()%></td>
				<td><a href="?comando=borrarordenador&marca=<%=o.getMarca()%>"
		class="btn btn-danger">borrar</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<!-- a es un enlace a otra pagina -->
		<!-- lleva una propiedad href con la pagina de destino y un texto -->
		<a href="?comando=formularioordenadores">insertar</a>
		</div>
</body>
</html>