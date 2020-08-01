USE adlister_db;

INSERT INTO users (id, username, email, password)
VALUES (1, 'greg', 'greg@email', 'codeup'),
       (2, 'joe', 'joe@email', 'password' );

INSERT INTO ads (id, user_id, title, description)
VALUES (1, 1, 'shoes', 'well worn shoes' ),
       (2, 1, 'baseball glove', 'nike brand'),
       (3, 2, 'chess board', 'wooden');