<%@include file="common/header.jsp"%>
<div class="inline form-group">
	<table>
		<tr>
			<th><div class="form-group">Project</div></th>
			<th><div class="form-group">Task</div></th>
			<th><div class="form-group"></div></th>
		</tr>
		<c:forEach var="task" items="${tasks}">
			<tr>
				<td><div class="inline form-group">
						<c:out value="${task.project.name}" />
					</div></td>
				<td><div class="inline form-group">
						<c:out value="${task.name}" />
					</div></td>
				<td><div class="inline form-group">
						<form:form method="GET" action="editTask">
							<input type="hidden" name="taskId" value="${task.id}" />
							<button type="submit" class="action">Edit</button>
						</form:form>
					</div></td>
			</tr>
		</c:forEach>
	</table>
	<div class="block">
		<button type="submit" name="newProject">New Project</button>
		<button type="submit" name="newTask" class="blue">New Task</button>
	</div>
</div>
<%@include file="common/footer.jsp"%>
