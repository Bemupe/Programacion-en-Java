INSERT INTO PERSONAJE (codigo, nombre, descripcion, tipo)
VALUES (1, 'Han Solo', 'Contrabandista', 'Humano');

INSERT INTO PERSONAJE (codigo, nombre, descripcion, tipo)
VALUES (2, 'Luke Skywalker', 'Jedi hijo de Anakin', 'Jedi');

INSERT INTO PERSONAJE (codigo, nombre, descripcion, tipo)
VALUES (3, 'Leia', 'Princesa hija de Anakin', 'Humano');

INSERT INTO PERSONAJE (codigo, nombre, descripcion, tipo)
VALUES (4, 'C3PO', 'Androide propiedad de Leia', 'Robot');

INSERT INTO PERSONAJE (codigo, nombre, descripcion, tipo)
VALUES (5, 'R2D2', 'Robot propiedad de Leia', 'Robot');

INSERT INTO PERSONAJE (codigo, nombre, descripcion, tipo)
VALUES (6, 'Chewbacca', 'Wookiee del planeta Valmori', 'Wookiee');

INSERT INTO PERSONAJE (codigo, nombre, descripcion, tipo)
VALUES (7, 'Anakin Skywalker', 'Alias Darth Vader', 'Jedi');

INSERT INTO PERSONAJE (codigo, nombre, descripcion, tipo)
VALUES (8, 'Obi-Wan Kenobi', 'Jedi maestro de Anakin', 'Jedi');

INSERT INTO NAVE (idnave, nombre, motores)
VALUES (1, 'Halcón Milenario', 3);

INSERT INTO NAVE (idnave, nombre, motores)
VALUES (2, 'Tie Fighter', 2);

INSERT INTO NAVE (idnave, nombre, motores)
VALUES (3, 'X Wing', 2);

INSERT INTO NAVE (idnave, nombre, motores)
VALUES (4, 'Y Wing', 4);

INSERT INTO NAVE (idnave, nombre, motores)
VALUES (5, 'Lanzadera GR', 8);

INSERT INTO PILOTA (codpersonaje, condnave, fecha,navesabatidas)
VALUES (1,1,'1995-01-29',3);

INSERT INTO PILOTA (codpersonaje, condnave, fecha,navesabatidas)
VALUES (1,1,'2011-02-12',0);

INSERT INTO PILOTA (codpersonaje, condnave, fecha,navesabatidas)
VALUES (2,3,'2010-11-07',5);

INSERT INTO PILOTA (codpersonaje, condnave, fecha,navesabatidas)
VALUES (6,1,'1999-06-05',5);

INSERT INTO PILOTA (codpersonaje, condnave, fecha,navesabatidas)
VALUES (8,5,'2008-12-12',5);

INSERT INTO PILOTA (codpersonaje, condnave, fecha,navesabatidas)
VALUES (8,2,'2009-02-12',8);

