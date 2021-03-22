
-- insert문

insert into StudentData values (
'17010013','김예진','1',2,'hlb','y2a','960828*******','010-9566-0476','주간');

SELECT stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNightShift FROM StudentData;


1004,"천사2", new Title(4), new Employee(1003), 2500000, new Department(1)



-- 업데이트문
update studentdata  set stdNo = 17010013, stdName= '김예진2', deptCode='3', grade='2', stateCode='hla', militaryCode='y2c', idNo='970828*******', hpNo='010-9566-0477', dayNightShift='야간' where stdNo = ; 

-- 삭제

delete from studentData where stdNo = 17010013;






















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
