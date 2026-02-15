<h1 align="center"><strong>Java Spring Boot - JPA</strong></h1>

This is an example of a Java Spring Boot API using JPA and Postgres database. Here the most used types of mappings between entities and queries were exemplified. A few points of attention will be discussed about the most used mappings below.

&nbsp;

## **How to run**

1. Run the docker-compose.yml to initialize the database
1. Run the Spring Boot project

### Dependencies:
- Docker
- Docker compose
- Java JDK 25
- Maven 3.9.12

&nbsp;

## **Mapping annotations**

The most used JPA mappings are:

- @OneToOne
- @OneToMany
- @ManyToOne
- @ManyToMany

This is because these mappings generally resolve almost all situations. However, there are other types of mappings such as:

- @ElementCollection
- @Embedded
- @Embeddable
- @MapKey
- @OrderBy
- @OrderColumn

In this project, only the most used mappings were used.

&nbsp;