insert into stdState values
('hla','재학'),
('hlb','휴학'),
('hlc','졸업'),
('hld','제적');

select * from stdstate;

insert  into militaryState values
('y2a','미필'),
('y2b','군필'),
('y2c','면제');
select * from militaryState ;

insert into gradeConvertion  values
(91,100,'A',4.5),
(81,90,'B',3.5),
(71,80,'C',2.5),
(61,70,'D',1.5),
(0,60,'F',0);

select * from gradeconvertion;


select * from stdDepartment ;
insert into stdDepartment values
(1,'컴퓨터정보'),
(2,'자동차공학'),
(3,'산업설비');



select * from  stdDepartment;  -- 학과
select * from  gradeConvertion;  -- 성적환산표
select * from  militaryState;  -- 병역
select * from  stdState;  -- 학적상태
select * from  studentData;  -- 학생정보
select * from  studentScore;



insert into  studentData  (stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNightShift ) values
(18020017,'박재선','2',1,'hla','y2a','9608061******','010-1234-5601','주간'),
(18010016,'한동성','1',1,'hla','y2a','9809201******','010-1234-5602','주간'),
(17010012,'박태준','1',2,'hlb','y2a','9710111******','010-1234-5603','야간'),
(18020028,'정정일','2',1,'hlb','y2a','9812261******','010-1234-5604','주간'),
(18020015,'정연희','2',1,'hla','y2a','9811122******','010-1234-5605','주간'),
(17030001,'유기수','3',2,'hlb','y2c','9783241******','010-1234-5606','야간'),
(18010018,'임정만','1',2,'hla','y2a','9702281******','010-1234-5607','주간'),
(18010030,'박선호','1',1,'hla','y2b','9408061******','010-1234-5608','야간'),
(18020001,'임성준','2',1,'hla','y2a','9803011******','010-1234-5609','주간'),
(18020029,'이준민','2',1,'hla','y2a','9806051******','010-1234-5610','주간'),
(18010019,'이강길','1',1,'hlb','y2a','9811271******','010-1234-5611','주간'),
(18020037,'하예준','1',1,'hla','y2b','9512251******','010-1234-5612','야간'),
(18020027,'박다영','3',1,'hla','y2a','9811172******','010-1234-5613','주간'),
(18020026,'여효수','1',1,'hla','y2b','8810191******','010-1234-5614','주간'),
(18020010,'진인우','1',1,'hla','y2a','9804301******','010-1234-5615','주간'),
(16020026,'여효수','1',3,'hla','y2b','8810191******','010-1234-5614','주간'),
(16020010,'진인우','1',3,'hla','y2a','9804301******','010-1234-5615','주간'),
(15020026,'여효수','1',4,'hla','y2b','8810191******','010-1234-5614','주간'),
(15020010,'진인우','1',4,'hla','y2a','9804301******','010-1234-5615','주간');

insert into  studentScore values
(18020017,100,80,90),
(18010016,80,60,90),
(17010012,50,60,80),
(18020028,56,100,88),
(18020015,6,65,88),
(17030001,100,64,51),
(18010018,81,94,51),
(18010030,92,83,92),
(18020001,94,85,61),
(18020029,15,27,34),
(18010019,42,85,61),
(18020037,66,42,49),
(18020027,85,15,90),
(18020026,77,51,67),
(18020010,42,29,88),
(16020026,50,50,50),
(16020010,67,67,85),
(15020026,89,73,55),
(15020010,60,60,90);





