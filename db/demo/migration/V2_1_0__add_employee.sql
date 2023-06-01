CREATE TABLE IF NOT EXISTS employee (
id integer PRIMARY KEY,
name text NOT NULL,
capacity real,
info_id integer NOT NULL
);

INSERT INTO employees(name, capacity, info_id) VALUES(?,?,?);
INSERT INTO employees(name, capacity, info_id) VALUES(?,?,?);
INSERT INTO employees(name, capacity, info_id) VALUES(?,?,?);