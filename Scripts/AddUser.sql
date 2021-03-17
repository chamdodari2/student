-- 계정권한부여

grant all
on student.*
to 'user_student'@'localhost' identified by 'rootroot';

-- file 권한 (백업, 로드) 루트 구ㅕㅓㄴ한만 부여가능
grant File
on *.*
to 'user_student'@'localhost';


-- 데이터베이스 생성
create database student;
