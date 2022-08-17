--INSERT INTO CATEGORIA (id, name, code) VALUES (1, 'programador', 001);
--INSERT INTO CATEGORIA (id, name, code) VALUES (2, 'comerciante', 002);
--
--INSERT INTO CLIENT (id, name, age, vat, email, categoria_id) VALUES (1, 'Lulax', 21, 'XX999999991', 'lulax@gmail.com', 1);
--INSERT INTO CLIENT (id, name, age, vat, email, categoria_id) VALUES (2, 'Tulax', 22, 'XX999999992', 'tulax@gmail.com', 2);

INSERT INTO CATEGORIA ( id, name, code) VALUES (nextval('hibernate_sequence'), 'programador', 001);
INSERT INTO CATEGORIA ( id, name, code) VALUES (nextval('hibernate_sequence'), 'comerciante', 002);

INSERT INTO CLIENT (id, name, age, vat, email, categoria_id) VALUES (
    nextval('hibernate_sequence'), 'Lulax', 21, 'XX999999991', 'lulax@gmail.com',
    (SELECT ID FROM CATEGORIA  WHERE NAME = 'programador' )
);
--INSERT INTO CLIENT (name, age, vat, email, categoria_id) VALUES ('Tulax', 22, 'XX999999992', 'tulax@gmail.com', 2);

