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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.pmc.task.manager.model.Task;
import com.pmc.task.manager.service.base.TaskLocalServiceBaseImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.pmc.task.manager.service.TaskLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author JE10798
 * @see TaskLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.pmc.task.manager.model.Task",
	service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.pmc.task.manager.service.TaskLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.pmc.task.manager.service.TaskLocalServiceUtil</code>.
	 */
	
	private static Log log = LogFactoryUtil.getLog(TaskLocalServiceImpl.class);
	
	public Task addTask(long companyId, long userId, String name, String description, int priority, Date dueDate) throws SystemException{
		
		Task newTask = taskPersistence.create(counterLocalService.increment(Task.class.getName()));
					
		newTask.setCompanyId(companyId);				
		newTask.setCreateDate(new Timestamp(System.currentTimeMillis()));
		newTask.setModifiedDate(null);
		newTask.setUserId(userId);
				
		newTask.setName(name);
		newTask.setDescription(description);
		newTask.setDueDate(dueDate);
		newTask.setPriority(priority);
		newTask.setAccomplished(false);
	
		newTask = taskPersistence.update(newTask);
	
		return newTask;
	}
	
	public Task updateTask(long taskId, String name, String description, int priority, Date dueDate) throws SystemException{
		
		Task task = taskPersistence.fetchByPrimaryKey(taskId);
			
		task.setModifiedDate(new Timestamp(System.currentTimeMillis()));
				
		task.setName(name);
		task.setDescription(description);
		task.setDueDate(dueDate);
		task.setPriority(priority);
		
		return taskPersistence.update(task);
	}
	
	public List<Task> getSortedTasks(int start, int end, String orderByCol, String orderByType){
		OrderByComparator<Task> orderByComparator = OrderByComparatorFactoryUtil.create("tm_task", 
				Validator.isNull(orderByCol)?"priority":orderByCol, 
						orderByType.equals("asc"));
		
		return taskPersistence.findAll(start, end, orderByComparator);		
	}
	
	public void toogleAccomplished(long taskId){		
		try {
			Task task = taskLocalService.getTask(taskId);
			task.setAccomplished(!task.getAccomplished());
			taskLocalService.updateTask(task);
		} catch (PortalException | SystemException e) {
			log.error(e);
		}
	}
}