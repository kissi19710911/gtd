<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Tasks</title>
</head>
<body>
<table>
  <c:forEach var="task" items="${tasks}">
    <tr>
      <td><c:out value="${task.project.name}" /></td>
      <td><c:out value="${task.name}" /></td>
      <td><form><input type = "hidden" name = "model.task.id" value = "x" /> <input type="button"/></form></td>
    </tr>
  </c:forEach>
</table>
</body></html>
