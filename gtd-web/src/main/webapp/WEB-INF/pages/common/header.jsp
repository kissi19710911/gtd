<?xml version="1.0" encoding="US-ASCII" ?>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<html>
<head>
<spring:url value="https://ssl.gstatic.com/docs/script/css/add-ons1.css"
	var="resourceUrl" />
<link media="screen" rel="stylesheet" href="${resourceUrl}"
	type="text/css" />
<title>Getting Things Done</title>
<script type="text/javascript">
debugger;
	function setSessionAttribute() {
		var taskId = parseInt(document.taskForm.task.id.value);
		session.setAttribute("taskId", taskId);
		return true;
	}
</script>

</head>
<body>