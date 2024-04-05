-- DATE 자료형에서 YEAR(), MONTH(), DAY()로 정보 추출

select COUNT(ID) as FISH_COUNT, MONTH(TIME) as MONTH from FISH_INFO group by MONTH(TIME) order by MONTH;
