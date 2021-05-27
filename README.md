# project-bootcamp-santander-dev-week

Projeto de API backend criado durante o bootcamp **DIO - Santander durante a Santander Dev Week**, de 24/05/2021 à 28/05/2021.

O arquivo de configurações está em:

```
resources/application.yml
```

## Rodando a aplicação

Essa aplicação foi construída utilizando o [Spring Boot](https://github.com/spring-projects/spring-boot).
Ao se executar o projeto, por padrão, é executada em **http://localhost:8080/bootcamp**.

## Integração com Banco de dados

Essa aplicação utiliza o [Postgres](https://github.com/postgres/postgres) por padrão, comunicando na porta `5432`.

Nesse projeto, criação de tabelas deve ser executada manualmente, mas pode ser alterada para
criação automática, se preferir.

Segue script para criação manual:

```SQL
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

Se desejar, pode alterar a propriedade `generated-ddl` do arquivo `application.yml` para `true`. Dessa forma o próprio **Spring JPA** irá se encarregar da criação das tabelas.

## Documentação de endpoints da API

A API está integrada com o [OpenAPI](https://github.com/OAI/OpenAPI-Specification).
Ao rodar a aplicação, a documentação dos endpoints pode ser visualizada
em **http://localhost:8080/bootcamp/swagger-ui/index.html**.
