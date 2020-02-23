# Treinamento-stefanini-backend

## Sobre o desenvolvimento

O projeto foi desenvolvido em Java, utilizando o framework Spring Boot.
Está disponível em [https://treinamento-stefanini.herokuapp.com/](https://treinamento-stefanini.herokuapp.com/).

A documentação swagger está disponível em [https://treinamento-stefanini.herokuapp.com/swagger-ui.html#](https://treinamento-stefanini.herokuapp.com/swagger-ui.html#)

A estrutura do projeto consiste:

```
|---
---| config
---| enumeration
---| exception
---| model
---| service
---| repositories
---| security
---| resources
---| util

```

## Como executar?

Para rodar seu projeto abra um terminal, entre no diretório raiz do projeto e execute o comando abaixo:
```
mvn spring-boot:run
```

Se o maven não estiver instalado de forma apropriada você também pode executar com o seguinte comando (que vem no próprio projeto criado no starter do Spring quando você escolhe maven como seu gerenciador de dependências):
```
./mvnw spring-boot:run
```

## Arquitetura

O projeto utiliza a [arquitetura MVC](https://github.com/daltonserey/projsw-20191/blob/master/06.web_apps/1-padrao_mvc/text.md).

## Segurança

Neste projeto foi usado o Basic Auth para acesso a API. Por padrão o login e senha são "admin"

## Banco de dados

Foi utilizado MySQL para desenvolvimento e também para produção. Para realização das migrações do BD foi utilizado o Flyway

## Desenvolvedor

- [Eduardo Pereira](https://github.com/Eduardoccufcg)


