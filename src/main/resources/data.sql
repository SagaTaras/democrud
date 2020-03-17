DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
);

INSERT INTO employees (name) VALUES
  ('Aliko'),
  ('Bill'),
  ('Folrunsho');