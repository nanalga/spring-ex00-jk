USE test;

DESC Member;

CREATE TABLE Mytable31 (
	id INT PRIMARY KEY AUTO_INCREMENT,
    prefix VARCHAR(10)
);

INSERT INTO Mytable31 (prefix) VALUES ('testid');

INSERT INTO Mytable31 (prefix) SELECT prefix FROM Mytable31;

SELECT COUNT(*) FROM Mytable31;

INSERT INTO Member (id, password, email, address, nickName)
SELECT concat(prefix, id), 'pw', concat(prefix, id, '@gmail.com'), 'seoul', concat(prefix, id) FROM Mytable31;

SELECT count(*) FROM Member;

SELECT * FROM Board;
DESC Board;