USE test;
DESC Board;
DESC Reply;
DESC Member;
SELECT COUNT(*) FROM Board;

INSERT INTO Board (title, content, writer)
(SELECT title, content, writer FROM Board); -- 이미 있는 레코드 복사해서 다시 입력

-- 모든 리스트
SELECT 
    b.id,
    b.title,
    b.content,
    b.writer,
    b.inserted,
    b.updated,
    m.nickName
FROM
    Board b
        LEFT JOIN
    Member m ON b.writer = m.id
ORDER BY id DESC
LIMIT 590, 10 
;
 -- from(0-index), number
 -- page 1 : 0, 10
 -- page 2 : 20, 10
 -- page 3 : 30, 10
 
 SELECT COUNT(*) FROM Member;

REPLACE INTO Member (id, nickName, password, email, address)
(SELECT id, nickName, password, email, address FROM Member);
 
 SELECT * FROM Member ORDER BY inserted DESC;
 
 SELECT 
    m.id,
    m.password,
    m.email,
    m.address,
    m.inserted,
    m.nickName,
    COUNT(b.id) AS numberOfBoard
FROM
    Member m
        LEFT JOIN
    Board b ON m.id = b.writer
GROUP BY m.id
ORDER BY m.inserted DESC
LIMIT 0, 10
;


DELETE FROM Board WHERe id IN(
SELECT 
    b.id
FROM
    Member m
        right JOIN
    Board b ON m.id = b.writer
WHERE m.id is null);