load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\1T2020.csv'
into table relatorio_cadop_teste_3.primeiro_trimestre_2020
char set 'latin1'
fields terminated by ';'
enclosed by '"'
lines terminated by '\r\n'
ignore 1 rows;

load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\2T2020.csv'
into table relatorio_cadop_teste_3.segundo_trimestre_2020
char set 'latin1'
fields terminated by ';'
enclosed by '"'
lines terminated by '\r\n'
ignore 1 rows;

load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\3T2020.csv'
into table relatorio_cadop_teste_3.terceiro_trimestre_2020
char set 'latin1'
fields terminated by ';'
enclosed by '"'
lines terminated by '\r\n'
ignore 1 rows;

load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\4T2020.csv'
into table relatorio_cadop_teste_3.quarto_trimestre_2020
char set 'latin1'
fields terminated by ';'
enclosed by '"'
lines terminated by '\r\n'
ignore 1 rows;
