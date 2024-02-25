-- Creación de la base de datos si no existe
CREATE DATABASE IF NOT EXISTS dekelstore;

-- Conexión a la base de datos
\c dekelstore;

-- Creación de tablas
CREATE TABLE IF NOT EXISTS gems (
  id VARCHAR(255) PRIMARY KEY,
  description VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS material (
  id VARCHAR(255) PRIMARY KEY,
  description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS services (
  id VARCHAR(255) PRIMARY KEY,
  title VARCHAR(255),
  description VARCHAR(255),
  icon VARCHAR(255),
  image VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS ubication (
  id VARCHAR(255) PRIMARY KEY,
  description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS category (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS jewel (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255),
  image VARCHAR(255),
  stock INT,
  value DOUBLE PRECISION,
  idcategory VARCHAR(255) REFERENCES category(id),
  idmaterial VARCHAR(255) REFERENCES material(id)
);

CREATE TABLE IF NOT EXISTS gemxjewel (
  id VARCHAR(255) PRIMARY KEY,
  idgem VARCHAR(255)  REFERENCES gems(id),
  idjewel VARCHAR(255) REFERENCES jewel(id),
  quantity INT
);


CREATE TABLE IF NOT EXISTS jeweldimens (
  id VARCHAR(255) PRIMARY KEY,
  idjewel VARCHAR(255) REFERENCES jewel(id),
  dimensions VARCHAR(255)
);


-- Creación de relaciones
ALTER TABLE IF EXISTS gemxjewel
  ADD CONSTRAINT fk_gem FOREIGN KEY (idgem) REFERENCES gems(id),
  ADD CONSTRAINT fk_jewel FOREIGN KEY (idjewel) REFERENCES jewel(id);

ALTER TABLE IF EXISTS jewel
  ADD CONSTRAINT fk_category FOREIGN KEY (idcategory) REFERENCES category(id),
  ADD CONSTRAINT fk_material FOREIGN KEY (idmaterial) REFERENCES material(id);

ALTER TABLE IF EXISTS jeweldimens
  ADD CONSTRAINT fk_jewel_dimensions FOREIGN KEY (idjewel) REFERENCES jewel(id);
