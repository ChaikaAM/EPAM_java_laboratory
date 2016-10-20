DROP SCHEMA test_schema CASCADE;

CREATE SCHEMA IF NOT EXISTS test_schema;
SET SCHEMA 'test_schema';

DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS job_history;
DROP TABLE IF EXISTS position;
DROP TABLE IF EXISTS employer;

CREATE SEQUENCE person_seq;

CREATE TABLE person (
  person_id  INTEGER,
  first_name VARCHAR(255),
  last_name  VARCHAR(255),
  age        INTEGER,
  PRIMARY KEY (person_id)
);

CREATE SEQUENCE employee_seq;

CREATE TABLE employee (
  employee_id INTEGER PRIMARY KEY,
  person_id   INTEGER
);

ALTER TABLE employee ADD CONSTRAINT newForeignKey
FOREIGN KEY (person_id) REFERENCES person (person_id);


CREATE TABLE position (
  position_code VARCHAR(64),
  name          VARCHAR(255),
  description   VARCHAR(255),
  PRIMARY KEY (position_code)
);

CREATE TABLE employer (
  employer_code VARCHAR(255),
  name          VARCHAR(255),
  description   VARCHAR(255),
  PRIMARY KEY (employer_code)
);

CREATE TABLE job_history (
  employee_id   INTEGER,
  position_code VARCHAR(64),
  employer_code VARCHAR(64),
  duration      INTEGER,
  FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
  FOREIGN KEY (position_code) REFERENCES position (position_code)
);

ALTER TABLE job_history ADD CONSTRAINT employee_code_for_key
FOREIGN KEY (employer_code) REFERENCES employer (employer_code);

DELETE FROM employer;

INSERT INTO employer (employer_code, name, description)
VALUES ('epam', 'employer1', 'epam systems');

INSERT INTO employer (employer_code, name, description)
VALUES ('google', 'Google', 'google.com');

INSERT INTO employer (employer_code, name, description)
VALUES ('ya', 'yandex', 'yandex.ru');

INSERT INTO employer (employer_code, name, description)
VALUES ('abc', 'ABC', 'abc descriptioin');


DELETE FROM position;

INSERT INTO position (position_code, name, description)
  SELECT
    'dev',
    'developer',
    'Application developer'
  UNION ALL SELECT
              'QA',
              'QA',
              'Quality assurance'
  UNION ALL SELECT
              'BA',
              'BA',
              'Business analyst';

DELETE FROM person;

INSERT INTO person (person_id, first_name, last_name, age)
  SELECT
    nextval('person_seq'),
    'John',
    'Doe',
    25
  UNION ALL SELECT
              nextval('person_seq'),
              'John2',
              'Doe2',
              225;

DELETE FROM employee;

INSERT INTO employee (employee_id, person_id)
  SELECT
    1,
    1
  UNION ALL SELECT
              2,
              2;

DELETE FROM job_history;
INSERT INTO job_history (employee_id, position_code, employer_code, duration)
  SELECT
    1,
    'dev',
    'epam',
    10
  UNION ALL SELECT
              2,
              'dev',
              'google',
              5;

DELETE FROM job_history
WHERE employee_id = 2;