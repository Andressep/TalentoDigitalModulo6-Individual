
INSERT INTO cursos (nombre_curso) VALUES ('Java 0057');
INSERT INTO cursos (nombre_curso) VALUES ('Python 0030');
INSERT INTO cursos (nombre_curso) VALUES ('Javascript 101');
INSERT INTO cursos (nombre_curso) VALUES ('UX/UI');

INSERT INTO alumnos (nombres, apellido_paterno, apellido_materno, curso_id) VALUES ('Andres', 'Sepulveda', 'Valenzuela', 1);
INSERT INTO alumnos (nombres, apellido_paterno, apellido_materno) VALUES ('Luis', 'Sepulveda', 'Lushito');
INSERT INTO alumnos (nombres, apellido_paterno, apellido_materno) VALUES ('Diego', 'Chino', 'Fuenzalida');
INSERT INTO alumnos (nombres, apellido_paterno, apellido_materno) VALUES ('Diego', 'Blanco', 'Mansilla');

INSERT INTO profesores (nombres, apellido_paterno, apellido_materno) VALUES ('Andres', 'Sepulveda', 'Valenzuela');
INSERT INTO profesor_curso (profesor_id, curso_id) VALUES (1, 1);
INSERT INTO profesor_curso (profesor_id, curso_id) VALUES (1, 2);

INSERT INTO usuarios (nombre_usuario, contrasena, rol) VALUES ('Jefe1', '123456', 'Jefesito');

