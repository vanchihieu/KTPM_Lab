CREATE DATABASE mydatabase;
\c mydatabase;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (username, email) VALUES 
('user1', 'user1@example.com'),
('user2', 'user2@example.com');