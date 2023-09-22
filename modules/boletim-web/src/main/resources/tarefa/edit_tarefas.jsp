<%@ include file="../init.jsp"%>

<%-- Generate add / edit action URL and set title. --%>

<c:choose>
	<c:when test="${not empty tarefa}">
		<portlet:actionURL var="tarefaActionURL" name="<%=MVCCommandNames.EDIT_TAREFA %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="edit-assignment"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="tarefaActionURL" name="<%=MVCCommandNames.ADD_TAREFA %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="add-assignment"/>
	</c:otherwise>
</c:choose>

<div class="container-fluid-1280 edit-assignment">

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${tarefa}" model="${tarefaClass}" />

	<aui:form action="${tarefaActionURL}" name="fm">

		<aui:input name="tarefaId" field="tarefaId" type="hidden" />

		<div class="sheet"><div class="panel-group panel-group-flush">

			<aui:fieldset>

				<%-- Title field. --%>

				<aui:input name="titulo">

				</aui:input>

				<%-- Description field. --%>

				<aui:input name="descricao">
					<aui:validator name="required" />
				</aui:input>

				<%-- Due date field. --%>

				<aui:input name="dataFinal">
					<aui:validator name="required" />
				</aui:input>
			</aui:fieldset>
		</div></div>

		<%--Buttons. --%>

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

</div>