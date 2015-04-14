<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<spring:url value="/resources/stylesheet.css" var="resourceUrl"/>
<link media="screen" rel="stylesheet" href="${resourceUrl}" type="text/css" />
<title>Tasks</title>
</head>
<body>
	<table class="listing">
		<tr>
			<th>Project</th>
			<th>Task</th>
			<th>Edit</th>
		</tr>
		<c:forEach var="task" items="${tasks}">

			<tr>
				<td><c:out value="${task.project.name}" /></td>
				<td><c:out value="${task.name}" /></td>
				<td><form>
						<input type="hidden" name="task.id" value="${task.name}" /> <input
							type="button" />
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
