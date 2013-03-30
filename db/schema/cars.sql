USE sandbox;

DROP TABLE IF EXISTS cars;
CREATE TABLE cars
(
	Car_Number		int unsigned NOT NULL,	# Unique ID for the employee
	Make			varchar(255) NOT NULL,				
	Model			varchar(255) NOT NULL,
	Year			int unsigned NOT NULL,

	PRIMARY KEY		(Car_Number)
);