START TRANSACTION;

DROP DATABASE IF EXISTS felix;
CREATE DATABASE felix;
USE felix;

-- Authors of books, CDs, DVDs
CREATE TABLE authors (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    year_of_birth YEAR NOT NULL,

    PRIMARY KEY(id),
    UNIQUE(name, surname, year_of_birth),
    CONSTRAINT non_future_year CHECK (publication_year <= YEAR(NOW()))
);

-- Films' actors
CREATE TABLE actors (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    year_of_birth YEAR NOT NULL,

    PRIMARY KEY(id),
    UNIQUE(name, surname, year_of_birth),
    CONSTRAINT non_future_year CHECK (publication_year <= YEAR(NOW()))
);

-- CDs' tracks
CREATE TABLE tracks (
    name VARCHAR(70) NOT NULL,
    duration INT,

    PRIMARY KEY(name)
);

CREATE TABLE genres (
    name VARCHAR(30) NOT NULL;

    PRIMARY KEY(name)
);

-- Registered users of library system
CREATE TABLE registered (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(30),
    surname VARCHAR(30),
    date_of_birth DATE NOT NULL,

    PRIMARY KEY(id),
    UNIQUE(name, surname, date_of_birth),
    CONSTRAINT non_future_date CHECK (date_of_birth <= NOW())
);

CREATE TABLE libraries_locations (
    id INT AUTO_INCREMENT NOT NULL,
    city VARCHAR(30) NOT NULL,
    address VARCHAR(50) NOT NULL,

    PRIMARY KEY(id),
    UNIQUE(city, address)
);

CREATE TABLE editors (
    name VARCHAR(50) NOT NULL,

    PRIMARY KEY(name)
);

CREATE TABLE producers (
    name VARCHAR(50) NOT NULL,

    PRIMARY KEY(name)
);

-- Negative values for publication_year represents B.C. years
CREATE TABLE books (
    id INT AUTO_INCREMENT NOT NULL,
    title VARCHAR(50) NOT NULL,
    publication_year INT NOT NULL,
    publication_month INT NULL,
    editor VARCHAR(50) NOT NULL,
    isbn_10 CHAR(10) NOT NULL,
    isbn_13 CHAR(13) NOT NULL,

    PRIMARY KEY(id),
    UNIQUE(isbn_10, isbn_13),
    FOREIGN KEY (editor) REFERENCES editors(name)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT valid_month CHECK ((publication_month >= 1 AND publication_month <= 12) OR publication_month = NULL),
    CONSTRAINT non_future_year CHECK (publication_year <= YEAR(NOW()))
);

CREATE TABLE cds (
    id INT AUTO_INCREMENT NOT NULL,
    title VARCHAR(50) NOT NULL,
    production_year INT NOT NULL,
    production_month INT NULL,

    PRIMARY KEY(id),
    UNIQUE(title, production_year)
    CONSTRAINT valid_month CHECK ((production_month >= 1 AND production_month <= 12) OR production_month = NULL),
    CONSTRAINT non_future_year CHECK (publication_year <= YEAR(NOW()))
);

CREATE TABLE dvds (
    id INT AUTO_INCREMENT NOT NULL,
    title VARCHAR(50) NOT NULL,
    production_year INT NOT NULL,
    production_month INT NULL,

    PRIMARY KEY(id),
    UNIQUE(title, production_year),
    CONSTRAINT valid_month CHECK (production_month >= 1 AND production_month <= 12),
    CONSTRAINT non_future_year CHECK (publication_year <= YEAR(NOW()))
);

CREATE TABLE authors_books (
    book_id INT NOT NULL,
    author_id INT NOT NULL,

    PRIMARY KEY(book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (author_id) REFERENCES authors(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE editors_books (
    book_id INT NOT NULL,
    editor_id INT NOT NULL,

    PRIMARY KEY(book_id, editor_id),
    FOREIGN KEY (book_id) REFERENCES books(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (editor_id) REFERENCES editors(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE genres_books (
    book_id INT NOT NULL,
    genre_id INT NOT NULL,

    PRIMARY KEY(book_id, genre_id),
    FOREIGN KEY (book_id) REFERENCES books(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE authors_cds (
    cd_id INT NOT NULL,
    author_id INT NOT NULL,

    PRIMARY KEY(cd_id, author_id),
    FOREIGN KEY (cd_id) REFERENCES cds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (author_id) REFERENCES authors(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE producers_cds (
    cd_id INT NOT NULL,
    producer_id INT NOT NULL,

    PRIMARY KEY(cd_id, producer_id),
    FOREIGN KEY (cd_id) REFERENCES cds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (producer_id) REFERENCES producers(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE genres_cds (
    cd_id INT NOT NULL,
    genre_id INT NOT NULL,

    PRIMARY KEY(cd_id, genre_id),
    FOREIGN KEY (cd_id) REFERENCES cds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE tracks_cds (
    cd_id INT NOT NULL,
    track_id INT NOT NULL,

    PRIMARY KEY(cd_id, track_id),
    FOREIGN KEY (cd_id) REFERENCES cds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (track_id) REFERENCES tracks(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
)

CREATE TABLE authors_dvds (
    dvd_id INT NOT NULL,
    author_id INT NOT NULL,

    PRIMARY KEY(dvd_id, author_id),
    FOREIGN KEY (dvd_id) REFERENCES dvds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (author_id) REFERENCES authors(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE producers_dvds (
    dvd_id INT NOT NULL,
    producer_id INT NOT NULL,

    PRIMARY KEY(dvd_id, producer_id),
    FOREIGN KEY (dvd_id) REFERENCES dvds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (producer_id) REFERENCES producers(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE genres_dvds (
    dvd_id INT NOT NULL,
    genre_id INT NOT NULL,

    PRIMARY KEY(dvd_id, genre_id),
    FOREIGN KEY (dvd_id) REFERENCES dvds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE actors_dvds (
    dvd_id INT NOT NULL,
    actor_id INT NOT NULL,

    PRIMARY KEY(dvd_id, actor_id),
    FOREIGN KEY (dvd_id) REFERENCES dvds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (actor_id) REFERENCES actors(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE interlibrary_exchanges (
    item_id INT NOT NULL,
    item_type ENUM('book', 'cd', 'dvd') NOT NULL,
    sender_location_id INT NOT NULL,
    recepient_location_id INT NOT NULL,
    exchange_date DATE NOT NULL DEFAULT NOW(),

    PRIMARY KEY (item_id, item_type, sender_location_id, recepient_location_id, exchange_date),
    CONSTRAINT different_sender_recepient CHECK (sender_location_id <> recepient_location_id),
    FOREIGN KEY (sender_location_id) REFERENCES locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (recepient_location_id) REFERENCES locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE items_locations (
    item_id INT NOT NULL,
    item_type ENUM('book', 'cd', 'dvd') NOT NULL,
    location_id INT NOT NULL,
    filing_date DATE NOT NULL DEFAULT NOW(),
    pick_up_date DATE NULL,

    PRIMARY KEY (item_id, item_type, location_id, filing_date),
    CONSTRAINT non_future_filing_date CHECK (filing_date <= NOW()),
    CONSTRAINT non_future_pick_up_date CHECK (pick_up_date <= NOW() OR pick_up_date = NULL),
    CONSTRAINT non_crossed_dates CHECK (filing_date <= pick_up_date OR pick_up_date = NULL)
    FOREIGN KEY (location_id) REFERENCES locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE loans (
    item_id INT NOT NULL,
    item_type ENUM('book', 'cd', 'dvd') NOT NULL,
    location_id INT NOT NULL,
    registered_id INT NOT NULL,
    filing_date DATE NOT NULL DEFAULT NOW(),
    pick_up_date DATE NULL,

    PRIMARY KEY (item_id, item_type, location_id, registered_id, filing_date),
    CONSTRAINT non_future_filing_date CHECK (filing_date <= NOW()),
    CONSTRAINT non_future_pick_up_date CHECK (pick_up_date <= NOW() OR pick_up_date = NULL),
    CONSTRAINT non_crossed_dates CHECK (filing_date <= pick_up_date OR pick_up_date = NULL)
    FOREIGN KEY location_id REFERENCES locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY registered_id REFERENCES registered(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
)

COMMIT;