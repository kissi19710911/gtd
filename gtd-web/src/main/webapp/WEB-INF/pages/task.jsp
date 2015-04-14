<%@include file="common/header.jsp"%>
<span class="current">${task.project.name}</span>
<div class="form-group">
	<label for="sampleTextArea">Name</label>
	<textarea id="sampleTextArea" rows="1">${task.name}</textarea>
</div>

<div class="block">
	<button>New Project</button>
	<button class="blue">Save</button>
	<button class="blue">Delete</button>
</div>
<%@include file="common/footer.jsp"%>
