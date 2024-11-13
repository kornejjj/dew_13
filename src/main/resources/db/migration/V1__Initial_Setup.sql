CREATE TABLE clients (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(200) NOT NULL
);

CREATE TABLE planets (
                         id VARCHAR(10) PRIMARY KEY,
                         name VARCHAR(500) NOT NULL
);

CREATE TABLE tickets (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         created_at TIMESTAMP NOT NULL,
                         client_id BIGINT,
                         from_planet_id VARCHAR(10),
                         to_planet_id VARCHAR(10),
                         FOREIGN KEY (client_id) REFERENCES clients(id),
                         FOREIGN KEY (from_planet_id) REFERENCES planets(id),
                         FOREIGN KEY (to_planet_id) REFERENCES planets(id)
);
