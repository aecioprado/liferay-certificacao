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

package com.liferay.treinamento.boletim.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Tarefa service. Represents a row in the &quot;Boletim_Tarefa&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.treinamento.boletim.model.impl.TarefaModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.treinamento.boletim.model.impl.TarefaImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Tarefa
 * @generated
 */
@ProviderType
public interface TarefaModel
	extends BaseModel<Tarefa>, GroupedModel, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tarefa model instance should use the {@link Tarefa} interface instead.
	 */

	/**
	 * Returns the primary key of this tarefa.
	 *
	 * @return the primary key of this tarefa
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tarefa.
	 *
	 * @param primaryKey the primary key of this tarefa
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this tarefa.
	 *
	 * @return the uuid of this tarefa
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this tarefa.
	 *
	 * @param uuid the uuid of this tarefa
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the tarefa ID of this tarefa.
	 *
	 * @return the tarefa ID of this tarefa
	 */
	public long getTarefaId();

	/**
	 * Sets the tarefa ID of this tarefa.
	 *
	 * @param tarefaId the tarefa ID of this tarefa
	 */
	public void setTarefaId(long tarefaId);

	/**
	 * Returns the group ID of this tarefa.
	 *
	 * @return the group ID of this tarefa
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this tarefa.
	 *
	 * @param groupId the group ID of this tarefa
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this tarefa.
	 *
	 * @return the company ID of this tarefa
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this tarefa.
	 *
	 * @param companyId the company ID of this tarefa
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this tarefa.
	 *
	 * @return the user ID of this tarefa
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this tarefa.
	 *
	 * @param userId the user ID of this tarefa
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this tarefa.
	 *
	 * @return the user uuid of this tarefa
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this tarefa.
	 *
	 * @param userUuid the user uuid of this tarefa
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this tarefa.
	 *
	 * @return the user name of this tarefa
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this tarefa.
	 *
	 * @param userName the user name of this tarefa
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this tarefa.
	 *
	 * @return the create date of this tarefa
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this tarefa.
	 *
	 * @param createDate the create date of this tarefa
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this tarefa.
	 *
	 * @return the modified date of this tarefa
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this tarefa.
	 *
	 * @param modifiedDate the modified date of this tarefa
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the titulo of this tarefa.
	 *
	 * @return the titulo of this tarefa
	 */
	@AutoEscape
	public String getTitulo();

	/**
	 * Sets the titulo of this tarefa.
	 *
	 * @param titulo the titulo of this tarefa
	 */
	public void setTitulo(String titulo);

	/**
	 * Returns the descricao of this tarefa.
	 *
	 * @return the descricao of this tarefa
	 */
	@AutoEscape
	public String getDescricao();

	/**
	 * Sets the descricao of this tarefa.
	 *
	 * @param descricao the descricao of this tarefa
	 */
	public void setDescricao(String descricao);

	/**
	 * Returns the data final of this tarefa.
	 *
	 * @return the data final of this tarefa
	 */
	public Date getDataFinal();

	/**
	 * Sets the data final of this tarefa.
	 *
	 * @param dataFinal the data final of this tarefa
	 */
	public void setDataFinal(Date dataFinal);

	@Override
	public Tarefa cloneWithOriginalValues();

}