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

<%
// Certifique-se de que o objeto tarefasCount esteja disponível no escopo de solicitação
long tarefasCount = (long) request.getAttribute("tarefasCount");
%>

<!-- Use a interpolação para imprimir o valor do objeto no console -->
<%= "tarefasCount=" + tarefasCount %>

<%
System.out.println("tarefasCount="+tarefasCount);
System.out.println("request="+request);
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

	<%-- Search container. --%>

    	<liferay-ui:search-container
    		emptyResultsMessage="no-assignments"
    		id="tarefaEntries"
    		iteratorURL="${portletURL}"
    		total="${tarefasCount}">

    		<liferay-ui:search-container-results results="${todasTarefas}" />

    		<liferay-ui:search-container-row
    			className="com.liferay.treinamento.boletim.model.Tarefa"
    			modelVar="entry">

    			<liferay-ui:search-container-column-text property="tarefaId" />
    			<liferay-ui:search-container-column-text property="userName" />
    			<liferay-ui:search-container-column-text property="titulo" />
    			<liferay-ui:search-container-column-text property="descricao" />
    			<liferay-ui:search-container-column-text property="dataFinal" />

    		</liferay-ui:search-container-row>

    		<%-- Iterator / Paging --%>

    		<liferay-ui:search-iterator />
    	</liferay-ui:search-container>

</div>
</div>