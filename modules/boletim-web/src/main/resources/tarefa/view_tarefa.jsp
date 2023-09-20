<%@ include file="../init.jsp"%>

<div class="container-fluid-1280">

	<h1>${tarefa.title}</h1>

	<h2><liferay-ui:message key="tarefa-information" /></h2>

	<div class="tarefa-metadata">

		<dl>
			<dt><liferay-ui:message key="created" /></dt>
			<dd>${createDate}</dd>

			<dt><liferay-ui:message key="created-by" /></dt>
			<dd>${tarefa.userName}</dd>

			<dt><liferay-ui:message key="tarefa-duedate" /></dt>
			<dd>${dueDate}</dd>

			<dt><liferay-ui:message key="description" /></dt>
			<dd>${tarefa.description}</dd>
		</dl>
	</div>
</div>