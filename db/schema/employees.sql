USE sandbox;

DROP TABLE IF EXISTS employees;
CREATE TABLE employees
(
	Employee_Number		int unsigned NOT NULL auto_increment,	# Unique ID for the employee
	First_Name		varchar(255) NOT NULL,				
	Last_Name		varchar(255) NOT NULL,
	Date_of_Birth		varchar(255) NOT NULL,
	Car_Number		int unsigned,

	PRIMARY KEY		(Employee_Number)
);