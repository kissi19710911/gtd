<%@include file="common/header.jsp"%>
<div class="form-group">
	<label for="sampleTextArea">Name</label>
	<textarea id="sampleTextArea" rows="1">"${task.name}"</textarea>
</div>
<div class="block">
	<button class="blue">Save</button>
	<button class="blue">Delete</button>
</div>
<%@include file="common/footer.jsp"%>
