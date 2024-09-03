# Movepass API 🚀

**Movepass** é uma API REST desenvolvida com Java e Spring Boot para gerenciar academias, empresas e assinaturas. O sistema permite que empresas registrem funcionários em academias e gerenciem assinaturas.

## Dependências 📦

- **Aplicação**: MySQL Driver, Spring Data JPA, Spring Web, Validation.
- **Desenvolvimento**: Lombok, Spring Boot DevTools.
- **Teste**: H2 Database, Spring Boot Starter Test.
- **Documentação**: OpenAPI (Swagger UI).

## Entidades 📊

- **Empresa**
- **Funcionário**
- **Academia**
- **Assinatura**

## Requisitos ✅

Implemente soft delete, use DTOs, anote controladores para Swagger, lance exceções personalizadas e padronize respostas com `ResponseEntity`.

## Estrutura do Projeto 🗂️

```text
src/main/java/com/movepass
├── controller
├── dto
├── exception
├── model
│    ├── entity
│    └── repository
├── service
└── MovepassApplication.java

src/test/java/com/movepass
└── controller
```

## Validações ✔️

Use Jakarta Constraints para validar dados como nome, email, e CNPJ.

## Endpoints 🔗

Crie endpoints para CRUD de **Academia**, **Assinatura**, **Empresa**, e **Funcionário**.

## Conclusão 🎉

O projeto **Movepass** é uma prática completa para desenvolver APIs REST com Java e Spring Boot, oferecendo uma experiência valiosa em conceitos de software e boas práticas.