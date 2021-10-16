DROP TABLE IF EXISTS registros;
DROP TABLE IF EXISTS cadastro;
DROP TABLE IF EXISTS motorista;
DROP TABLE IF EXISTS aplicativo;

CREATE TABLE aplicativo(
    aplicativo_id SERIAL PRIMARY KEY,
    nome_aplicativo VARCHAR(255) NOT NULL,
    active bool
);

CREATE TABLE motorista(
    driver_id VARCHAR(255) NOT NULL, 
    driver_name VARCHAR(255), 
    active bool,
    PRIMARY KEY(driver_id)
);

CREATE TABLE cadastro(
    cadastro_id SERIAL PRIMARY KEY,
    numero_aplicativo VARCHAR(255) NOT NULL,
    aplicativo_id INTEGER NOT NULL,
    driver_id VARCHAR(255) NOT NULL
);

CREATE TABLE registro(
    registro_id SERIAL PRIMARY KEY,
    cadastro_id INTEGER NOT NULL,
    valor NUMERIC(5,2),
    registro_data DATE NOT NULL DEFAULT CURRENT_DATE
);

ALTER TABLE cadastro
ADD CONSTRAINT fk_id_motorista FOREIGN KEY (driver_id) REFERENCES motorista(driver_id);

ALTER TABLE cadastro
ADD CONSTRAINT fk_id_aplicativo FOREIGN KEY (aplicativo_id) REFERENCES aplicativo(aplicativo_id);

ALTER TABLE registro
ADD CONSTRAINT fk_id_cadastro FOREIGN KEY (cadastro_id) REFERENCES cadastro(cadastro_id);