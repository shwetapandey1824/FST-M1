REM   Script: Activity_1_2_3_4_5
REM   This Script is having Activities 1 to 5

CREATE table salesman;

CREATE table salesman(salesman_id INT PRIMARY KEY,salesman_name varchar2(50) NOT NULL,salesman_city varchar2(20),commission int);

DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
Select 1  from DUAL;

SELECT * from salesman;

SELECT salesman_id,salesman_city from salesman;

SELECT * from salesman 
WHERE salesman_city="Paris";

SELECT salesman_id,commission 
    from salesman 
WHERE salesman_name="Paul Adam";

SELECT salesman_id,salesman_city from salesman;

SELECT * from salesman 
WHERE salesman_city='Paris';

SELECT * from salesman 
WHERE salesman_city='Paris';

SELECT salesman_id,commission 
    from salesman 
WHERE salesman_name="Paul Adam";

SELECT salesman_id,salesman_city from salesman;

SELECT * from salesman 
WHERE salesman_city='Paris';

SELECT salesman_id,commission 
    from salesman 
WHERE salesman_name='Paul Adam';

ALTER table salesman 
ADD Grade int;

Update salesman SET Grade = 100;

Select * from salesman;

Update salesman set Grade = 200 Where salesman_city = 'Rome';

Select * from salesman;

DROP table salesman;

CREATE table salesman(salesman_id INT PRIMARY KEY,salesman_name varchar2(50) NOT NULL,salesman_city varchar2(20),commission int);

DESCRIBE salesman


INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
Select 1  from DUAL;

SELECT * from salesman;

SELECT salesman_id,salesman_city from salesman;

Update salesman set Grade = 200 Where salesman_city = 'Rome';

Update salesman set Grade =300 where salesman_name = 'James Hoog';

Update salesman set salesman_name ='Mclyon' where salesman_name='Pierre';

Select * from salesman;

SELECT * from salesman 
WHERE salesman_city='Paris';

SELECT salesman_id,commission 
    from salesman 
WHERE salesman_name='Paul Adam';

ALTER table salesman 
ADD Grade int;

Update salesman SET Grade = 100;

Select * from salesman;

Update salesman set Grade = 200 Where salesman_city = 'Rome';

Update salesman set Grade =300 where salesman_name = 'James Hoog';

Update salesman set salesman_name ='Mclyon' where salesman_name='Pierre';

Select * from salesman;

