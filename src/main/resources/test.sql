

SELECT p.id, p.name , ps.id, ps.model
FROM users p
INNER JOIN autos ps ON ps.user_id = p.id