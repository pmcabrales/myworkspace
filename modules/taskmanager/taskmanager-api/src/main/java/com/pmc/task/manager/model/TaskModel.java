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

package com.pmc.task.manager.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Task service. Represents a row in the &quot;TM_Task&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.pmc.task.manager.model.impl.TaskModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.pmc.task.manager.model.impl.TaskImpl</code>.
 * </p>
 *
 * @author JE10798
 * @see Task
 * @generated
 */
@ProviderType
public interface TaskModel extends BaseModel<Task>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a task model instance should use the {@link Task} interface instead.
	 */

	/**
	 * Returns the primary key of this task.
	 *
	 * @return the primary key of this task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this task.
	 *
	 * @param primaryKey the primary key of this task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this task.
	 *
	 * @return the uuid of this task
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this task.
	 *
	 * @param uuid the uuid of this task
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the task ID of this task.
	 *
	 * @return the task ID of this task
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this task.
	 *
	 * @param taskId the task ID of this task
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the company ID of this task.
	 *
	 * @return the company ID of this task
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this task.
	 *
	 * @param companyId the company ID of this task
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this task.
	 *
	 * @return the user ID of this task
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this task.
	 *
	 * @param userId the user ID of this task
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this task.
	 *
	 * @return the user uuid of this task
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this task.
	 *
	 * @param userUuid the user uuid of this task
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this task.
	 *
	 * @return the create date of this task
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this task.
	 *
	 * @param createDate the create date of this task
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this task.
	 *
	 * @return the modified date of this task
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this task.
	 *
	 * @param modifiedDate the modified date of this task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this task.
	 *
	 * @return the name of this task
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this task.
	 *
	 * @param name the name of this task
	 */
	public void setName(String name);

	/**
	 * Returns the description of this task.
	 *
	 * @return the description of this task
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this task.
	 *
	 * @param description the description of this task
	 */
	public void setDescription(String description);

	/**
	 * Returns the accomplished of this task.
	 *
	 * @return the accomplished of this task
	 */
	public boolean getAccomplished();

	/**
	 * Returns <code>true</code> if this task is accomplished.
	 *
	 * @return <code>true</code> if this task is accomplished; <code>false</code> otherwise
	 */
	public boolean isAccomplished();

	/**
	 * Sets whether this task is accomplished.
	 *
	 * @param accomplished the accomplished of this task
	 */
	public void setAccomplished(boolean accomplished);

	/**
	 * Returns the priority of this task.
	 *
	 * @return the priority of this task
	 */
	public int getPriority();

	/**
	 * Sets the priority of this task.
	 *
	 * @param priority the priority of this task
	 */
	public void setPriority(int priority);

	/**
	 * Returns the due date of this task.
	 *
	 * @return the due date of this task
	 */
	public Date getDueDate();

	/**
	 * Sets the due date of this task.
	 *
	 * @param dueDate the due date of this task
	 */
	public void setDueDate(Date dueDate);

}