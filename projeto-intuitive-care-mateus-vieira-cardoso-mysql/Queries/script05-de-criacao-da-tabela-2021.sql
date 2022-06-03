create schema if not exists Relatorio_Cadop_Teste_3;

create table if not exists Relatorio_Cadop_Teste_3.Primeiro_Trimestre_2021 (
DATA varchar(50),
REG_ANS int,
CD_CONTA_CONTABIL int,
DESCRICAO varchar (255),
VL_SALDO_FINAL varchar (50)
);

create table if not exists Relatorio_Cadop_Teste_3.Segundo_Trimestre_2021 (
DATA varchar(50),
REG_ANS int,
CD_CONTA_CONTABIL int,
DESCRICAO varchar (255),
VL_SALDO_FINAL varchar (50)
);

create table if not exists Relatorio_Cadop_Teste_3.Terceiro_Trimestre_2021 (
DATA varchar(50),
REG_ANS int,
CD_CONTA_CONTABIL int,
DESCRICAO varchar (255),
VL_SALDO_FINAL varchar (50)
);

create table if not exists Relatorio_Cadop_Teste_3.Quarto_Trimestre_2021 (
DATA varchar(50),
REG_ANS int,
CD_CONTA_CONTABIL int,
DESCRICAO varchar (255),
VL_SALDO_INICIAL varchar (50),
VL_SALDO_FINAL varchar (50)
);