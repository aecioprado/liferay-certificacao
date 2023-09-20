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

package com.liferay.treinamento.boletim.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TarefaService}.
 *
 * @author Brian Wing Shun Chan
 * @see TarefaService
 * @generated
 */
public class TarefaServiceWrapper
	implements ServiceWrapper<TarefaService>, TarefaService {

	public TarefaServiceWrapper() {
		this(null);
	}

	public TarefaServiceWrapper(TarefaService tarefaService) {
		_tarefaService = tarefaService;
	}

	@Override
	public com.liferay.treinamento.boletim.model.Tarefa addTarefa(
			long groupId, String titulo, String descricao,
			java.util.Date dataFinal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tarefaService.addTarefa(
			groupId, titulo, descricao, dataFinal, serviceContext);
	}

	@Override
	public com.liferay.treinamento.boletim.model.Tarefa deleteTarefa(
			long tarefaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tarefaService.deleteTarefa(tarefaId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tarefaService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.treinamento.boletim.model.Tarefa getTarefa(long tarefaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tarefaService.getTarefa(tarefaId);
	}

	@Override
	public java.util.List<com.liferay.treinamento.boletim.model.Tarefa>
		getTarefasByGroupId(long groupId) {

		return _tarefaService.getTarefasByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.treinamento.boletim.model.Tarefa>
		getTarefasByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.treinamento.boletim.model.Tarefa>
					orderByComparator) {

		return _tarefaService.getTarefasByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public long getTarefasCountByKeywords(long groupId, String keywords) {
		return _tarefaService.getTarefasCountByKeywords(groupId, keywords);
	}

	@Override
	public com.liferay.treinamento.boletim.model.Tarefa updateTarefa(
			long tarefaId, String titulo, String descricao,
			java.util.Date dataFinal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tarefaService.updateTarefa(
			tarefaId, titulo, descricao, dataFinal, serviceContext);
	}

	@Override
	public TarefaService getWrappedService() {
		return _tarefaService;
	}

	@Override
	public void setWrappedService(TarefaService tarefaService) {
		_tarefaService = tarefaService;
	}

	private TarefaService _tarefaService;

}