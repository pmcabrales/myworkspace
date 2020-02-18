<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.pmc.task.manager.portlet.Priority"%>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPViewTypeItemList" %>

<%@ include file="../init.jsp" %>

<liferay-ui:success key="ok-task-updated" message="ok-task-updated"/>
<liferay-ui:success key="ok-task-deleted" message="ok-task-deleted"/>
<liferay-ui:error key="ko-task-deleted" message="ko-task-deleted"/>

<portlet:renderURL var="newTaskURL">
	<portlet:param name="mvcPath" value="/taskmanager/edit.jsp" />	
	<portlet:param name="view" value="edit-view" />	
</portlet:renderURL>

<aui:button-row>
	<aui:button type="submit" value="new-task" onClick="${newTaskURL}"/>
</aui:button-row>

<clay:management-toolbar
	displayContext="${taskToolbarDisplayContext}"	
/>
<liferay-ui:search-container
			searchContainer="${searchContainer}"
			iteratorURL="${searchContainer.iteratorURL}" >
	<liferay-ui:search-container-results results="${searchContainer.results}"/>
		<liferay-ui:search-container-row className="com.pmc.task.manager.model.Task" keyProperty="taskId" modelVar="task">			
			
			<c:set var="accomplishedClass" value="not-accomplished"></c:set>
			<c:if test="${task.accomplished}">
				<c:set var="accomplishedClass" value="accomplished"></c:set>
			</c:if>
			
			<liferay-ui:search-container-column-text name="task.accomplished" cssClass="${accomplishedClass}">
				<portlet:actionURL var="toggleAccomplishedURL" name="toggleAccomplished">
					<portlet:param name="taskId" value="${task.taskId}"></portlet:param>
				</portlet:actionURL>
				<aui:a  href="<%= toggleAccomplishedURL.toString() %>">
					<c:choose>
						<c:when test="${task.accomplished}">
							<img src="<%=request.getContextPath()%>/img/checked.png" alt="true"/>
						</c:when>
						<c:otherwise>
							<img src="<%=request.getContextPath()%>/img/square.png" alt="false"/>
						</c:otherwise>	
					</c:choose>	
				</aui:a>		
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="task.name" orderable="true" orderableProperty="name" cssClass="${accomplishedClass}">			
				${task.name}
				<liferay-ui:icon image="view" toolTip="false" url="javascript:${renderResponse.getNamespace()}showDescription(description_${task.taskId });"/>
				<div class="popup" id="description_${task.taskId}" onClick="javascript:${renderResponse.getNamespace()}showDescription(description_${task.taskId });">
				  <span class="popuptext" id="myPopup">${task.description}</span>
				</div>  
			</liferay-ui:search-container-column-text>	
			<liferay-ui:search-container-column-text name="task.priority" orderable="true" orderableProperty="priority" cssClass="${accomplishedClass}">
				<%= Priority.priority[task.getPriority()] %>
			</liferay-ui:search-container-column-text>		
			<liferay-ui:search-container-column-text name="task.dueDate" orderable="true" orderableProperty="dueDate" cssClass="${accomplishedClass}">
				<fmt:formatDate pattern="MM-dd-yyyy" value="${task.dueDate}" />
			</liferay-ui:search-container-column-text>		
			<liferay-ui:search-container-column-text name="task.actions" cssClass="${accomplishedClass}">
				<liferay-ui:icon-menu>
					<portlet:renderURL var="editURL">
						<portlet:param name="taskId" value="${task.taskId}" />
						<portlet:param name="view" value="edit-view" />
						<portlet:param name="mvcPath" value="/taskmanager/edit.jsp" />	
					</portlet:renderURL>					
					<liferay-ui:icon image="edit" message="edit" url="${editURL}" />
					<liferay-ui:icon image="delete" message="delete" url="javascript:${renderResponse.getNamespace()}deleteTask('${task.taskId}');" />					
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<portlet:actionURL name="deleteTask" var="deleteTaskURL"/>

<aui:form name="deleteTask" action="${deleteTaskURL}" method="POST">
		<aui:input type="hidden" name="taskId" value=""/>
</aui:form>

<script type="text/javascript">
	function <portlet:namespace />deleteTask(taskId) {
		if(confirm('<%=LanguageUtil.get(request,"are-you-sure-you-want-to-delete-this")%>')){
			document.<portlet:namespace />deleteTask.<portlet:namespace />taskId.value = taskId;
			document.<portlet:namespace />deleteTask.submit();
		}else{
			self.focus(); 
		}
	}
	
	function <portlet:namespace />showDescription(elem) {	
		elem.classList.toggle("show");		
	}
</script>
