package com.pmc.task.manager.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.pmc.task.manager.constants.TaskmanagerWebPortletKeys;
import com.pmc.task.manager.display.context.TaskToolbarDisplayContext;
import com.pmc.task.manager.model.Task;
import com.pmc.task.manager.service.TaskLocalServiceUtil;
import com.pmc.task.manager.service.TaskService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author JE10798
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Taskmanager",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/taskmanager/view.jsp",
		"javax.portlet.name=" + TaskmanagerWebPortletKeys.TASKMANAGERWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TaskmanagerWebPortlet extends MVCPortlet {
	
	private static Log log = LogFactoryUtil.getLog(TaskmanagerWebPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest,
	        RenderResponse renderResponse) throws PortletException, IOException {

	    try {
	        long taskId = ParamUtil.getLong(renderRequest, "taskId");
	        
	        log.debug("taskId: " + taskId);
	        
	        String view = ParamUtil.get(renderRequest,"view","");
	        log.debug("view: " + view);
	        
	        try{
				if (view == null || view.equals("")) {
					showViewDefault(renderRequest, renderResponse);
				}else if(view.equals("edit-view")){
					showViewEditTask(renderRequest, renderResponse);
				}
			} catch (Exception e) {
				log.error(e);
			}
	        
	    } catch (Exception e) {

	        throw new PortletException(e);
	    }

	    super.render(renderRequest, renderResponse);

	}
	
	public void showViewDefault(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {		

		log.debug("::showViewDefault::");

		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType");
		
		SearchContainer<Task> searchContainer = new SearchContainer<>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 
				ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,SearchContainer.DEFAULT_DELTA), renderResponse.createRenderURL(), 
				null, "there-are-no-results");
		
		try {		
			List<Task> tasks = _taskService.getSortedTasks(searchContainer.getStart(), searchContainer.getEnd(), orderByCol,orderByType);
							   
			int taskCount = _taskService.getTasksCount();
			
			searchContainer.setTotal(taskCount);		
			searchContainer.setResults(tasks);			
			searchContainer.setOrderByCol(orderByCol);
			searchContainer.setOrderByType(orderByType);
			
			TaskToolbarDisplayContext taskToolbarDisplayContext = new TaskToolbarDisplayContext(PortalUtil.getLiferayPortletRequest(renderRequest), PortalUtil.getLiferayPortletResponse(renderResponse), PortalUtil.getHttpServletRequest(renderRequest), searchContainer);
			renderRequest.setAttribute("taskToolbarDisplayContext", taskToolbarDisplayContext);
		} catch (SystemException e) {
			log.error(e);
		}
		
		renderRequest.setAttribute("searchContainer", searchContainer);
		
		
	}
	
	
	public void showViewEditTask(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException, PortalException, SystemException {
		
		long taskId = ParamUtil.getLong(renderRequest, "taskId", -1);
		log.debug("Show View edit task::  taskId: "+ taskId);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		TimeZone timeZone = themeDisplay.getTimeZone();
		SimpleDateFormat formatDay = new SimpleDateFormat("dd");
		formatDay.setTimeZone(themeDisplay.getTimeZone());
		SimpleDateFormat formatMonth = new SimpleDateFormat("MM");
		formatMonth.setTimeZone(timeZone);
		SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
		formatYear.setTimeZone(timeZone);	
				
		Date dueDate=new Date(System.currentTimeMillis());
		
		Task task = null;
		if(taskId < 0){ //NEW TASK
			task = _taskService.getEmptyTask();		
		}
		else{
			task = _taskService.getTask(taskId);		
			dueDate = task.getDueDate();
		}	
		renderRequest.setAttribute("task", task);
		
		renderRequest.setAttribute("dueDateDay", Integer.parseInt(formatDay.format(dueDate)));
		renderRequest.setAttribute("dueDateMonth", Integer.parseInt(formatMonth.format(dueDate))-1);
		renderRequest.setAttribute("dueDateYear", Integer.parseInt(formatYear.format(dueDate)));
		renderRequest.setAttribute("defaultStartYear", Integer.parseInt(formatYear.format(new Date())));
		renderRequest.setAttribute("defaultEndYear", Integer.parseInt(formatYear.format(new Date()))+10);
		renderRequest.setAttribute("priorities", Priority.aPriority);

	} 
	
	@ProcessAction(name="saveTask")
	public void saveTask(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException {

		log.debug("::Add task");
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	    long taskId = ParamUtil.getLong(request, "taskId", -1);			
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		int priority = ParamUtil.getInteger(request, "prioritySel");		
		int dueDateMonth = ParamUtil.getInteger(request, "dueDateMon");
		int dueDateYear = ParamUtil.getInteger(request, "dueDateYear");
		int dueDateDay = ParamUtil.getInteger(request, "dueDateDay");

		Calendar dueDateCalendar = Calendar.getInstance(themeDisplay.getUser().getTimeZone());
		dueDateCalendar.set(Calendar.YEAR, dueDateYear);
		dueDateCalendar.set(Calendar.MONTH, dueDateMonth);
		dueDateCalendar.set(Calendar.DAY_OF_MONTH, dueDateDay);	
		
		try {		
			if(taskId < 0){
				//NEW TASK				
				_taskService.addTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), name, description, priority, dueDateCalendar.getTime());
			}else{
				//EDIT TASK
				_taskService.updateTask(taskId, name, description, priority, dueDateCalendar.getTime());
			}		
					
			SessionMessages.add(request, "ok-task-updated");
		
		} catch (SystemException e) {
			SessionErrors.add(request, "ko-task-updated");
			response.setRenderParameter("view", "edit-task");
			response.setRenderParameter("taskId",String.valueOf(taskId));
			log.error(e);		
		} 

	}
	
	@ProcessAction(name="toggleAccomplished")
	public void toggleAccomplished(ActionRequest request, ActionResponse response){
		long taskId = ParamUtil.getLong(request, "taskId", -1);			
		
		try {
			Task task = TaskLocalServiceUtil.getTask(taskId);
			task.setAccomplished(!task.getAccomplished());
			TaskLocalServiceUtil.updateTask(task);
		} catch (PortalException | SystemException e) {
			log.error(e);
		}
	}
	
	@ProcessAction(name="deleteTask")
	public void deleteTask(ActionRequest request, ActionResponse response){
		long taskId = ParamUtil.getLong(request, "taskId", -1);			
		
		try {
			TaskLocalServiceUtil.deleteTask(taskId);
			SessionMessages.add(request, "ok-task-deleted");
		} catch (PortalException | SystemException e) {
			log.error(e);
			SessionErrors.add(request, "ko-task-deleted");
		}
	}
	
	@Reference private TaskService _taskService;
}