# project-bootcamp-santander-dev-week

Projeto criado para o bootcamp DIO - Santander durante a Santander Dev Week, de 24/05/2021 à 28/05/2021.

Arquivo de propriedades:
```
application.yml
```

Banco de dados Postgres.
O Spring JPA não está configurado para criação automática de tabelas, então deve ser criado manualmente. Segue script:
```
create table tb_stock (

	id numeric(9) not null,
	"date" date not null,
	"name" varchar(100) not null,
	price numeric(8,2) not null,
	variation numeric(5,2) not null,
	constraint tb_stock_pkey primary key (id)

);

CREATE SEQUENCE hibernate_sequence START 1;
```

API integrada com o OpenAPI Specification (OAS).
Link para visualizar as rotas da API:
```
http://localhost:8080/bootcamp/swagger-ui/index.html
```
