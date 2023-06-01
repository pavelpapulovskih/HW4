CREATE TABLE IF NOT EXISTS employee_info
(id integer PRIMARY KEY,
first_name text NOT NULL,
last_name text NOT NULL,
hone_number text NOT NULL);

INSERT INTO employee_info(first_name, last_name, hone_number) VALUES(?,?,?);
INSERT INTO employee_info(first_name, last_name, hone_number) VALUES(?,?,?);
INSERT INTO employee_info(first_name, last_name, hone_number) VALUES(?,?,?);

