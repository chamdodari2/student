-- student
CREATE SCHEMA student;

-- 관리자 계정   -- id varchar로 수정하기
CREATE TABLE student.users ( 
	id   int(20)     NOT NULL COMMENT '아이디', -- 아이디
	pass   CHAR(41)     NOT NULL COMMENT '비밀번호', -- 비밀번호
	grants   boolean  NOT NULL COMMENT '권한유무' -- 권한유무
)COMMENT '관리자 계정';



-- 병역
CREATE TABLE student.militaryState (
	militaryCode VARCHAR(3) NOT NULL COMMENT '병역코드', -- 병역코드
	militaryName VARCHAR(2) NOT NULL COMMENT '병역구분' -- 병역구분
)
COMMENT '병역';

-- 병역
ALTER TABLE student.militaryState
	ADD CONSTRAINT
		PRIMARY KEY (
			militaryCode -- 병역코드
		);

-- 성적 환산표
CREATE TABLE student.gradeConvertion (
	scoreMin   INT(3)     NOT NULL COMMENT '최소실점수', -- 최소실점수
	scoreMax   INT(3)     NOT NULL COMMENT '최대실점수', -- 최대실점수
	grade      VARCHAR(1) NOT NULL COMMENT '평어', -- 평어
	gradescore DOUBLE     NOT NULL COMMENT '평점' -- 평점
)
COMMENT '성적 환산표';

-- 학생성적
CREATE TABLE student.studentScore (
	stdNo    INT(8) NOT NULL COMMENT '학번', -- 학번
	subject1 INT(3) NULL     COMMENT '1과목', -- 1과목
	subject2 INT(3) NULL     COMMENT '2과목', -- 2과목
	subject3 INT(3) NULL     COMMENT '3과목' -- 3과목
)
COMMENT '학생성적';

-- 학생성적
ALTER TABLE student.studentScore
	ADD CONSTRAINT
		PRIMARY KEY (
			stdNo -- 학번
		);

-- 학생정보
CREATE TABLE student.studentData (
	stdNo         INT(8)      NOT NULL COMMENT '학번', -- 학번
	stdName       VARCHAR(5)  NOT NULL COMMENT '이름', -- 이름
	deptCode      VARCHAR(1)  NOT NULL COMMENT '학과코드', -- 학과코드
	grade         INT(1)      NOT NULL COMMENT '학년', -- 학년
	stateCode     VARCHAR(3)  NOT NULL COMMENT '학적코드', -- 학적코드
	militaryCode  VARCHAR(3)  NOT NULL COMMENT '병역코드', -- 병역코드
	idNo          VARCHAR(13) NOT NULL COMMENT '주민번호', -- 주민번호
	hpNo          VARCHAR(13) NULL     COMMENT '연락처', -- 연락처
	dayNightShift VARCHAR(2)  NOT NULL COMMENT '주야' -- 주야
)
COMMENT '학생정보';

-- 학생정보
ALTER TABLE student.studentData
	ADD CONSTRAINT
		PRIMARY KEY (
			stdNo -- 학번
		);

-- 학과
CREATE TABLE student.stdDepartment (
	deptCode VARCHAR(1) NOT NULL COMMENT '학과코드', -- 학과코드
	deptName VARCHAR(5) NOT NULL COMMENT '학과명' -- 학과명
)
COMMENT '학과';

-- 학과
ALTER TABLE student.stdDepartment
	ADD CONSTRAINT
		PRIMARY KEY (
			deptCode -- 학과코드
		);

-- 학적상태
CREATE TABLE student.stdState (
	stateCode VARCHAR(3) NOT NULL COMMENT '학적코드', -- 학적코드
	stateName VARCHAR(2) NOT NULL COMMENT '학적구분' -- 학적구분
)
COMMENT '학적상태';

-- 학적상태
ALTER TABLE student.stdState
	ADD CONSTRAINT
		PRIMARY KEY (
			stateCode -- 학적코드
		);

-- 학생정보
ALTER TABLE student.studentData
	ADD CONSTRAINT FK_department_TO_studentManagement -- FK_department_TO_studentManagement
		FOREIGN KEY (
			deptCode -- 학과코드
		)
		REFERENCES student.stdDepartment ( -- 학과
			deptCode -- 학과코드
		)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	ADD INDEX FK_department_TO_studentManagement (
		deptCode -- 학과코드
	);

-- 학생정보
ALTER TABLE student.studentData
	ADD CONSTRAINT FK_militaryState_TO_studentManagement -- FK_militaryState_TO_studentManagement
		FOREIGN KEY (
			militaryCode -- 병역코드
		)
		REFERENCES student.militaryState ( -- 병역
			militaryCode -- 병역코드
		)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	ADD INDEX FK_militaryState_TO_studentManagement (
		militaryCode -- 병역코드
	);

-- 학생정보
ALTER TABLE student.studentData
	ADD CONSTRAINT FK_stdState_TO_studentManagement -- FK_stdState_TO_studentManagement
		FOREIGN KEY (
			stateCode -- 학적코드
		)
		REFERENCES student.stdState ( -- 학적상태
			stateCode -- 학적코드
		)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	ADD INDEX FK_stdState_TO_studentManagement (
		stateCode -- 학적코드
	);

-- 학생성적
ALTER TABLE student.studentScore
	ADD CONSTRAINT FK_studentManagement_TO_studentScore -- FK_studentManagement_TO_studentScore
		FOREIGN KEY (
			stdNo -- 학번
		)
		REFERENCES student.studentData ( -- 학생정보
			stdNo -- 학번
		)
		ON DELETE CASCADE
		ON UPDATE CASCADE;