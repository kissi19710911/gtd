<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" tagdir="c"%>
<!DOCTYPE html>
<html>
<body>
<table>
  <c:forEach items="${task}" var="item">
    <tr>
      <td><c:out value="${item.project.name}" /></td>
      <td><c:out value="${item.name}" /></td>
      <td><form><input type = "hidden" name = "id" value = "x" /> <input type="button"/></form></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
