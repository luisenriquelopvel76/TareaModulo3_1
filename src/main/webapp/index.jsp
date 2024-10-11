<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio Del Juego</title>
</head>
<body>
<h2>Bienvenido al Juego de Preguntas</h2>
<form action="JuegoServlet" method="get">
    <label for="nombre">Ingresa tu nombre:</label>
    <input type="text" id="nombre" name="nombre" required>
    <input type="hidden" name="nuevoJuego" value="true">
    <button type="submit">Comenzar Juego</button>
</form>
</body>
</html>