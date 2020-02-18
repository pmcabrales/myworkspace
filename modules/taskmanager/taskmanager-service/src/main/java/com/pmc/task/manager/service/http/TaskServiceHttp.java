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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.pmc.task.manager.service.TaskServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the HTTP utility for the
 * <code>TaskServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author JE10798
 * @see TaskServiceSoap
 * @generated
 */
@ProviderType
public class TaskServiceHttp {

	public static com.pmc.task.manager.model.Task getTask(
			HttpPrincipal httpPrincipal, long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "getTask", _getTaskParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.pmc.task.manager.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.pmc.task.manager.model.Task addTask(
			HttpPrincipal httpPrincipal, long companyId, long userId,
			String name, String description, int priority,
			java.util.Date dueDate)
		throws com.liferay.portal.kernel.exception.SystemException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "addTask", _addTaskParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, userId, name, description, priority,
				dueDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.SystemException) {

					throw (com.liferay.portal.kernel.exception.SystemException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.pmc.task.manager.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.pmc.task.manager.model.Task updateTask(
			HttpPrincipal httpPrincipal, long taskId, String name,
			String description, int priority, java.util.Date dueDate)
		throws com.liferay.portal.kernel.exception.SystemException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "updateTask",
				_updateTaskParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, taskId, name, description, priority, dueDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.SystemException) {

					throw (com.liferay.portal.kernel.exception.SystemException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.pmc.task.manager.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.pmc.task.manager.model.Task deleteTask(
			HttpPrincipal httpPrincipal, long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "deleteTask",
				_deleteTaskParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.pmc.task.manager.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void toogleAccomplished(
		HttpPrincipal httpPrincipal, long taskId) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "toogleAccomplished",
				_toogleAccomplishedParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTasksCount(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "getTasksCount",
				_getTasksCountParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.pmc.task.manager.model.Task getEmptyTask(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "getEmptyTask",
				_getEmptyTaskParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.pmc.task.manager.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.pmc.task.manager.model.Task>
		getSortedTasks(
			HttpPrincipal httpPrincipal, int start, int end, String orderByCol,
			String orderByType) {

		try {
			MethodKey methodKey = new MethodKey(
				TaskServiceUtil.class, "getSortedTasks",
				_getSortedTasksParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, start, end, orderByCol, orderByType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<com.pmc.task.manager.model.Task>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TaskServiceHttp.class);

	private static final Class<?>[] _getTaskParameterTypes0 = new Class[] {
		long.class
	};
	private static final Class<?>[] _addTaskParameterTypes1 = new Class[] {
		long.class, long.class, String.class, String.class, int.class,
		java.util.Date.class
	};
	private static final Class<?>[] _updateTaskParameterTypes2 = new Class[] {
		long.class, String.class, String.class, int.class, java.util.Date.class
	};
	private static final Class<?>[] _deleteTaskParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[] _toogleAccomplishedParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _getTasksCountParameterTypes5 =
		new Class[] {};
	private static final Class<?>[] _getEmptyTaskParameterTypes6 = new Class[] {
		
	};
	private static final Class<?>[] _getSortedTasksParameterTypes7 =
		new Class[] {int.class, int.class, String.class, String.class};

}