<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Juego De Preguntas</title>
</head>
<body>
<h2>Pregunta para <c:out value="${sessionScope.jugador.nombre}"/></h2>

<form action="JuegoServlet" method="post">
  <p><c:out value="${pregunta.texto}"/></p>


  <c:forEach var="opcion" items="${pregunta.opciones}" varStatus="status">
    <input type="radio" name="respuesta" value="${status.index + 1}" required>
    <label><c:out value="${opcion}"/></label><br>
  </c:forEach>

  <button type="submit">Enviar</button>
</form>
</body>
</html>
