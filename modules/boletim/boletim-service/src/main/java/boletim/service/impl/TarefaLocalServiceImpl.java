/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package boletim.service.impl;

import boletim.model.Tarefa;

import boletim.service.base.TarefaLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=boletim.model.Tarefa",
	service = AopService.class
)
public class TarefaLocalServiceImpl extends TarefaLocalServiceBaseImpl {

	public Tarefa addTarefa(
			long groupId, String titulo, String descricao, Date dataFinal,
			ServiceContext serviceContext)
		throws PortalException {

		// Grupo e usuário

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		// Gera chave-primário da tarefa

		long tarefaId = counterLocalService.increment(Tarefa.class.getName());

		// Cria uma tarefa

		Tarefa tarefa = createTarefa(tarefaId);

		// Popula os campos de audit

		tarefa.setCompanyId(group.getCompanyId());
		tarefa.setGroupId(groupId);
		tarefa.setUserId(userId);
		tarefa.setUserName(user.getScreenName());
		tarefa.setCreateDate(serviceContext.getCreateDate(new Date()));
		tarefa.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		// Popula os campos do modelo

		tarefa.setTitulo(titulo);
		tarefa.setDescricao(descricao);
		tarefa.setDataFinal(dataFinal);

		// Persiste no banco de dados

		return super.addTarefa(tarefa);
	}

	@Override
	public Tarefa addTarefa(Tarefa tarefa) {
		throw new UnsupportedOperationException("Not supported.");
	}

	// Finders

	public List<Tarefa> getTarefasByGroupId(long groupId) {
		return tarefaPersistence.findByGroupId(groupId);
	}

	public List<Tarefa> getTarefasByGroupId(long groupId, int start, int end) {
		return tarefaPersistence.findByGroupId(groupId, start, end);
	}

	public List<Tarefa> getTarefasByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Tarefa> orderByComparator) {

		return tarefaLocalService.dynamicQuery(
			getKeywordSearchDynamicQuery(groupId, keywords), start, end,
			orderByComparator);
	}

	public long getTarefasCountByKeywords(long groupId, String keywords) {
		return tarefaLocalService.dynamicQueryCount(
			getKeywordSearchDynamicQuery(groupId, keywords));
	}

	public List<Tarefa> getTarefasyGroupId(
		long groupId, int start, int end,
		OrderByComparator<Tarefa> orderByComparator) {

		return tarefaPersistence.findByGroupId(
			groupId, start, end, orderByComparator);
	}

	public Tarefa updateTarefa(
			long tarefaId, String titulo, String descricao, Date dataFinal,
			ServiceContext serviceContext)
		throws PortalException {

		// Recupe tarefa pelo id

		Tarefa tarefa = getTarefa(tarefaId);

		// Atualiza campos

		tarefa.setModifiedDate(new Date());
		tarefa.setTitulo(titulo);
		tarefa.setDescricao(descricao);
		tarefa.setDataFinal(dataFinal);
		tarefa = super.updateTarefa(tarefa);

		return tarefa;
	}

	// Silenciando outros métodos

	@Override
	public Tarefa updateTarefa(Tarefa tarefa) {
		throw new UnsupportedOperationException("Not supported.");
	}

	private DynamicQuery getKeywordSearchDynamicQuery(
		long groupId, String keywords) {

		DynamicQuery dynamicQuery = dynamicQuery().add(
			RestrictionsFactoryUtil.eq("groupId", groupId));

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery =
				RestrictionsFactoryUtil.disjunction();

			disjunctionQuery.add(
				RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(
				RestrictionsFactoryUtil.like(
					"description", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}

		return dynamicQuery;
	}

}