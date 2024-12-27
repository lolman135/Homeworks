CREATE TABLE student (
    id SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE homework (
    id SERIAL PRIMARY KEY,
    description VARCHAR(150) NOT NULL,
    deadline DATE,
    mark INT,
    student_id BIGINT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);