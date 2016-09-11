CREATE TABLE IF NOT EXISTS groups (id int, name VARCHAR(50), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT, name VARCHAR(50), groupID INT, PRIMARY KEY (id));

INSERT INTO groups VALUES ('1', 'TestGroup');
INSERT INTO students VALUES ('1', 'TestStudet', '1');