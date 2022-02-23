## 아이디어
`DATE_FORMAT()` 함수를 이용해 `DATETIME` 형을 원하는 형태로 변경
```MySQL
select ANIMAL_ID, NAME, date_format(DATETIME, '%Y-%m-%d') from ANIMAL_INS;
```
