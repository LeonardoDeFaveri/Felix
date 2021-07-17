START TRANSACTION;

INSERT INTO `registered` (id, first_name, surname, date_of_birth) VALUES
    (1, 'Leonardo', 'De Faveri', '2001-11-25'),
    (2, 'Emanuele', 'Bortot', '2001-12-16'),
    (3, 'Riccardo', 'Pavetta', '2001-07-24');

INSERT INTO `authors` (id, first_name, second_name, surname, year_of_birth) VALUES
    (1, 'Isaac', NULL, 'Asimov', 1920),
    (2, 'Umberto', NULL, 'Eco', 1932),
    (3, 'Aldous', NULL, 'Huxley', 1894),
    (4, 'Michail', NULL, 'Bulgakov', 1891),
    (5, 'Ray', NULL, 'Bradbury', 1920),
    (6, 'William', NULL, 'Golding', 1911),
    (7, 'Evgenij', NULL, 'Zamjatin', 1884),
    (8, 'Agatha', NULL, 'Christie', 1890),
    (9, 'Mary', NULL, 'Shelley', 1797),
    (10, 'Robert', 'Luis', 'Stevenson', 1850),
    (11, 'Abraham', 'Bram', 'Stoker', 1847),
    (12, 'Roberto', NULL, 'Saviano', 1979),
    (13, 'Cory', NULL, 'Doctorow', 1971),
    (14, 'Emily', 'Jane', 'Brontë', 1818),
    (15, 'Edwin', 'Abbott', 'Abbott', 1836),
    (16, 'José', NULL, 'Saramago', 1922),
    (17, 'Tara', NULL, 'Westover', 1986),
    (18, 'Hannah', NULL, 'Arendt', 1906),
    (19, 'Rossella', NULL, 'Postorino', 1978),
    (20, 'Tommaso', NULL, 'Scotti', 1984),
    (21, 'Paolo', NULL, 'Fiorelli', 1971),
    (22, 'Theodor', 'John', 'Kaczynski', 1942),
    (23, 'Vladimir', NULL, 'Sorokin', 1955),
    (24, 'Jonathan', NULL, 'Franzen', 1956),
    (25, 'Philip', 'Kindred', 'Dick', 1928),
    (26, 'Herbert', 'George', 'Wells', 1866),
    (27, 'Howard', 'Philips', 'Lovecraft', 1890),
    (28, 'George', NULL, 'Orwell', 1903);

INSERT INTO `genres` (name) VALUES
    ('Science Fiction'),
    ('Drama'),
    ('Fantasy'),
    ('Classics'),
    ('Comic'),
    ('Graphic Novel'),
    ('Mystery'),
    ('Horror'),
    ('Crime'),
    ('Historical'),
    ('Western'),
    ('Contemporary'),
    ('Thriller'),
    ('Journalistic'),
    ('Essay'),
    ('Biography'),
    ('Noir'),
    ('Gothic'),
    ('Utopian'),
    ('Distopian'),
    ('Cyberpunk'),
    ('Religious'),
    ('Apocalyptic'),
    ('Lovecraftian'),
    ('Fantastique'),
    ('Adventure'),
    ('Action'),
    ('Sentimental'),
    ('Epistolary'),
    -- Generi musicali
    ('Metal'),
    ('Pop'),
    ('Rock'),
    ('Folk'),
    ('Soft');

INSERT INTO `publishers` (name) VALUES
    ('Mondadori'),
    ('Feltrinelli'),
    ('Bompiani'),
    ('Einaudi'),
    ('La nave di Teseo'),
    ('Longanesi'),
    ('Sperling & Kupfer'),
    ('Amazon Italia Logistica S.R.L.'),
    ('Atmosphere Libri'),
    ('Fanucci editore');

INSERT INTO `books` (id, title, year, month, publisher, isbn_10, isbn_13) VALUES
    (1, 'La giornata di un OpričniK', 2014, 3, 'Atmosphere Libri', NULL, '9788865640500'),
    (2, 'La società industriale e il suo futuro', 2018, 3, 'Amazon Italia Logistica S.R.L.', NULL, '9781980557753'),
    (3, 'La fantascienza di H.G. Wells', 2018, 10, 'Mondadori', NULL, '9788804700340'),
    (4, 'Cthulhu - I racconti del mito', 2016, 10, 'Mondadori', NULL, '9788804669449'),
    (5, 'Ubik', 2019, 9, 'Fanucci editore', NULL, '9788834738917'),
    (6, 'Dottor Futuro', 2019, 9, 'Fanucci editore', NULL, '9788834739082'),
    (7, 'Le correzioni', 2014, 2, 'Einaudi', NULL, '9788806219550'),
    (8, 'Scacco matto con delitto', 2021, 1, 'Sperling & Kupfer', NULL, '9788820071509'),
    (9, "L'ombrello del'Imperatore", 2021, 1, 'Longanesi', NULL, '9788830456464'),
    (10, 'Gridalo', 2020, 9, 'Bompiani', NULL, '9788830100916'),
    (11, 'Le assaggiatrici', 2021, 1, 'Feltrinelli', NULL, '9788807893001'),
    (12, 'La banalità del male', 2001, 3, 'Feltrinelli', NULL, '9788807892974'),
    (13, "L'educazione", 2020, 1, 'Feltrinelli', NULL, '9788807892394'),
    (14, 'Cecità', 2010, 5, 'Feltrinelli', NULL, '9788807881572'),
    (15, 'Flatlandia', 2018, 4, 'Feltrinelli', NULL, '9788807902697'),
    (16, 'Cime tempestose', 2012, 5, 'Feltrinelli', NULL, '9788807900129'),
    (17, 'Il pendolo di Foucault', 2018, 9, 'La nave di Teseo',  NULL, '9788893446419'),
    (18, 'Radicalized', 2021, 2, 'Mondadori', NULL, '9788804732167'),
    (19, 'Gomorra', 2016, 5, 'Mondadori', NULL, '9788804665281'),
    (20, 'Assassinio sul Nilo', 2020, 10, 'Mondadori', NULL, '9788804728160'),
    (21, 'Cronache marziane', 2020, 4, 'Mondadori', NULL, '9788804724872'),
    (22, 'Dracula', 1996, 02, 'Mondadori', NULL, '9788804671619'),
    (23, 'Lo strano caso del Dottor Jeckyll e del signor Hyde', 1985, 5, 'Mondadori', NULL, '9788804672333'),
    (24, 'Frankenstein', 1994, 11, 'Mondadori', NULL, '9788804671435'),
    (25, 'Dieci piccoli indiani', 2020, 2, 'Mondadori', NULL, '9788804728689'),
    (26, "Assassinio sull'Orient Express", 2020, 2, 'Mondadori', NULL, '9788804679387'),
    (27, 'Le uova fatali', 2019, 11, 'Mondadori', NULL, '9788804720997'),
    (28, 'Noi', 2018, 2, 'Mondadori', NULL, '9788804683933'),
    (29, "L'isola", 2017, 8, 'Mondadori', NULL, '9788804684312'),
    (30, 'Cuore di cane', 2016, 7, 'Mondadori', NULL, '9788804670933'),
    (31, 'Il mondo nuovo - Ritorno al mondo nuovo', 2016, 7, 'Mondadori', NULL, '9788804670520'),
    (32, 'Il Maestro e Margherita', 2016, 5, 'Mondadori', NULL, '9788804668428'),
    (33, '1984', 2016, 5, 'Mondadori', NULL, '9788804668237'),
    (34, 'La fattoria degli animali', 2016, 5, 'Mondadori', NULL, '9788804667792'),
    (35, 'Il signore delle mosche', 2017, 5, 'Mondadori', NULL, '9788804678850'),
    (36, 'Fahrenheit 451', 2016, 5, 'Mondadori', NULL, '9788804665298'),
    (37, 'Civiltà extraterrestri', 1986, 2, 'Mondadori', NULL, '9788804730415'),
    (38, "Ciclo dell'Impero", 2020, 9, 'Mondadori', NULL, '9788804736417'),
    (39, 'Fondazione - Il ciclo completo', 2020, 5, 'Mondadori', NULL, '9788804729198');

INSERT INTO `authors_books` (book_id, author_id) VALUES
    (1, 23),
    (2, 22),
    (3, 26),
    (4, 27),
    (5, 25),
    (6, 25),
    (7, 24),
    (8, 21),
    (9, 20),
    (10, 12),
    (11, 19),
    (12, 18),
    (13, 17),
    (14, 16),
    (15, 15),
    (16, 14),
    (17, 2),
    (18, 13),
    (19, 12),
    (20, 8),
    (21, 5),
    (22, 11),
    (23, 10),
    (24, 9),
    (25, 8),
    (26, 8),
    (27, 4),
    (28, 7),
    (29, 3),
    (30, 4),
    (31, 3),
    (32, 4),
    (33, 28),
    (34, 28),
    (35, 6),
    (36, 5),
    (37, 1),
    (38, 1),
    (39, 1);

INSERT INTO `genres_books` (book_id, genre_name) VALUES
    (1, 'Science Fiction'),
    (1, 'Distopian'),
    (2, 'Essay'),
    (3, 'Science Fiction'),
    (3, 'Adventure'),
    (3, 'Fantastique'),
    (4, 'Horror'),
    (4, 'Lovecraftian'),
    (4, 'Mystery'),
    (5, 'Science Fiction'),
    (5, 'Distopian'),
    (6, 'Science Fiction'),
    (6, 'Distopian'),
    (7, 'Contemporary'),
    (8, 'Mystery'),
    (8, 'Crime'),
    (8, 'Thriller'),
    (9, 'Mystery'),
    (9, 'Crime'),
    (9, 'Thriller'),
    (10, 'Contemporary'),
    (10, 'Journalistic'),
    (11, 'Drama'),
    (11, 'Biography'),
    (11, 'Historical'),
    (12, 'Historical'),
    (12, 'Journalistic'),
    (13, 'Drama'),
    (13, 'Biography'),
    (14, 'Contemporary'),
    (15, 'Essay'),
    (15, 'Fantastique'),
    (16, 'Drama'),
    (16, 'Sentimental'),
    (17, 'Mystery'),
    (17, 'Contemporary'),
    (17, 'Thriller'),
    (18, 'Science Fiction'),
    (18, 'Distopian'),
    (19, 'Journalistic'),
    (19, 'Contemporary'),
    (20, 'Mystery'),
    (20, 'Crime'),
    (21, 'Science Fiction'),
    (21, 'Fantastique'),
    (21, 'Adventure'),
    (22, 'Mystery'),
    (22, 'Drama'),
    (22, 'Gothic'),
    (22, 'Horror'),
    (22, 'Epistolary'),
    (23, 'Mystery'),
    (23, 'Fantastique'),
    (24, 'Horror'),
    (24, 'Fantastique'),
    (25, 'Mystery'),
    (25, 'Crime'),
    (26, 'Mystery'),
    (26, 'Crime'),
    (27, 'Science Fiction'),
    (27, 'Fantastique'),
    (28, 'Science Fiction'),
    (28, 'Distopian'),
    (29, 'Science Fiction'),
    (29, 'Utopian'),
    (29, 'Fantastique'),
    (30, 'Science Fiction'),
    (30, 'Comic'),
    (30, 'Fantastique'),
    (31, 'Science Fiction'),
    (31, 'Distopian'),
    (32, 'Fantastique'),
    (32, 'Comic'),
    (33, 'Science Fiction'),
    (33, 'Distopian'),
    (34, 'Fantastique'),
    (34, 'Distopian'),
    (35, 'Fantastique'),
    (35, 'Adventure'),
    (36, 'Science Fiction'),
    (36, 'Distopian'),
    (37, 'Essay'),
    (38, 'Science Fiction'),
    (38, 'Fantastique'),
    (38, 'Adventure'),
    (38, 'Action'),
    (39, 'Science Fiction'),
    (39, 'Fantastique'),
    (39, 'Adventure'),
    (39, 'Action');

INSERT INTO `locations` (id, city, address) VALUES
    (1, 'Pieve di Soligo', 'Piazza Vittorio Emanuele II, 9'),
    (2, 'Revine Lago', 'Via Roma, 32'),
    (3, 'Vittorio Veneto', 'Piazza Papa Giovanni Paolo I, 73');

INSERT INTO `items_locations` (item_id, location_id, item_type) VALUES
    (1, 1, 'Book'),
    (2, 2, 'Book'),
    (3, 3, 'Book'),
    (4, 1, 'Book'),
    (5, 2, 'Book'),
    (6, 3, 'Book'),
    (7, 1, 'Book'),
    (8, 2, 'Book'),
    (9, 3, 'Book'),
    (10, 1, 'Book'),
    (11, 2, 'Book'),
    (12, 3, 'Book'),
    (13, 1, 'Book'),
    (14, 2, 'Book'),
    (15, 3, 'Book'),
    (16, 1, 'Book'),
    (17, 1, 'Book'),
    (18, 1, 'Book'),
    (19, 2, 'Book'),
    (20, 3, 'Book'),
    (21, 3, 'Book'),
    (22, 2, 'Book'),
    (23, 2, 'Book'),
    (24, 2, 'Book'),
    (25, 2, 'Book'),
    (26, 1, 'Book'),
    (27, 1, 'Book'),
    (28, 1, 'Book'),
    (29, 2, 'Book'),
    (30, 3, 'Book'),
    (31, 2, 'Book'),
    (32, 1, 'Book'),
    (33, 2, 'Book'),
    (34, 3, 'Book'),
    (35, 3, 'Book'),
    (36, 1, 'Book'),
    (37, 2, 'Book'),
    (38, 3, 'Book'),
    (39, 2, 'Book');

-- The password is the obtained by using the BCrypt algortihm with:
-- Version: $a2
-- Rounds: 10
-- Hash used in these example data:
-- 5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8
INSERT INTO administrative_users (email, password, first_name, surname, privilege_level) VALUES
    ('leonardo.defaveri01@gmail.com', '$2a$12$P1LyDx5v31sZrpnAt5UZkOaBSPmT0mGS/84wU7hadG1iNlY492hBm',
        'Leonardo', 'De Faveri', 'Super User'),
    ('leopieve2001@gmail.com', '$2a$12$P1LyDx5v31sZrpnAt5UZkOaBSPmT0mGS/84wU7hadG1iNlY492hBm',
        'Leonardo', 'De Faveri', 'Library Super Employee');

INSERT INTO administrative_users_locations (user_email, location_id, from_date) VALUES
    ('leopieve2001@gmail.com', 1, '2021-06-01'),
    ('leopieve2001@gmail.com', 2, NOW());

COMMIT;