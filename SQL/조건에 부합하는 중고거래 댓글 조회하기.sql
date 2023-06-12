-- 코드를 입력하세요
 # SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS R.CREATED_DATE
 SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
 FROM USED_GOODS_BOARD AS B INNER JOIN USED_GOODS_REPLY AS R
 ON B.BOARD_ID = R.BOARD_ID
 WHERE DATE_FORMAT(B.CREATED_DATE, '%Y-%m') = '2022-10'
 ORDER BY R.CREATED_DATE ASC, B.TITLE ASC;
 
 
 # SQL 실행 중 오류가 발생하였습니다.
 # You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '.CREATED_DATE FROM USED_GOODS_BOARD AS B INNER JOIN USED_GOODS_REPLY AS R ON B' at line 2
 
 # 위 오류 이유 R.CREATED_DATE 가 아닌 CREATED_DATE로 써야한다. (R.CREATED_DATE는 테이블에서 내가 구분하기 쉽게 하기 위해 만든 컬럼명이지 실제로 테이블에서 R.CREATED_DATE로 존재하지 않는다)
