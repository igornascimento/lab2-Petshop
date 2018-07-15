-- DROP TABLE cliente;
CREATE TABLE cliente
(
  id serial,
  rg character(100),
  nome character(100),
  telefone character(50)
);


-- DROP TABLE cliente_pet;
CREATE TABLE cliente_pet
(
  id serial,
  cliente integer,
  pet integer
);


-- DROP TABLE pet;
CREATE TABLE pet
(
  id serial,
  nome character(50),
  tipo character(50)
);


-- DROP TABLE pet_servico;
CREATE TABLE pet_servico
(
  id serial,
  pet integer,
  servico integer
);


-- DROP TABLE servico;
CREATE TABLE servico
(
  id serial,
  tipo character(50),
  preco double precision
);
