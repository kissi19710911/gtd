<%@include file="common/header.jsp"%>
<%@ page session="true"%>
<div class="inline form-group">
	<table>
		<tr>
			<th><div class="form-group">Project</div></th>
			<th><div class="form-group">Task</div></th>
			<th><div class="form-group"></div></th>
		</tr>
		<c:forEach var="task" items="${relevantTasks.tasks}">
			<c:url var="editUrl" value="/editTask" />
			<form:form method="GET" name="taskForm" action="${editUrl}" modelAttribute="task" onSubmit="return setSessionAttribute()">
				<tr>
					<td><div class="inline form-group">
							<c:out value="${task.project.name}" />
						</div></td>
					<td><div class="inline form-group">
							<c:out value="${task.name}" />
						</div></td>
					<td><div class="inline form-group">
							<button type="submit" class="action">Edit</button>
						</div></td>
				</tr>
			</form:form>
		</c:forEach>
	</table>
	<div class="block">
		<button type="submit" name="newProject">New Project</button>
		<button type="submit" name="newTask" class="blue">New Task</button>
	</div>
</div>
<%@include file="common/footer.jsp"%>
