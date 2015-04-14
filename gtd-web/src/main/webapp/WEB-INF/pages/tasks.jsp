<%@include file="common/header.jsp" %>
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

<%@include file="common/footer.jsp" %>
