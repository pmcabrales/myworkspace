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

package com.pmc.task.manager.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.pmc.task.manager.service.TaskServiceUtil;

import java.rmi.RemoteException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>TaskServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.pmc.task.manager.model.TaskSoap</code>. If the method in the
 * service utility returns a
 * <code>com.pmc.task.manager.model.Task</code>, that is translated to a
 * <code>com.pmc.task.manager.model.TaskSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author JE10798
 * @see TaskServiceHttp
 * @generated
 */
@ProviderType
public class TaskServiceSoap {

	public static com.pmc.task.manager.model.TaskSoap getTask(long taskId)
		throws RemoteException {

		try {
			com.pmc.task.manager.model.Task returnValue =
				TaskServiceUtil.getTask(taskId);

			return com.pmc.task.manager.model.TaskSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.pmc.task.manager.model.TaskSoap addTask(
			long companyId, long userId, String name, String description,
			int priority, java.util.Date dueDate)
		throws RemoteException {

		try {
			com.pmc.task.manager.model.Task returnValue =
				TaskServiceUtil.addTask(
					companyId, userId, name, description, priority, dueDate);

			return com.pmc.task.manager.model.TaskSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.pmc.task.manager.model.TaskSoap updateTask(
			long taskId, String name, String description, int priority,
			java.util.Date dueDate)
		throws RemoteException {

		try {
			com.pmc.task.manager.model.Task returnValue =
				TaskServiceUtil.updateTask(
					taskId, name, description, priority, dueDate);

			return com.pmc.task.manager.model.TaskSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.pmc.task.manager.model.TaskSoap deleteTask(long taskId)
		throws RemoteException {

		try {
			com.pmc.task.manager.model.Task returnValue =
				TaskServiceUtil.deleteTask(taskId);

			return com.pmc.task.manager.model.TaskSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void toogleAccomplished(long taskId) throws RemoteException {
		try {
			TaskServiceUtil.toogleAccomplished(taskId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getTasksCount() throws RemoteException {
		try {
			int returnValue = TaskServiceUtil.getTasksCount();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.pmc.task.manager.model.TaskSoap getEmptyTask()
		throws RemoteException {

		try {
			com.pmc.task.manager.model.Task returnValue =
				TaskServiceUtil.getEmptyTask();

			return com.pmc.task.manager.model.TaskSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.pmc.task.manager.model.TaskSoap[] getSortedTasks(
			int start, int end, String orderByCol, String orderByType)
		throws RemoteException {

		try {
			java.util.List<com.pmc.task.manager.model.Task> returnValue =
				TaskServiceUtil.getSortedTasks(
					start, end, orderByCol, orderByType);

			return com.pmc.task.manager.model.TaskSoap.toSoapModels(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TaskServiceSoap.class);

}