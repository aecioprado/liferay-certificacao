<%@ include file="init.jsp"%>
<liferay-ui:error key="serviceErrorDetails">
		<liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.assignment-service-error" />
</liferay-ui:error>
<liferay-ui:success key="assignmentAdded" message="assignment-added-successfully" />
<liferay-ui:success key="assignmentUpdated" message="assignment-updated-successfully" />
<liferay-ui:success key="assignmentDeleted" message="assignment-deleted-successfully" />

<%
TarefasManagementToolbarDisplayContext tarefasManagementToolbarDisplayContext = new TarefasManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request);
%>


<div class="container-fluid-1280">

<div>
<h1><liferay-ui:message key="Tarefas" /></h1>
	<clay:management-toolbar
		disabled="${tarefasCount eq 0}"
		displayContext="<%= tarefasManagementToolbarDisplayContext %>"
		itemsTotal="${tarefasCount}"
		searchContainerId="tarefasEntries"
		selectable="false"
	/>
</div>
</div>