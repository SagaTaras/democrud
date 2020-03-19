DROP TABLE IF EXISTS EMPLOYEES;

CREATE TABLE EMPLOYEES(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  SURNAME VARCHAR(250) NOT NULL,
  AGE NUMBER NOT NULL,
);

INSERT INTO EMPLOYEES (NAME, SURNAME, AGE) VALUES
  ('Donald', 'Trump', 73),
  ('George', 'Clooney', 58),
  ('John', 'Travolta', 66),
  ('Keanu', 'Reeves', 55),
  ('Chuck', 'Norris', 80),
  ('Hugh', 'Laurie', 60);