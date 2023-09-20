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

package com.liferay.treinamento.boletim.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.treinamento.boletim.model.Tarefa;
import com.liferay.treinamento.boletim.service.base.TarefaServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=boletim",
		"json.web.service.context.path=Tarefa"
	},
	service = AopService.class
)
public class TarefaServiceImpl extends TarefaServiceBaseImpl {

	public Tarefa addTarefa(
			long groupId, String titulo, String descricao,
			Date dataFinal, ServiceContext serviceContext)
			throws PortalException {
		return tarefaLocalService.addTarefa(
				groupId, titulo, descricao, dataFinal, serviceContext);
	}
	public Tarefa deleteTarefa(long tarefaId)
			throws PortalException {
		Tarefa Tarefa = tarefaLocalService.getTarefa(tarefaId);
		return tarefaLocalService.deleteTarefa(Tarefa);
	}
	public Tarefa getTarefa(long tarefaId)
			throws PortalException {
		return tarefaLocalService.getTarefa(tarefaId);
	}
	public List<Tarefa> getTarefasByGroupId(long groupId) {
		return tarefaPersistence.findByGroupId(groupId);
	}
	public List<Tarefa> getTarefasByKeywords(
			long groupId, String keywords, int start, int end,
			OrderByComparator<Tarefa> orderByComparator) {
		return tarefaLocalService.getTarefasByKeywords(
				groupId, keywords, start, end, orderByComparator);
	}
	public long getTarefasCountByKeywords(long groupId, String keywords) {
		return tarefaLocalService.getTarefasCountByKeywords(
				groupId, keywords);
	}
	public Tarefa updateTarefa(
			long tarefaId, String titulo, String descricao,
			Date dataFinal, ServiceContext serviceContext)
			throws PortalException {
		return tarefaLocalService.updateTarefa(
				tarefaId, titulo, descricao, dataFinal, serviceContext);
	}
}