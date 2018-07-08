-- DROP TABLE cliente;
CREATE TABLE cliente
(
  id integer,
  rg character(100),
  nome character(100),
  telefone character(50)
);


-- DROP TABLE cliente_pet;
CREATE TABLE cliente_pet
(
  id integer,
  cliente integer,
  pet integer
);


-- DROP TABLE pet;
CREATE TABLE pet
(
  id integer,
  nome character(50),
  tipo character(50)
);


-- DROP TABLE pet_servico;
CREATE TABLE pet_servico
(
  id integer,
  pet integer,
  servico integer
);


-- DROP TABLE servico;
CREATE TABLE servico
(
  id integer,
  tipo character(50),
  preco double precision
);
