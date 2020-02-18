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

package com.pmc.task.manager.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link TaskService}.
 *
 * @author JE10798
 * @see TaskService
 * @generated
 */
@ProviderType
public class TaskServiceWrapper
	implements TaskService, ServiceWrapper<TaskService> {

	public TaskServiceWrapper(TaskService taskService) {
		_taskService = taskService;
	}

	@Override
	public com.pmc.task.manager.model.Task addTask(
			long companyId, long userId, String name, String description,
			int priority, java.util.Date dueDate)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taskService.addTask(
			companyId, userId, name, description, priority, dueDate);
	}

	@Override
	public com.pmc.task.manager.model.Task deleteTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskService.deleteTask(taskId);
	}

	@Override
	public com.pmc.task.manager.model.Task getEmptyTask() {
		return _taskService.getEmptyTask();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.pmc.task.manager.model.Task> getSortedTasks(
		int start, int end, String orderByCol, String orderByType) {

		return _taskService.getSortedTasks(start, end, orderByCol, orderByType);
	}

	@Override
	public com.pmc.task.manager.model.Task getTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskService.getTask(taskId);
	}

	@Override
	public int getTasksCount() {
		return _taskService.getTasksCount();
	}

	@Override
	public void toogleAccomplished(long taskId) {
		_taskService.toogleAccomplished(taskId);
	}

	@Override
	public com.pmc.task.manager.model.Task updateTask(
			long taskId, String name, String description, int priority,
			java.util.Date dueDate)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taskService.updateTask(
			taskId, name, description, priority, dueDate);
	}

	@Override
	public TaskService getWrappedService() {
		return _taskService;
	}

	@Override
	public void setWrappedService(TaskService taskService) {
		_taskService = taskService;
	}

	private TaskService _taskService;

}