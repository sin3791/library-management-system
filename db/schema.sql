CREATE DATABASE library_db;
USE library_db;
DESC users;

ALTER TABLE users
ADD COLUMN login_id VARCHAR(50) NOT NULL UNIQUE AFTER id;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    is_available BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE loans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    loaned_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    due_at TIMESTAMP NOT NULL,
    returned_at TIMESTAMP NULL,

    CONSTRAINT fk_loans_user
        FOREIGN KEY (user_id) REFERENCES users(id),

    CONSTRAINT fk_loans_book
        FOREIGN KEY (book_id) REFERENCES books(id)
);

select * from loans; 
select * from users; 
select * from books; 