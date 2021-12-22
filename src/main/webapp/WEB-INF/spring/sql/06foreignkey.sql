USE test;

DESC Board;
DESC Member;

-- delete duplicated member id
DELETE FROM Member WHERE id IN(
SELECT id FROM Member GROUP BY id HAVING count(id) > 1);

-- add primary key
ALTER TABLE Member
ADD PRIMARY KEY (id);

-- Board.writer가 Member.id 참조
ALTER TABLE Board
ADD FOREIGN KEY (writer) REFERENCES Member(id);

-- 탈퇴한 아이디의 게시물을 삭제
DELETE FROM Board WHERE id IN
(
SELECT b.id FROM Board b LEFT JOIN Member m ON b.writer = m.id
WHERE m.id IS NULL
);

-- 삭제 된 게시물의 댓글 삭제
DELETE FROM Reply WHERE id IN
(
SELECT r.id FROM Reply r LEFT JOIN Board b ON r.boardId = b.id
WHERE b.id IS NULL
);

-- 탈퇴멤버의 댓글 삭제
DELETE FROM Reply WHERE id IN
(
SELECT r.id FROM Reply r LEFT JOIN Member m ON r.memberId = m.id
WHERE m.id IS NULL
);
select * from Reply;

-- Reply boardId 가 Board id 를 참조
ALTER TABLE Reply
ADD FOREIGN KEY (boardId) REFERENCES Board(id);

-- Reply member id 가 member id를 참조
ALTER TABLE Reply
ADD FOREIGN KEY (memberId) REFERENCES Member(id);

DESC Reply;

SELECT * FROM Board;