CREATE TABLE current
(current_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 balance VARCHAR(35) NOT NULL,
 open_date timestamp NOT NULL,
 number VARCHAR(30) NOT NULL,
 emploee_id INT NOT NULL,
 FOREIGN KEY (emploee_id) REFERENCES employee (employee_id)
);