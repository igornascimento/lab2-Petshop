PGDMP     8        
            v            postgres    10.3    10.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                        2615    16599    lab2_petshop    SCHEMA        CREATE SCHEMA lab2_petshop;
    DROP SCHEMA lab2_petshop;
             postgres    false            �            1259    16600    cliente    TABLE     �   CREATE TABLE lab2_petshop.cliente (
    id integer,
    rg character(100),
    nome character(100),
    telefone character(50)
);
 !   DROP TABLE lab2_petshop.cliente;
       lab2_petshop         postgres    false    4            �            1259    16612    cliente_pet    TABLE     `   CREATE TABLE lab2_petshop.cliente_pet (
    id integer,
    cliente integer,
    pet integer
);
 %   DROP TABLE lab2_petshop.cliente_pet;
       lab2_petshop         postgres    false    4            �            1259    16603    pet    TABLE     \   CREATE TABLE lab2_petshop.pet (
    id integer,
    nome character(50),
    tipo integer
);
    DROP TABLE lab2_petshop.pet;
       lab2_petshop         postgres    false    4            �            1259    16615    pet_servico    TABLE     `   CREATE TABLE lab2_petshop.pet_servico (
    id integer,
    pet integer,
    servico integer
);
 %   DROP TABLE lab2_petshop.pet_servico;
       lab2_petshop         postgres    false    4            �            1259    16609    servico    TABLE     j   CREATE TABLE lab2_petshop.servico (
    id integer,
    tipo character(50),
    preco double precision
);
 !   DROP TABLE lab2_petshop.servico;
       lab2_petshop         postgres    false    4            �          0    16600    cliente 
   TABLE DATA               ?   COPY lab2_petshop.cliente (id, rg, nome, telefone) FROM stdin;
    lab2_petshop       postgres    false    213          �          0    16612    cliente_pet 
   TABLE DATA               =   COPY lab2_petshop.cliente_pet (id, cliente, pet) FROM stdin;
    lab2_petshop       postgres    false    216   .       �          0    16603    pet 
   TABLE DATA               3   COPY lab2_petshop.pet (id, nome, tipo) FROM stdin;
    lab2_petshop       postgres    false    214   K       �          0    16615    pet_servico 
   TABLE DATA               =   COPY lab2_petshop.pet_servico (id, pet, servico) FROM stdin;
    lab2_petshop       postgres    false    217   h       �          0    16609    servico 
   TABLE DATA               8   COPY lab2_petshop.servico (id, tipo, preco) FROM stdin;
    lab2_petshop       postgres    false    215   �       �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     