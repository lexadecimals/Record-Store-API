DROP TABLE if EXISTS albums;

CREATE TABLE albums (
    id serial PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    cover_art_url VARCHAR(255) NOT NULL,
    year_of_release INTEGER,
    price DOUBLE PRECISION,
    genre VARCHAR(50),
    items_in_stock INTEGER
);
