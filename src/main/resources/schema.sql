CREATE TABLE IF NOT EXISTS Project(
    id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    created_on DATE NOT NULL,
    version INT,
    PRIMARY KEY (id)
);