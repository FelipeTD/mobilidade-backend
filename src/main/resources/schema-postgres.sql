DROP TABLE IF EXISTS motorista;
DROP TABLE IF EXISTS aplicativo;
DROP TABLE IF EXISTS cadastro;
DROP TABLE IF EXISTS registros;

CREATE TABLE aplicativo(
    aplicativo_id INTEGER NOT NULL,
    nome_aplicativo VARCHAR(255) NOT NULL,
    PRIMARY KEY(aplicativo_id)
);


CREATE TABLE motorista(
    driver_id VARCHAR(255) NOT NULL, 
    driver_name VARCHAR(255), 
    active bool,
    PRIMARY KEY(driver_id)
);

CREATE TABLE cadastro(
    cadastro_id VARCHAR(255) NOT NULL,
    numero_aplicativo VARCHAR(255) NOT NULL,
    aplicativo_id INTEGER NOT NULL,
    driver_id VARCHAR(255) NOT NULL,
    PRIMARY KEY(cadastro_id)
);

CREATE TABLE registros(
    registro_id SERIAL PRIMARY KEY,
    cadastro_id VARCHAR(255) NOT NULL,
    valor NUMERIC(5,2),
    registro_data DATE NOT NULL DEFAULT CURRENT_DATE
);

ALTER TABLE cadastro
ADD CONSTRAINT fk_id_motorista FOREIGN KEY (driver_id) REFERENCES motorista(driver_id);

ALTER TABLE cadastro
ADD CONSTRAINT fk_id_aplicativo FOREIGN KEY (aplicativo_id) REFERENCES aplicativo(aplicativo_id);

ALTER TABLE registros
ADD CONSTRAINT fk_id_cadastro FOREIGN KEY (cadastro_id) REFERENCES cadastro(cadastro_id);