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

-- 게시물의 댓글수 
SELECT 
    b.id,
    b.title,
    b.content,
    b.writer,
    b.inserted,
    b.updated,
    m.nickName,
    count(r.id) replyCount
FROM
    Board b
      JOIN
    Member m ON b.writer = m.id
	  LEFT JOIN
    Reply r ON b.id = r.boardId
GROUP BY b.id
ORDER BY b.id DESC
LIMIT 0, 10;

DESC Reply;
