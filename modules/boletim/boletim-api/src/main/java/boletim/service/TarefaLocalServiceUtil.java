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

package boletim.service;

import boletim.model.Tarefa;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Tarefa. This utility wraps
 * <code>boletim.service.impl.TarefaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TarefaLocalService
 * @generated
 */
public class TarefaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>boletim.service.impl.TarefaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Tarefa addTarefa(
			long groupId, String titulo, String descricao,
			java.util.Date dataFinal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addTarefa(
			groupId, titulo, descricao, dataFinal, serviceContext);
	}

	/**
	 * Adds the tarefa to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TarefaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tarefa the tarefa
	 * @return the tarefa that was added
	 */
	public static Tarefa addTarefa(Tarefa tarefa) {
		return getService().addTarefa(tarefa);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new tarefa with the primary key. Does not add the tarefa to the database.
	 *
	 * @param tarefaId the primary key for the new tarefa
	 * @return the new tarefa
	 */
	public static Tarefa createTarefa(long tarefaId) {
		return getService().createTarefa(tarefaId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tarefa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TarefaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tarefaId the primary key of the tarefa
	 * @return the tarefa that was removed
	 * @throws PortalException if a tarefa with the primary key could not be found
	 */
	public static Tarefa deleteTarefa(long tarefaId) throws PortalException {
		return getService().deleteTarefa(tarefaId);
	}

	/**
	 * Deletes the tarefa from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TarefaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tarefa the tarefa
	 * @return the tarefa that was removed
	 */
	public static Tarefa deleteTarefa(Tarefa tarefa) {
		return getService().deleteTarefa(tarefa);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>boletim.model.impl.TarefaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>boletim.model.impl.TarefaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Tarefa fetchTarefa(long tarefaId) {
		return getService().fetchTarefa(tarefaId);
	}

	/**
	 * Returns the tarefa matching the UUID and group.
	 *
	 * @param uuid the tarefa's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tarefa, or <code>null</code> if a matching tarefa could not be found
	 */
	public static Tarefa fetchTarefaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTarefaByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tarefa with the primary key.
	 *
	 * @param tarefaId the primary key of the tarefa
	 * @return the tarefa
	 * @throws PortalException if a tarefa with the primary key could not be found
	 */
	public static Tarefa getTarefa(long tarefaId) throws PortalException {
		return getService().getTarefa(tarefaId);
	}

	/**
	 * Returns the tarefa matching the UUID and group.
	 *
	 * @param uuid the tarefa's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tarefa
	 * @throws PortalException if a matching tarefa could not be found
	 */
	public static Tarefa getTarefaByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getTarefaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the tarefas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>boletim.model.impl.TarefaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tarefas
	 * @param end the upper bound of the range of tarefas (not inclusive)
	 * @return the range of tarefas
	 */
	public static List<Tarefa> getTarefas(int start, int end) {
		return getService().getTarefas(start, end);
	}

	public static List<Tarefa> getTarefasByGroupId(long groupId) {
		return getService().getTarefasByGroupId(groupId);
	}

	public static List<Tarefa> getTarefasByGroupId(
		long groupId, int start, int end) {

		return getService().getTarefasByGroupId(groupId, start, end);
	}

	public static List<Tarefa> getTarefasByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Tarefa> orderByComparator) {

		return getService().getTarefasByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns all the tarefas matching the UUID and company.
	 *
	 * @param uuid the UUID of the tarefas
	 * @param companyId the primary key of the company
	 * @return the matching tarefas, or an empty list if no matches were found
	 */
	public static List<Tarefa> getTarefasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTarefasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of tarefas matching the UUID and company.
	 *
	 * @param uuid the UUID of the tarefas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of tarefas
	 * @param end the upper bound of the range of tarefas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching tarefas, or an empty list if no matches were found
	 */
	public static List<Tarefa> getTarefasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Tarefa> orderByComparator) {

		return getService().getTarefasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tarefas.
	 *
	 * @return the number of tarefas
	 */
	public static int getTarefasCount() {
		return getService().getTarefasCount();
	}

	public static long getTarefasCountByKeywords(
		long groupId, String keywords) {

		return getService().getTarefasCountByKeywords(groupId, keywords);
	}

	public static List<Tarefa> getTarefasyGroupId(
		long groupId, int start, int end,
		OrderByComparator<Tarefa> orderByComparator) {

		return getService().getTarefasyGroupId(
			groupId, start, end, orderByComparator);
	}

	public static Tarefa updateTarefa(
			long tarefaId, String titulo, String descricao,
			java.util.Date dataFinal,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateTarefa(
			tarefaId, titulo, descricao, dataFinal, serviceContext);
	}

	/**
	 * Updates the tarefa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TarefaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tarefa the tarefa
	 * @return the tarefa that was updated
	 */
	public static Tarefa updateTarefa(Tarefa tarefa) {
		return getService().updateTarefa(tarefa);
	}

	public static TarefaLocalService getService() {
		return _service;
	}

	private static volatile TarefaLocalService _service;

}