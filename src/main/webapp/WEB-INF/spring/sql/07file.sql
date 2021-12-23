USE test;

CREATE TABLE File (
	id INT PRIMARY KEY AUTO_INCREMENT,
	boardId INT NOT NULL,
    fileName VARCHAR(255) NOT NULL,
    FOREIGN KEY (boardId) REFERENCES Board(id)
);

DESC File;

SELECT * FROM File ORDER BY boardId DESC, id ASC;

SELECT * FROM Board;

INSERT INTO File (boardId, fileName)
SELECT '1016' as boardId, fileName FROM File WHERE boardId = 1016;