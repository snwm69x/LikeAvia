CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE class (
    id SERIAL PRIMARY KEY,
    economy BOOLEAN NOT NULL,
    business BOOLEAN NOT NULL,
    firstclass BOOLEAN NOT NULL
);

CREATE TABLE country (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    translation_ru VARCHAR(100) NOT NULL
    code VARCHAR(100) NOT NULL,
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(300) NOT NULL,
    role VARCHAR(100)
);

CREATE TABLE passengers (
    id SERIAL PRIMARY KEY,
    isAdult BOOLEAN NOT NULL,
    isChild BOOLEAN NOT NULL,
    class INTEGER NOT NULL REFERENCES class(id)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role_id INTEGER NOT NULL REFERENCES roles(id),
    personal_data_id INTEGER REFERENCES personal_data(id)
);

CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(50) NOT NULL,
    translation_ru VARCHAR(100) NOT NULL,
    country_id INTEGER NOT NULL REFERENCES country(id)
);

-- ALTER TABLE users ALTER COLUMN role_id DROP NOT NULL;
-- UPDATE users
-- SET role_id = 1
-- WHERE id = 8 AND role_id = 3;
-- INSERT INTO users (username, email, password, role_id, personal_data_id)
-- VALUES ('kolbasa', 'kolbasa@mail.ru', '$2a$10$qUThjoYdXTO9XqEfWclY4uBNn5mFqomNagNHPjjKAKOJEjslR1fXe', 1, 1);

CREATE TABLE personal_data (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(100) NOT NULL,
    country_id INTEGER NOT NULL REFERENCES country(id)
);

INSERT INTO personal_data (first_name, last_name, phone_number, country_id)
VALUES ('Иван', 'Иванов', '+7 (999) 123-45-67', 1);

CREATE TABLE routes (
    id SERIAL PRIMARY KEY,
    origin_airport_id INTEGER NOT NULL REFERENCES airports(id),
    destination_airport_id INTEGER NOT NULL REFERENCES airports(id),
    date DATE NOT NULL,
    origin_city_id INTEGER NOT NULL REFERENCES city(id),
    destination_city_id INTEGER NOT NULL REFERENCES city(id)
);

CREATE TABLE tickets (
    id SERIAL PRIMARY KEY,
    route_id INTEGER NOT NULL REFERENCES routes(id),
    avia_company_id INTEGER NOT NULL REFERENCES avia_companies(id),
    price DECIMAL(10, 2) NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    arrival_time TIMESTAMP NOT NULL,
    duration_flight VARCHAR(100) NOT NULL
);

CREATE TABLE airports (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city_id INTEGER NOT NULL REFERENCES city(id),
    country_id INTEGER NOT NULL REFERENCES country(id),
    code VARCHAR(50) NOT NULL
);

CREATE INDEX idx_airports_name ON airports (name);

CREATE TABLE avia_companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country_id INTEGER NOT NULL REFERENCES country(id)
);

CREATE INDEX idx_avia_companies_name ON avia_companies (name);

CREATE TABLE bookings (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id),
    ticket_id INTEGER NOT NULL REFERENCES tickets(id),
    passengers_id INTEGER NOT NULL REFERENCES passengers(id),
    quantity INTEGER NOT NULL
);

ALTER TABLE bookings ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE bookings ADD CONSTRAINT fk_ticket_id FOREIGN KEY (ticket_id) REFERENCES tickets(id);
ALTER TABLE bookings ADD CONSTRAINT fk_passengers_id FOREIGN KEY (passengers_id) REFERENCES passengers(id);