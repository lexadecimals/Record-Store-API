DROP TABLE if EXISTS albums;
DROP TABLE if EXISTS STOCK;

CREATE TABLE albums (
    id serial PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    year_of_release INTEGER,
    price DOUBLE PRECISION,
    genre VARCHAR(50),
    items_in_stock INTEGER
);
