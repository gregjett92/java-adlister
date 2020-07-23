
USE ganymede_adlister_db;

INSERT INTO users (username, email, password) VALUES ('bob123', 'bob123@email.com', 'letmein');
INSERT INTO ads (user_id, title, description) VALUES
    (1, 'A Great Ad 1', 'This is the description for ad 1'),
    (1, 'A Great Ad 2', 'This is the description for ad 2'),
    (1, 'A Great Ad 3', 'This is the description for ad 3'),
    (1, 'A Great Ad 4', 'This is the description for ad 4'),
    (1, 'A Great Ad 5', 'This is the description for ad 5');