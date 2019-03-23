# Spring Boot Boilerplate
- Spring Boot2
- PostgreSQL11 with Docker
- Lombok
- Doma2

## How to create Spring Boot Project
### (1) init boot project
```
spring init --build=gradle --java-version=11 --dependencies="web,jdbc,devtools,postgresql" spring-boot-boilerplate
```

### (2) Create Database
- Dockerfile
- docker-compose.yml
- create-db.sh
- create ER diagram
- create sql file

startup:
```
docker-compose up -d --build
```

shutdown
```
docker-compose down -v
```

### (3) application.properties
```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=db_user
spring.datasource.password=abcd1234
```

### (4) Lombok
https://projectlombok.org/setup/gradle

```
dependencies {
	compileOnly 'org.projectlombok:lombok:1.18.6'
	annotationProcessor 'org.projectlombok:lombok:1.18.6'
}
```