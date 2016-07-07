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

------------------------------


select
           a.account_no as account_no,
           a.money as money,
           m.id as id,
           m.pw as pw,
           m.name as name,
           m.reg_date as reg_date,
           m.ssn as ssn
          from member m , account a
          where m.id = a.id