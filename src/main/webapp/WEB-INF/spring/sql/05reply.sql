USE test;

DESC Member;

CREATE TABLE Reply (
	id INT PRIMARY KEY AUTO_INCREMENT,
	boardId INT NOT NULL,
    reply VARCHAR(500) NOT NULL,
    memberId VARCHAR(30) NOT NULL,
    inserted DATETIME NOT NULL DEFAULT NOW(),
    updated DATETIME NOT NULL DEFAULT NOW()
);

SELECT * FROM Board ORDER BY id DESC;	-- 792
SELECT * FROM Member ORDER BY inserted DESC; -- testMyID11

-- test 데이터 입력
INSERT INTO Reply (boardId, reply, memberId) VALUES (792, '테스트용 댓글!@!@!@!@!@', 'testMyID11');

SELECT * FROM Reply ORDER BY inserted DESC;

SELECT * FROM Member ORDER BY inserted DESC;

SELECT  r.id, r.boardId, r.memberId, r.reply, r.inserted, r.updated, m.nickName
FROM Reply r JOIN Member m ON r.memberId = m.id
WHERE r.boardId = 792
  	ORDER BY
  		id DESC;
