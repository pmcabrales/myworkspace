create table TM_Task (
	uuid_ VARCHAR(75) null,
	taskId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(2000) null,
	accomplished BOOLEAN,
	priority INTEGER,
	dueDate DATE null
);