create table account(
	accountNo int primary key,
	id varchar2(20),
	money int
);

SELECT * FROM ACCOUNT;

delete from account;
drop table account2;


create sequence accSeq
increment by 1
start with 1000001
nocycle;

create view account_member as
select * from account join member using(id);

select * from account_member;

select * from member;