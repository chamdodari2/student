desc studentdata ;
desc users ;

select  id, pass, grants from users;
select * from studentdata;


-- 등수 자동순번!!  scoreByWhere에 추가하기 !! 학생정보조회에는 추가하면 안된다!! 그리고 검색버튼 눌렀ㅇ르떄 말고 초기화면에도 띄워지게 하기
select  stdNo, stdName, deptCode, deptName, grade, stateCode, stateName, militaryCode, militaryName, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg, pic,@num:=@num+1 as num 
from (select  @num:=0)a, vw_full_studentdata order by avg desc;

select * from stddepartment;
select * from studentdata;


select stdNo, stdName, deptCode, deptName, grade, stateCode, stateName, militaryCode, militaryName, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg, pic 
from vw_full_studentData  where stateCode = 'hla' order by total desc;

select stdNo, stdName, deptCode, deptName, grade, stateCode, stateName, militaryCode, militaryName, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg, pic 
from vw_full_studentdata order by total desc;
select stdNo,subject1,subject2,subject3,total,avg from vw_studentscore order by total desc where ;


-- root 계정주기

insert into users values (210430,password('rootroot'),true);

-- https://juyoung-1008.tistory.com/17
-- 컬럼 추가하기 (성적과목)
alter table studentscore add column '과목4' int(3) default 0 after '과목3';

-- 칼럼 삭제
alter table studentscore drop column '과목4';

-- 성적 뷰 만들기
create or replace view vw_studentScore
as
select stdNo,subject1,subject2,subject3,(subject1+subject2+subject3) as 'total',
	((subject1+subject2+subject3)/3) as 'avg' from studentscore ;


select * from vw_full_studentdata order by total desc;

INSERT INTO studentscore
(stdNo, subject1, subject2, subject3)
VALUES(17010044, 0, 0, 0);


VALUES(2222, 0, 0, 0) where stdNo = (select stdNo from studentdata where stdNo=2222);


select stdNo, subject1, subject2, subject3 from studentscore ;
where stdNo=(select stdNo from studentdata  where stdNo = 17010012);

select stdNo, subject1, subject2, subject3 from studentscore where stdNo=(select stdNo from studentdata  where stdNo = 17010012);

select * from studentdata;


17010013,"김예진",new StdDepartment("1"),2,new StdState("hlb"),new MilitaryState("y2a"),"960828*******","010-9566-0476","야간"," ㄴㄴㄴ");

select * from  vw_full_studentdata where stdNo = 20020029;

 --  뷰 검색 조건넣어서
select stdNo, stdName, deptCode, deptName, grade, stateCode, stateName, militaryCode, militaryName, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg
from vw_full_studentdata where stdNo =18010016;

update studentData set stdNo = 17010111, stdName= '김예진2', deptCode= '2', grade= 3, stateCode='hla', militaryCode='y2c', idNo='970828*******', hpNo='010-9566-0477', dayNightShift='주간',  pic = ' ㄴㄴㅁㅁㅁㅁㄴ'where stdNo = 17010111;

selec

-- insert문

insert into StudentData values (
'17010044','김예진','1',2,'hlb','y2a','960828*******','010-9566-0476','주간','test주소');


select * from studentdata;

SELECT stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNightShift FROM StudentData;


1004,"천사2", new Title(4), new Employee(1003), 2500000, new Department(1)



-- 업데이트문
update studentdata  set stdNo = 17010013, stdName= '김예진2', deptCode='3', grade='2', stateCode='hla', militaryCode='y2c', idNo='970828*******', hpNo='010-9566-0477', dayNightShift='야간' where stdNo = ; 

-- 삭제

delete from studentData where stdNo = 17010013;

select militaryCode, militaryName from MilitaryState;
select militaryCode, militaryName from MilitaryState where  militaryCode = 'y2a';
select deptCode, deptName from stddepartment;
select deptCode, deptName from stddepartment where deptCode =1;
select stdNo, subject1, subject2, subject3 from studentscore ;
select stdNo, subject1, subject2, subject3 from studentscore where stdNo=17010012 ;
select stateCode, stateName from stdstate;
select stateCode, stateName from stdstate where stateCode = 'hla';
select stdNo, subject1, subject2, subject3 from studentscore ;



-- 추가
insert into militarystate values 
('aa1','미정');
insert into studentdata  values(20020010, '김예진','1',1,'hlb','y2a','9608282******','010-9566-0476','주간');

insert into stddepartment  values
(4,'자바');
insert into studentscore values
(20020010,90,90,90);

insert into stdstate  values
('aaa','미정');

-- update

update militarystate set militaryCode  ='bb1' , militaryName  = '확정' where militaryCode ='aa1';
update stddepartment set deptCode  = 5, deptName ='웹' where deptCode = 4;
update studentscore  set subject1 = 80, subject2 = 80, subject3 = 80 where stdNo = 20020010;
update stdstate  set stateCode ='bbb', stateName ='확정' where stateCode ='aaa';

-- delete

delete from militarystate where militaryCode ='bb1';
delete from stddepartment where deptCode =5;
delete from studentscore  where stdNo =20020010;
delete  from stdstate  where stateCode = 'bbb';









select *from department;

create database studentmgn;

grant all on studentmgn.*
	to 'user_studentmgn'@'localhost' identified by 'rootroot';



 -- ----------------------------------- 
select stdNo ,stdName,stateName
from studentManagement m join stdState s on m.stateCode =s.stateCode;
	
-- 평균 구하기  (과목별 평균, 학생별 총점평균, 학년별총점평균)

select * from studentscore ;
 
select avg(subject1) as '1과목평균점수' 
from studentscore;
-- 학번,stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNighShift


select stdNo,stdName,stdState from

select * from stdstate;

select stdNo ,stdName,stateName
from studentManagement m join stdState s on m.stateCode =s.stateCode;

-- 전체검색

select  *from studentmanagement;

-- 학번,stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNighShift
-- 테스트1 sql문 짜기


select stdNo,
stdName,
deptCode,
deptName,
grade,
stateCode,
stateName,
militaryCode,
idNo,
gender,
hpNo,
dayNightShift,
subject1,subject2,
subject3,
total,
avg 
from vw_full_student;

-- 테스트1 뷰 만들기
create or replace view vw_full_studentData
as
select  s.stdNo, -- 학번
	s.stdName,  -- 이름
	s.deptCode,  -- 학과코드
	d.deptName,   -- 학과명
	s.grade,  -- 학년
	s.stateCode, -- 학적코드
	st.stateName,  -- 학적상태
	s.militaryCode,  -- 병역코드
	m.militaryName,  -- 병역구분
	s.idNo,  -- 주민번호/         성별도 출력되게해야하는디!!! 자바에서  총점,평균이랑 같이 메소드??
	if(substr(idNo,7,1)=1,'남','여') as gender,
-- 	substr(idNo, 7, 1) as gender,
-- 	(select idNo from studentmanagement where idNo = '1') as gender ,
-- 	(select idNo as gender from studentmanagement where idNo = '2') as '여',
	s.hpNo,   -- 연락처
	s.dayNightShift, -- 주야구분
	ss.subject1,  -- 과목1 성적
	ss.subject2,  -- 과목2성적
	ss.subject3,   --  과목3 성적                              총점,평균 ??
	(ss.subject1+ss.subject2+ss.subject3) as 'total',
	round(((ss.subject1+ss.subject2+ss.subject3)/3),2) as 'avg' , s.pic
from studentData s join stdDepartment d  on s.deptCode = d.deptCode 
left join stdState st on s.stateCode =st.stateCode 
left join militaryState m on s.militaryCode = m.militaryCode
left join studentScore ss on s.stdNo =ss.stdNo ;

left join gradeConvertion gd on ss.subject1 	

select * from vw_full_student;
-- 

select * from department;
select * from gradeconvertion;
select * from militarystate;
select * from stdstate;
select  * from studentmanagement;
select  * from studentscore;

select stdNo, idNo, substr(idNo, 7, 1)
from studentmanagement;

-- 뷰 만들기 예시
-- q뷰 새로만들기! 
create or replace view vw_full_employee
as
select  e.empno, 
	e.empname, 
	t.tno as title_no,
	t.tname as title_name,
	e.manager as manager_no,
	m.empname as manager_name,
	e.salary, 
	d.deptno,
	d.deptname,
	d.floor 
from employee e join title t on e.title = t.tno
left join employee m on e.manager = m.empno
join department d on e.dept = d.deptno;


-- 

-- 뷰 검색 예시
select  empno,empname,title_no,title_name,manager_no,manager_name,slary,deptno,deptname,floor
from vw_full_employee; 




 --  뷰 검색 조건넣어서
select stdNo, stdName, deptCode, deptName, grade, stateCode, stateName, militaryCode, militaryName, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg
from vw_full_studentdata where stdNo =18010016;

 
 
 
 
 


select * from vw_full_studentdata ;

select stdNo, stdName, deptCode, deptName, grade, stateCode, stateName, militaryCode, militaryName, idNo, gender, hpNo, dayNightShift, subject1, subject2, subject3, total, avg
from vw_full_studentdata ;


-- 성적환산표 관련 테스트sql문
-- 테스트1 뷰 만들기
create or replace view vw_full_studentdata
as
select  s.stdNo, -- 학번
	s.stdName,  -- 이름
	s.deptCode,  -- 학과코드
	d.deptName,   -- 학과명
	s.grade,  -- 학년
	s.stateCode, -- 학적코드
	st.stateName,  -- 학적상태
	s.militaryCode,  -- 병역코드
	m.militaryName,  -- 병역구분
	s.idNo,  -- 주민번호/         성별도 출력되게해야하는디!!! 자바에서  총점,평균이랑 같이 메소드??
	if(substr(idNo,7,1)=1,'남','여') as gender,
-- 	substr(idNo, 7, 1) as gender,
-- 	(select idNo from studentmanagement where idNo = '1') as gender ,
-- 	(select idNo as gender from studentmanagement where idNo = '2') as '여',
	s.hpNo,   -- 연락처
	s.dayNightShift, -- 주야구분
	ss.subject1,  -- 과목1 성적
	ss.subject2,  -- 과목2성적
	ss.subject3,   --  과목3 성적                              총점,평균 ??
	(ss.subject1+ss.subject2+ss.subject3) as 'total',
	((ss.subject1+ss.subject2+ss.subject3)/3) as 'avg'
from studentData s join stdDepartment d  on s.deptCode = d.deptCode 
left join stdState st on s.stateCode =st.stateCode 
left join militaryState m on s.militaryCode = m.militaryCode
left join studentScore ss on s.stdNo =ss.stdNo ;

left join gradeConvertion gd on ss.subject1 	 



-- 평어,평점 셀렉트문에 추가하기

create or replace view vw_full_studentData
as;
select  s.stdNo, -- 학번
	s.stdName,  -- 이름
	s.deptCode,  -- 학과코드
	d.deptName,   -- 학과명
	s.grade,  -- 학년
	s.stateCode, -- 학적코드
	st.stateName,  -- 학적상태
	s.militaryCode,  -- 병역코드
	m.militaryName,  -- 병역구분
	s.idNo,  -- 주민번호/         성별도 출력되게해야하는디!!! 자바에서  총점,평균이랑 같이 메소드??
	if(substr(idNo,7,1)=1,'남','여') as gender,
-- 	substr(idNo, 7, 1) as gender,
-- 	(select idNo from studentmanagement where idNo = '1') as gender ,
-- 	(select idNo as gender from studentmanagement where idNo = '2') as '여',
	s.hpNo,   -- 연락처
	s.dayNightShift, -- 주야구분
	ss.subject1,  -- 과목1 성적
	ss.subject2,  -- 과목2성적
	ss.subject3,   --  과목3 성적                              총점,평균 ??
	(ss.subject1+ss.subject2+ss.subject3) as 'total',
	((ss.subject1+ss.subject2+ss.subject3)/3) as 'avg'
	
from studentData s join stdDepartment d  on s.deptCode = d.deptCode 
left join stdState st on s.stateCode =st.stateCode 
left join militaryState m on s.militaryCode = m.militaryCode
left join studentScore ss on s.stdNo =ss.stdNo ;

left join gradeConvertion gd on ss.subject1 	


select * from gradeConvertion;
-- ----------------------------------------------------------sin
select s.stdNo, s.stdName, s.dirth, s.social, dayTimeno, dayTimename, deptno, deptname, grade, atdno, atdname, miltno, miltname,pic
from students 
join days d on s.dayTime =d.dayTimeno 
join department d2 on s.dept = d2.deptno 
join attendings a on s.atd = a.atdno 
join militarys m on s.milt =m.miltno  + s