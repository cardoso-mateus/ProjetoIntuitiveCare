load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\Relatorio_cadop teste 3.csv'
into table relatorio_cadop_teste_3.Relacao_de_Operadoras_Ativas_ANS
char set 'latin1'
fields terminated by ';'
enclosed by '"'
lines terminated by '\n'
ignore 3 rows;
