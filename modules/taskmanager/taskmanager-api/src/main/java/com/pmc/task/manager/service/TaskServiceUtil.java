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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Task. This utility wraps
 * <code>com.pmc.task.manager.service.impl.TaskServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author JE10798
 * @see TaskService
 * @generated
 */
@ProviderType
public class TaskServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.pmc.task.manager.service.impl.TaskServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.pmc.task.manager.model.Task addTask(
			long companyId, long userId, String name, String description,
			int priority, java.util.Date dueDate)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().addTask(
			companyId, userId, name, description, priority, dueDate);
	}

	public static com.pmc.task.manager.model.Task deleteTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTask(taskId);
	}

	public static com.pmc.task.manager.model.Task getEmptyTask() {
		return getService().getEmptyTask();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.pmc.task.manager.model.Task>
		getSortedTasks(
			int start, int end, String orderByCol, String orderByType) {

		return getService().getSortedTasks(start, end, orderByCol, orderByType);
	}

	public static com.pmc.task.manager.model.Task getTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTask(taskId);
	}

	public static int getTasksCount() {
		return getService().getTasksCount();
	}

	public static void toogleAccomplished(long taskId) {
		getService().toogleAccomplished(taskId);
	}

	public static com.pmc.task.manager.model.Task updateTask(
			long taskId, String name, String description, int priority,
			java.util.Date dueDate)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().updateTask(
			taskId, name, description, priority, dueDate);
	}

	public static TaskService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskService, TaskService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskService.class);

		ServiceTracker<TaskService, TaskService> serviceTracker =
			new ServiceTracker<TaskService, TaskService>(
				bundle.getBundleContext(), TaskService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}