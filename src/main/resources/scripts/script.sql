CREATE TABLE IF NOT EXISTS CATEGORIA (
   id INT NOT NULL,
   name VARCHAR(100) NOT NULL,
   code VARCHAR(100) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS CLIENT (
   id INT NOT NULL,
   name VARCHAR(100) NOT NULL,
   age INT NOT NULL,
   vat VARCHAR(100) NOT NULL,
   email VARCHAR(100) NOT NULL,
   categoria_id INT NOT NULL,
   PRIMARY KEY (id)
);

ALTER TABLE CLIENT ADD FOREIGN KEY (categoria_id) REFERENCES CATEGORIA (id);

INSERT INTO CATEGORIA (id, name, code) VALUES (991, 'programador', 001);
INSERT INTO CATEGORIA (id, name, code) VALUES (992, 'comerciante', 002);

INSERT INTO CLIENT (id, name, age, vat, email, categoria_id) VALUES (881, 'Lulax', 21, 'XX999999991', 'lulax@gmail.com', 991);
INSERT INTO CLIENT (id, name, age, vat, email, categoria_id) VALUES (882, 'Tulax', 22, 'XX999999992', 'tulax@gmail.com', 992);

