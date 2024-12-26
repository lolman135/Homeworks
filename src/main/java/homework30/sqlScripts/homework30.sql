CREATE TABLE IF NOT EXISTS student (
    id SERIAL NOT NULL PRIMARY KEY, 
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL
);


CREATE TABLE IF NOT EXISTS homework (
    id SERIAL NOT NULL PRIMARY KEY,
    description VARCHAR(150) NOT NULL,
    deadline DATE,
    mark INT,
    student_id BIGINT NOT NULL,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);