CREATE TABLE students (
   id INT NOT NULL,
   firstname VARCHAR(50) NOT NULL,
   lastname VARCHAR(20) NOT NULL,
   age INT NOT NULL,
   flgdel INT DEFAULT 0
);

INSERT INTO students (id, firstname, lastname, age) VALUES (1, 'Maria', 'Aguirre', 23);
INSERT INTO students (id, firstname, lastname, age) VALUES (2, 'Carlos', 'Acero', 22);
INSERT INTO students (id, firstname, lastname, age) VALUES (3, 'Marco', 'Nieves', 24);
INSERT INTO students (id, firstname, lastname, age) VALUES (4, 'Julia', 'Correa', 21);
INSERT INTO students (id, firstname, lastname, age) VALUES (5, 'Luis', 'Sarmiento', 17);
INSERT INTO students (id, firstname, lastname, age, flgdel) VALUES (6, 'Jorge', 'Salas', 18, 1);
