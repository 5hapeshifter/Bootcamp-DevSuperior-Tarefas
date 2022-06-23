INSERT INTO tb_user (name, email, password) VALUES ('bob', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('ana', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('Terror');
INSERT INTO tb_genre (name) VALUES ('Comedia');

INSERT INTO tb_movie (title, subtitle, year, img_url, synopsis, genre_id) VALUES ('Halloween Kills', 'Kills', 2021, 'halloween-kills-critica-.jpeg', 'Em Halloween Kills: O Terror Continua, depois de quatro décadas se preparando para enfrentar Michael Myers', 1);
INSERT INTO tb_movie (title, subtitle, year, img_url, synopsis, genre_id) VALUES ('As Branquelas', 'Kills', 2004, 'whitechicks1_940x529.jpg', 'White-Chicks', 2);

INSERT INTO tb_review (text, movie_id, user_id) VALUES ('Greate Movie', 1, 1);
INSERT INTO tb_review (text, movie_id, user_id) VALUES ('Funny Movie', 2, 2);