CREATE TABLE users(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	age INT,
	email VARCHAR(60)
);

INSERT INTO users(name, age, email) VALUES ('John', 30, 'john@example.com');
INSERT INTO users(name, age, email) VALUES ('Alice', 25, 'alice@example.com');
INSERT INTO users(name, age, email) VALUES ('Bob', 30, 'bob@example.com');

SELECT * FROM users;

DELETE FROM users WHERE name = 'Bob';

