<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Juego Terminado</title>
</head>
<body>
<h2>Juego Terminado</h2>

<!-- mostrar el mensaje final -->
<c:if test="${not empty mensajeFinal}">
    <p>${mensajeFinal}</p>
</c:if>

<!-- mostrar el progreso del jugador -->
<p>Has respondido correctamente <strong>${progreso}</strong> preguntas.</p>

<!-- botón para iniciar un nuevo juego -->
<form action="index.jsp" method="get">
    <button type="submit">Jugar de nuevo</button>
</form>
</body>
</html>
