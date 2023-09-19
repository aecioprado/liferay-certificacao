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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Boletim_Tarefa&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Tarefa
 * @generated
 */
public class TarefaTable extends BaseTable<TarefaTable> {

	public static final TarefaTable INSTANCE = new TarefaTable();

	public final Column<TarefaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TarefaTable, Long> tarefaId = createColumn(
		"tarefaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TarefaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TarefaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TarefaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TarefaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TarefaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TarefaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TarefaTable, String> titulo = createColumn(
		"titulo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TarefaTable, String> descricao = createColumn(
		"descricao", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TarefaTable, Date> dataFinal = createColumn(
		"dataFinal", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private TarefaTable() {
		super("Boletim_Tarefa", TarefaTable::new);
	}

}