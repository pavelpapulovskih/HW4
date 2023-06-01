CREATE TABLE credit
(credit_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 balance VARCHAR(35) NOT NULL,
 open_date timestamp NOT NULL,
 close_date timestamp NOT NULL,
 summ VARCHAR(35) NOT NULL,
 number VARCHAR(30) NOT NULL,
 status VARCHAR(30) NOT NULL,
 employee_id INT NOT NULL,
 client_id INT NOT NULL,
 FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
 FOREIGN KEY (client_id) REFERENCES client (client_id)
);