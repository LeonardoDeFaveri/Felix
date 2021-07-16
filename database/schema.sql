START TRANSACTION;

DROP DATABASE IF EXISTS felix;
CREATE DATABASE felix
    CHARACTER SET = 'utf8';
USE felix;

-- Authors of books, CDs, DVDs
CREATE TABLE authors (
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30) DEFAULT NULL,
    surname VARCHAR(30) NOT NULL,
    year_of_birth INT NOT NULL,

    PRIMARY KEY(id),
    UNIQUE(first_name, second_name, surname, year_of_birth)
);

-- Films' actors
CREATE TABLE actors (
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30) DEFAULT NULL,
    surname VARCHAR(30) NOT NULL,
    year_of_birth INT NOT NULL,

    PRIMARY KEY(id),
    UNIQUE(first_name, second_name, surname, year_of_birth)
);

-- CDs' tracks
CREATE TABLE tracks (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(70) NOT NULL,
    duration INT NOT NULL
        CHECK (duration > 0),

    PRIMARY KEY(id),
    UNIQUE(name, duration)
);

CREATE TABLE genres (
    name VARCHAR(30) NOT NULL,

    PRIMARY KEY(name)
);

-- Registered users of library system
CREATE TABLE registered (
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30) DEFAULT NULL,
    surname VARCHAR(30) NOT NULL,
    date_of_birth DATE NOT NULL,

    PRIMARY KEY(id),
    UNIQUE(first_name, second_name, surname, date_of_birth)
);

-- Administrative users:
-- General User (0) [Not represented]:
--      can see all items in the system
-- Library Employee (1):
--      can borrow and take up items, can do interlibrary
--      exchanges, can add/remove/modify an item in its library, can
--      register new users (Registered) and remove/modify them
-- Library Super Employee (2):
--      can add/remove/modify Library Employees
-- Super User (3):
--      can add/remove/modify Library Super Employees
CREATE TABLE administrative_users (
    email VARCHAR(320) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30) DEFAULT NULL,
    surname VARCHAR(30) NOT NULL,
    privilege_level ENUM('Library Employee','Library Super Employee','Super User') NOT NULL DEFAULT 'Library Employee',
    password CHAR(64) NOT NULL,

    PRIMARY KEY(email)
);

-- Locations of all the libraries in the system
CREATE TABLE locations (
    id INT AUTO_INCREMENT NOT NULL,
    city VARCHAR(30) NOT NULL,
    address VARCHAR(50) NOT NULL,

    PRIMARY KEY(id),
    UNIQUE(city, address)
);

CREATE TABLE administrative_users_locations (
    user_email VARCHAR(320) NOT NULL,
    location_id INT NOT NULL,
    from_date DATE NOT NULL DEFAULT NOW(),
    to_date DATE NULL
        CHECK (to_date >= from_date OR to_date = NULL),

    PRIMARY KEY (user_email, location_id, from_date),
    FOREIGN KEY (user_email) REFERENCES administrative_users(email)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (location_id) REFERENCES locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE publishers (
    name VARCHAR(50) NOT NULL,

    PRIMARY KEY(name)
);

CREATE TABLE producers (
    name VARCHAR(50) NOT NULL,

    PRIMARY KEY(name)
);

-- Negative values for year represents B.C. years
CREATE TABLE books (
    id INT AUTO_INCREMENT NOT NULL,
    title VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    month INT DEFAULT NULL
    	CHECK ((month >= 1 AND month <= 12) OR month = NULL),
    publisher VARCHAR(50) NOT NULL,
    isbn_10 CHAR(10),
    isbn_13 CHAR(13) 
        CHECK (isbn_13 <=> NULL OR isbn_10 <=> NULL),

    PRIMARY KEY(id),
    UNIQUE(isbn_10, isbn_13),
    FOREIGN KEY (publisher) REFERENCES publishers(name)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE cds (
    id INT AUTO_INCREMENT NOT NULL,
    title VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    month INT NULL
    	CHECK ((month >= 1 AND month <= 12) OR month = NULL),

    PRIMARY KEY(id),
    UNIQUE(title, year)
);

CREATE TABLE dvds (
    id INT AUTO_INCREMENT NOT NULL,
    title VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    month INT NULL
    	CHECK (month >= 1 AND month <= 12),

    PRIMARY KEY(id),
    UNIQUE(title, year)
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

CREATE TABLE genres_books (
    book_id INT NOT NULL,
    genre_name VARCHAR(30) NOT NULL,

    PRIMARY KEY(book_id, genre_name),
    FOREIGN KEY (book_id) REFERENCES books(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (genre_name) REFERENCES genres(name)
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
    producer_name VARCHAR(50) NOT NULL,

    PRIMARY KEY(cd_id, producer_name),
    FOREIGN KEY (cd_id) REFERENCES cds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (producer_name) REFERENCES producers(name)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE genres_cds (
    cd_id INT NOT NULL,
    genre_name VARCHAR(30) NOT NULL,

    PRIMARY KEY(cd_id, genre_name),
    FOREIGN KEY (cd_id) REFERENCES cds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (genre_name) REFERENCES genres(name)
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
);

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
    producer_name VARCHAR(50) NOT NULL,

    PRIMARY KEY(dvd_id, producer_name),
    FOREIGN KEY (dvd_id) REFERENCES dvds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (producer_name) REFERENCES producers(name)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE genres_dvds (
    dvd_id INT NOT NULL,
    genre_name VARCHAR(30) NOT NULL,

    PRIMARY KEY(dvd_id, genre_name),
    FOREIGN KEY (dvd_id) REFERENCES dvds(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (genre_name) REFERENCES genres(name)
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
    item_type ENUM('Book', 'CD', 'DVD') NOT NULL,
    sender_location_id INT NOT NULL,
    recepient_location_id INT NOT NULL
    	CHECK (sender_location_id <> recepient_location_id),
    exchange_date DATE NOT NULL DEFAULT NOW(),

    PRIMARY KEY (item_id, item_type, sender_location_id, recepient_location_id, exchange_date),
    FOREIGN KEY (sender_location_id) REFERENCES locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (recepient_location_id) REFERENCES locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE items_locations (
    item_id INT NOT NULL,
    item_type ENUM('Book', 'CD', 'DVD') NOT NULL,
    location_id INT NOT NULL,
    filing_date DATE NOT NULL DEFAULT NOW(),
    pick_up_date DATE NULL
    	CHECK (filing_date <= pick_up_date OR pick_up_date = NULL),

    PRIMARY KEY (item_id, item_type, location_id, filing_date),
    FOREIGN KEY (location_id) REFERENCES locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE loans (
    item_id INT NOT NULL,
    item_type ENUM('Book', 'CD', 'DVD') NOT NULL,
    location_id INT NOT NULL,
    registered_id INT NOT NULL,
    pick_up_date DATE NOT NULL DEFAULT NOW(),
    filing_date DATE NULL
    	CHECK (filing_date >= pick_up_date OR filing_date = NULL),

    PRIMARY KEY (item_id, item_type, location_id, registered_id, pick_up_date),
    FOREIGN KEY (location_id) REFERENCES locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (registered_id) REFERENCES registered(id)
    	ON DELETE CASCADE
    	ON UPDATE CASCADE
);

COMMIT;