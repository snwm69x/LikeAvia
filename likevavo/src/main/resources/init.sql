CREATE TABLE roles IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE class IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    economy BOOLEAN NOT NULL,
    business BOOLEAN NOT NULL,
    firstclass BOOLEAN NOT NULL
);

CREATE TABLE country IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    translation_ru VARCHAR(100) NOT NULL
    code VARCHAR(100) NOT NULL,
);

INSERT INTO country (name, translation_ru, code) VALUES
('United States', 'Соединенные Штаты', 'USA'),
('Canada', 'Канада', 'CAN'),
('Mexico', 'Мексика', 'MEX'),
('Brazil', 'Бразилия', 'BRA'),
('Germany', 'Германия', 'GER'),
('France', 'Франция', 'FRA'),
('Spain', 'Испания', 'ESP'),
('Italy', 'Италия', 'ITA'),
('China', 'Китай', 'CHN'),
('Japan', 'Япония', 'JPN');

CREATE TABLE users IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(300) NOT NULL,
    role VARCHAR(100)
);

CREATE TABLE passengers IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    isAdult BOOLEAN NOT NULL,
    isChild BOOLEAN NOT NULL,
    class INTEGER NOT NULL REFERENCES class(id)
);

CREATE TABLE users IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role_id INTEGER NOT NULL REFERENCES roles(id),
    personal_data_id INTEGER REFERENCES personal_data(id)
);

CREATE TABLE city IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(50) NOT NULL,
    translation_ru VARCHAR(100) NOT NULL,
    country_id INTEGER NOT NULL REFERENCES country(id)
);

INSERT INTO city (name, code, translation_ru, country_id) VALUES
('New York', 'NYC', 'Нью-Йорк', 1),
('Los Angeles', 'LAX', 'Лос-Анджелес', 1),
('Chicago', 'CHI', 'Чикаго', 1),
('Toronto', 'TOR', 'Торонто', 2),
('Vancouver', 'VAN', 'Ванкувер', 2),
('Montreal', 'MTL', 'Монреаль', 2),
('Mexico City', 'MEX', 'Мехико', 3),
('Guadalajara', 'GDL', 'Гвадалахара', 3),
('Puebla', 'PUE', 'Пуэбла', 3),
('São Paulo', 'SAO', 'Сан-Паулу', 4),
('Rio de Janeiro', 'RIO', 'Рио-де-Жанейро', 4),
('Brasília', 'BSB', 'Бразилиа', 4),
('Berlin', 'BER', 'Берлин', 5),
('Hamburg', 'HAM', 'Гамбург', 5),
('Munich', 'MUC', 'Мюнхен', 5),
('Paris', 'PAR', 'Париж', 6),
('Marseille', 'MAR', 'Марсель', 6),
('Lyon', 'LYO', 'Лион', 6),
('Madrid', 'MAD', 'Мадрид', 7),
('Barcelona', 'BAR', 'Барселона', 7),
('Valencia', 'VAL', 'Валенсия', 7),
('Rome', 'ROM', 'Рим', 8),
('Milan', 'MIL', 'Милан', 8),
('Naples', 'NAP', 'Неаполь', 8),
('Beijing', 'BEI', 'Пекин', 9),
('Shanghai', 'SHA', 'Шанхай', 9),
('Guangzhou', 'GUA', 'Гуанчжоу', 9);

-- ALTER TABLE users ALTER COLUMN role_id DROP NOT NULL;
-- UPDATE users
-- SET role_id = 1
-- WHERE id = 8 AND role_id = 3;
-- INSERT INTO users (username, email, password, role_id, personal_data_id)
-- VALUES ('kolbasa', 'kolbasa@mail.ru', '$2a$10$qUThjoYdXTO9XqEfWclY4uBNn5mFqomNagNHPjjKAKOJEjslR1fXe', 1, 1);

CREATE TABLE personal_data IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(100) NOT NULL,
    country_id INTEGER NOT NULL REFERENCES country(id)
);

INSERT INTO personal_data (first_name, last_name, phone_number, country_id)
VALUES ('Иван', 'Иванов', '+7 (999) 123-45-67', 1);

CREATE TABLE routes IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    origin_airport_id INTEGER NOT NULL REFERENCES airports(id),
    destination_airport_id INTEGER NOT NULL REFERENCES airports(id),
    date DATE NOT NULL,
    origin_city_id INTEGER NOT NULL REFERENCES city(id),
    destination_city_id INTEGER NOT NULL REFERENCES city(id)
);

INSERT INTO routes(origin_airport_id, destination_airport_id, date, origin_city_id, destination_city_id) VALUES
(1,2,'2022-04-04',1,2);


CREATE TABLE tickets IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    route_id INTEGER NOT NULL REFERENCES routes(id),
    avia_company_id INTEGER NOT NULL REFERENCES avia_companies(id),
    price DECIMAL(10, 2) NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    arrival_time TIMESTAMP NOT NULL,
    duration_flight VARCHAR(100) NOT NULL
);

CREATE TABLE airports IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city_id INTEGER NOT NULL REFERENCES city(id),
    country_id INTEGER NOT NULL REFERENCES country(id),
    code VARCHAR(50) NOT NULL
);

INSERT INTO airports (name, city_id, country_id, code) VALUES 
('John F. Kennedy International Airport', 1, 1, 'JFK'),
('Los Angeles International Airport', 2, 1, 'LAX'),
('OHare International Airport', 3, 1, 'ORD'),
('Toronto Pearson International Airport', 4, 2, 'YYZ'),
('Vancouver International Airport', 5, 2, 'YVR'),
('Pierre Elliott Trudeau International Airport', 6, 2, 'YUL'),
('Mexico City International Airport', 7, 3, 'MEX'),
('Guadalajara International Airport', 8, 3, 'GDL'),
('Puebla International Airport', 9, 3, 'PBC'),
('São Paulo-Guarulhos International Airport', 10, 4, 'GRU'),
('Rio de Janeiro-Galeão International Airport', 11, 4, 'GIG'),
('Brasília International Airport', 12, 4, 'BSB'),
('Berlin Brandenburg Airport', 13, 5, 'BER'),
('Hamburg Airport', 14, 5, 'HAM'),
('Munich Airport', 15, 5, 'MUC'),
('Paris-Charles de Gaulle Airport', 16, 6, 'CDG'),
('Marseille Provence Airport', 17, 6, 'MRS'),
('Lyon-Saint-Exupéry Airport', 18, 6, 'LYS'),
('Madrid Barajas Airport', 19, 7, 'MAD'),
('Barcelona El Prat Airport', 20, 7, 'BCN'),
('Valencia Airport', 21, 7, 'VLC'),
('Leonardo da Vinci International Airport', 22, 8, 'FCO'),
('Milan Malpensa Airport', 23, 8, 'MXP'),
('Naples International Airport', 24, 8, 'NAP'),
('Beijing Capital International Airport', 25, 9, 'PEK'),
('Shanghai Pudong International Airport', 26, 9, 'PVG'),
('Guangzhou Baiyun International Airport', 27, 9, 'CAN');

CREATE INDEX idx_airports_name ON airports (name);

CREATE TABLE avia_companies IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country_id INTEGER NOT NULL REFERENCES country(id)
);

INSERT INTO avia_companies (name, country_id) VALUES 
('American Airlines', 1),
('Delta Air Lines', 1),
('United Airlines', 1),
('Air Canada', 2),
('WestJet', 2),
('Air Transat', 2),
('Aeroméxico', 3),
('Volaris', 3),
('Interjet', 3),
('LATAM Brasil', 4),
('GOL Linhas Aéreas', 4),
('Azul Brazilian Airlines', 4),
('Lufthansa', 5),
('Eurowings', 5),
('Condor', 5),
('Air France', 6),
('easyJet', 6),
('Transavia France', 6),
('Iberia', 7),
('Vueling', 7),
('Air Europa', 7),
('Alitalia', 8),
('easyJet', 8),
('Ryanair', 8),
('Air China', 9),
('China Eastern Airlines', 9),
('China Southern Airlines', 9);

CREATE INDEX idx_avia_companies_name ON avia_companies (name);

CREATE TABLE bookings IF NOT EXISTS (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id),
    ticket_id INTEGER NOT NULL REFERENCES tickets(id),
    passengers_id INTEGER NOT NULL REFERENCES passengers(id),
    quantity INTEGER NOT NULL
);

ALTER TABLE bookings ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE bookings ADD CONSTRAINT fk_ticket_id FOREIGN KEY (ticket_id) REFERENCES tickets(id);
ALTER TABLE bookings ADD CONSTRAINT fk_passengers_id FOREIGN KEY (passengers_id) REFERENCES passengers(id);