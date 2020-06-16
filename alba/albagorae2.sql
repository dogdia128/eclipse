create database albagorae;
use albagorae;

drop  table if exists user;
drop  table if exists board;


create table user (
	id varchar(45) primary key,
    password varchar(45),
    type varchar(45)
);

create table board (
	num int auto_increment primary key,
	writer varchar(45),
    title varchar(45),
    content long,
    writeday date,
    readnum int
);

insert into user values("test", "testpw", "employee");
insert into board(writer, title, content, writeday, readnum) values("test", "test1", "this is a test", sysdate() ,0);

desc board;

select * from board;

select * from user;


select * from board order by readnum desc limit 10; 


insert into board(writer, title, content, writeday, readnum) values("김고용", "김고용-직업구함", "this is a test", sysdate() ,100);
insert into board(writer, title, content, writeday, readnum) values("이고용,", "이고용-안녕하세요", "this is a test", sysdate() ,30);
insert into board(writer, title, content, writeday, readnum) values("박고용", "성실한 직원구함", "this is a test", sysdate() ,20);
insert into board(writer, title, content, writeday, readnum) values("최고용", "직원 구함", "this is a test", sysdate() ,40);
insert into board(writer, title, content, writeday, readnum) values("허고용", "안녕하세요", "this is a test", sysdate() ,20);
insert into board(writer, title, content, writeday, readnum) values("임고용", "직업을 구합니다.", "this is a test", sysdate() ,21);
insert into board(writer, title, content, writeday, readnum) values("김사장", "안녕하세요 일구함", "this is a test", sysdate() ,19);
insert into board(writer, title, content, writeday, readnum) values("신사장", "직원 급구", "this is a test", sysdate() ,20);
insert into board(writer, title, content, writeday, readnum) values("박사장", "알바 구함", "this is a test", sysdate() ,14);








