CREATE DATABASE sales_database;

CREATE TABLE sales(
	id SERIAL PRIMARY KEY,
	product VARCHAR(50) NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	quantity INT NOT NULL
);

INSERT INTO sales(product, price, quantity) VALUES
('Laptop', 1000, 5),
('Phone', 700, 3),
('Tablet', 500, 2),
('Printer', 300, 4);

SELECT * FROM sales;

SELECT * FROM sales LIMIT 2;

--SELECT price FROM sales;

SELECT SUM(price) as summary_price FROM sales;

SELECT product, SUM(quantity) as product_count, AVG(price) as average_price 
FROM sales
GROUP BY product;