<%@include file="common/header.jsp"%>
<span class="current">${task.project.name}</span>
<c:url var="editUrl" value="/gtd-web/editTask${sessionScope.task.id}" />
<form:form method="POST" action="${editUrl}" modelAttribute="sessionScope.task">
	<div class="form-group">
		<label for="sampleTextArea">Name</label>
		<textarea id="sampleTextArea" rows="1">${sessionScope.task.name}</textarea>
		<button type="submit" class="blue">Save</button>
	</div>
</form:form>
<div class="inline form-group">
	<button>New Project</button>
	<button>Delete</button>
</div>
<%@include file="common/footer.jsp"%>
