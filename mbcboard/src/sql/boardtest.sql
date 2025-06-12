-----------------------------------------------member 테이블 부모로 생성하기---------------------------------------------------
create table member(
mno number(5) not null,
bwriter nvarchar2(10) not null, 
id nvarchar2(10) primary key, -- board 테이블의 bwirter 과 fk로 관계설정 하려고 함! (타입일치!)
pw nvarchar2(10) not null,
regidate date default sysdate not null --default sysdate 알아서 system날짜를 집어넣음 
)

-- 시퀀스 객체는 이미 1개가 있으니 board_seq를 같이 사용하겠다.
drop table member -- member 테이블 삭제용

insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '김기원', 'kkw', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '김진우', 'kjw', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '김보령', 'kbr', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '전혜진', 'jhj', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '이하늘', 'lhn', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '배혜민', 'bhm', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '김샛별', 'ksb', '1234')
-----------------------------------------------member의 자식 board 외래키 생성 필수---------------------------------------------------
alter table board add constraint board_member_fk foreign key (bwriter) references member(id)

-- board 테이블은 member의 자식  테이블로 member에 id와 board 에  bwriter를 관계 설정 (외래키)
-- ORA-02267: column type incompatible with referenced column type -> pk와 fk를 붙혀야함.
-- pk와 kw를 확인하고 연결 -> 자식테이블 의 더미데이터를 삭제하고 실행해보자.
-- board 에 더미네이터를 넣어보니 
-- ORA-02291: integrity constraint (BOARDTEST.BOARD_MEMBER_FK) violated - parent key not found 
-- 부모테이블에 김기원 이라는 값이 없다. -> board 에 김기원 을 id kkw로 변경

drop table board --기존에 board 테이블 삭제
drop sequence board_seq -- 자동번호 생성 제거
 -- 먼저 테이블을 만들고 어느 객체에 pk를 넣을지, 어느정도의 값을 넣을건지 null값은 어떻게 할건지 만든다.
create table board(
bno number(5) primary key,
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null,
bdate date not null
)

create sequence board_seq increment by 1 start with 1 nocycle nocache 
-- 시퀀스 생성문 만들기 1부터 시작해서 끝까지 가면 반복하지 않고 종료
delete from board ;

insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '덥네용~', '무더운데 등교하시는냐고 고생 하셨습니다.', 'kkw', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '안녕하세요~', '무더운데 등교하시는냐고 고생 하셨습니다.', 'kjw', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '감사합니다~', '무더운데 등교하시는냐고 고생 하셨습니다.', 'kbr', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '수고하셨네요~', '무더운데 등교하시는냐고 고생 하셨습니다.', 'jhj', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '화이팅하세요~', '무더운데 등교하시는냐고 고생 하셨습니다.', 'lhn', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '방갑습니다~', '무더운데 등교하시는냐고 고생 하셨습니다.', 'bhm', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '하이루~', '개더운데 고생하옵니다.', 'ksb', sysdate)
-- 데이터 만들기
select * from board 
----------------------------------------------------------------------------------------------------------------------------------
-- 조인 : 2개의 테이블을 연결하여 값을 가져온다.
-- SELECT sequence_name FROM user_sequences;
select b.*, m.bwriter from member m inner join board b on m.id = b.bwriter where id='kkw'

SELECT id FROM member;
SELECT bwriter FROM board;