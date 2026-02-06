
CREATE DATABASE demores_db;

CREATE TABLE authors
(
    author_id serial PRIMARY KEY,
    name varchar(100) NOT NULL,
    gender varchar(10)  NOT NULL
);

CREATE TABLE books
(
    book_id serial PRIMARY KEY,
    name varchar NOT NULL,
    published_date timestamp NOT NULL,
    author_id integer NOT NULL
    CONSTRAINT fk_author
    REFERENCES authors
    ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE categories
(
    category_id serial PRIMARY KEY,
    name varchar(100) NOT NULL
);


CREATE TABLE book_category
(
    book_id integer NOT NULL
        CONSTRAINT fk_book
        REFERENCES books
        ON UPDATE CASCADE ON DELETE CASCADE,
    category_id integer NOT NULL
        CONSTRAINT fk_category
        REFERENCES categories
        ON UPDATE CASCADE ON DELETE CASCADE,
        PRIMARY KEY (book_id, category_id)
);

INSERT INTO authors (name, gender) VALUES
                                       ('J.K. Rowling', 'Female'),
                                       ('George Orwell', 'Male'),
                                       ('Agatha Christie', 'Female'),
                                       ('J.R.R. Tolkien', 'Male'),
                                       ('Haruki Murakami', 'Male');

INSERT INTO categories (name) VALUES
                                  ('Fantasy'),
                                  ('Dystopian'),
                                  ('Mystery'),
                                  ('Adventure'),
                                  ('Literary Fiction');


INSERT INTO books (name, published_date, author_id) VALUES
                                                        ('Harry Potter and the Philosophers Stone', '1997-06-26', 1),
                                                        ('Harry Potter and the Chamber of Secrets', '1998-07-02', 1),
                                                        ('1984', '1949-06-08', 2),
                                                        ('Animal Farm', '1945-08-17', 2),
                                                        ('The Hobbit', '1937-09-21', 4),
                                                        ('The Lord of the Rings', '1954-07-29', 4),
                                                        ('Murder on the Orient Express', '1934-01-01', 3),
                                                        ('Norwegian Wood', '1987-09-04', 5);

INSERT INTO book_category (book_id, category_id) VALUES
                                                     (1, 1), -- Harry Potter (Fantasy)
                                                     (2, 1), -- Harry Potter (Fantasy)
                                                     (3, 2), -- 1984 (Dystopian)
                                                     (4, 2), -- Animal Farm (Dystopian)
                                                     (5, 4), -- The Hobbit (Adventure)
                                                     (6, 1), -- The Lord of the Rings (Fantasy)
                                                     (7, 3), -- Murder on the Orient Express (Mystery)
                                                     (8, 5); -- Norwegian Wood (Literary Fiction)