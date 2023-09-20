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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.treinamento.boletim.model.Tarefa;

import java.util.List;

/**
 * Provides the remote service utility for Tarefa. This utility wraps
 * <code>com.liferay.treinamento.boletim.service.impl.TarefaServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TarefaService
 * @generated
 */
public class TarefaServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.treinamento.boletim.service.impl.TarefaServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Tarefa addTarefa(
			long groupId, String titulo, String descricao,
			java.util.Date dataFinal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addTarefa(
			groupId, titulo, descricao, dataFinal, serviceContext);
	}

	public static Tarefa deleteTarefa(long tarefaId) throws PortalException {
		return getService().deleteTarefa(tarefaId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Tarefa getTarefa(long tarefaId) throws PortalException {
		return getService().getTarefa(tarefaId);
	}

	public static List<Tarefa> getTarefasByGroupId(long groupId) {
		return getService().getTarefasByGroupId(groupId);
	}

	public static List<Tarefa> getTarefasByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Tarefa> orderByComparator) {

		return getService().getTarefasByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static long getTarefasCountByKeywords(
		long groupId, String keywords) {

		return getService().getTarefasCountByKeywords(groupId, keywords);
	}

	public static Tarefa updateTarefa(
			long tarefaId, String titulo, String descricao,
			java.util.Date dataFinal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateTarefa(
			tarefaId, titulo, descricao, dataFinal, serviceContext);
	}

	public static TarefaService getService() {
		return _service;
	}

	private static volatile TarefaService _service;

}