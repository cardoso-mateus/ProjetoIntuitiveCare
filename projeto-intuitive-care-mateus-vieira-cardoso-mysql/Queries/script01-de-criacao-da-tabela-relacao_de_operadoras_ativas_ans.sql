create schema if not exists Relatorio_Cadop_Teste_3;

create table if not exists Relatorio_Cadop_Teste_3.Relacao_de_Operadoras_Ativas_ANS (
Registro_ANS int,
CNPJ varchar(50),
Razao_Social varchar(255),
Nome_Fantasia varchar(255),
Modalidade varchar(50),
Logradouro varchar(50),
Número varchar(50),
Complemento varchar(50),
Bairro varchar(50),
Cidade varchar(50),
UF varchar(2),
CEP int,
DDD varchar(50),
Telefone varchar(50),
Fax varchar(50),
Endereço_eletrônico varchar(50),
Representante varchar(50),
Cargo_Representante varchar(50),
Data_Registro_ANS varchar(50),
primary key (Registro_ANS)
);