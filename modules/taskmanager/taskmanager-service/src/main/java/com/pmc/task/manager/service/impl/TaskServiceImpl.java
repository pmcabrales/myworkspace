/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.pmc.task.manager.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.pmc.task.manager.model.Task;
import com.pmc.task.manager.model.impl.TaskImpl;
import com.pmc.task.manager.service.base.TaskServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.pmc.task.manager.service.TaskService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author JE10798
 * @see TaskServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=tm", "json.web.service.context.path=Task"
	},
	service = AopService.class
)
public class TaskServiceImpl extends TaskServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.pmc.task.manager.service.TaskServiceUtil</code> to access the task remote service.
	 */
	
	public Task getTask(long taskId) throws PortalException{
		
		return taskLocalService.getTask(taskId);
		
	}
		
	public Task addTask(long companyId, long userId, String name, String description, int priority, Date dueDate) throws SystemException{
		
		return taskLocalService.addTask(companyId, userId, name, description, priority, dueDate);
	}
	
	public Task updateTask(long taskId, String name, String description, int priority, Date dueDate) throws SystemException{
	
		return taskLocalService.updateTask(taskId, name, description, priority, dueDate);
		
	}
	
	public Task deleteTask(long taskId) throws PortalException{
		
		return taskLocalService.deleteTask(taskId);
		
	}
	
	public void toogleAccomplished(long taskId){
		
		taskLocalService.toogleAccomplished(taskId);
		
	}
	
	public int getTasksCount(){
		
		return taskLocalService.getTasksCount();
		
	}
		
	public Task getEmptyTask(){
		Task task = new TaskImpl();			
		task.setDescription("");	
		task.setTaskId(-1);		
		return task;
	}
	
	public List<Task> getSortedTasks(int start, int end, String orderByCol, String orderByType){
		
		return taskLocalService.getSortedTasks(start, end, orderByCol, orderByType);		
		
	}
		
}