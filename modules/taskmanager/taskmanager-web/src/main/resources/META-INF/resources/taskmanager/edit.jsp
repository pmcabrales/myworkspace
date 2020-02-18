<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.pmc.task.manager.model.Task"%>
<%@page import="com.pmc.task.manager.portlet.Priority"%>
<%@ include file="/init.jsp" %>


<portlet:actionURL var="saveTaskURL" name="saveTask"/>
<portlet:renderURL var="cancelURL" />

<liferay-ui:header backURL="${cancelURL}"  title="${title}" />

<liferay-ui:error key="ko-task-updated" message="ko-task-updated" />

<aui:model-context bean="${task}" model="<%= Task.class %>" />

<aui:form name="fm" action="${saveTaskURL}" method="post">

	<aui:input name="taskId" type="hidden" value="${task.taskId}"/>
	
	<div class="column_50">
		
		<aui:input name="name" label="name" value="${task.name}">
			<aui:validator name="required" errorMessage="field.required"></aui:validator>
		</aui:input>
		
		<aui:input name="description" type="textarea" value="${task.description}">
		</aui:input>
	
	
	</div>
	<div class="column_50">
	
		<aui:select name="prioritySel" label="task.priority" ignoreRequestValue="true">
			<c:forEach items="${priorities}" var="priority">
				<aui:option value="${priority}" label="<%=Priority.priority[Integer.parseInt(pageContext.getAttribute(\"priority\").toString())]%>" selected="${priority == task.priority}"/>
			</c:forEach>
		</aui:select>
		
		<aui:field-wrapper name="dueDate" label="task.due-date">
			<liferay-ui:input-date  dayParam="dueDateDay" monthParam="dueDateMon"
				 yearParam="dueDateYear"  yearValue="${dueDateYear}" monthValue="${dueDateMon}" dayValue="${dueDateDay}"></liferay-ui:input-date>	
		</aui:field-wrapper>
	
	</div>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>	
		<aui:button onClick="${cancelURL}"  type="cancel" />
	</aui:button-row>
</aui:form>