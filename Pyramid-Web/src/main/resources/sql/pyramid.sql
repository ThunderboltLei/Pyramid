create table T_LOGINUSER(
	ID int primary key auto_increment,
	EMAIL varchar(50) not null,
	PASSWORD varchar(50) not null,
	SERIANUMBER bigint,
	DBID bigint,
	USERTYPE int,
	CREATETIME timestamp,
	ENDTIME timestamp,
	ACTIVED bigint,
	TELEPHONE varchar(13),
	
);