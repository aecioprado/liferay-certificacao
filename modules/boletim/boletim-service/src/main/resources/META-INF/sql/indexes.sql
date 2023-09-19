create index IX_65911FBC on Boletim_Tarefa (groupId);
create index IX_B5892B22 on Boletim_Tarefa (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E8461224 on Boletim_Tarefa (uuid_[$COLUMN_LENGTH:75$], groupId);