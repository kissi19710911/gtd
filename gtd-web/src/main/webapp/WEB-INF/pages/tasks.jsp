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
						<form>
							<input type="hidden" name="task.id" value="${task.id}" />
							<button class="action">Edit</button>
						</form>
					</div></td>
			</tr>
		</c:forEach>
	</table>
	<div class="block">
		<button>New Project</button>
		<button class="blue">New Task</button>
	</div>
</div>
<%@include file="common/footer.jsp"%>
