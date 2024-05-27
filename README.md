# SpringBootMybabitisConnect

<h1>Proejct 설정</h1># EecurityEx01

<h2>1. DB설정(mysql) </h2>

```db
CREATE DATABASE mybatis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (username, password, email) VALUES ('홍길동', 'password1', 'hong@example.com');
INSERT INTO users (username, password, email) VALUES ('김철수', 'password2', 'kim@example.com');
INSERT INTO users (username, password, email) VALUES ('이영희', 'password3', 'lee@example.com');
INSERT INTO users (username, password, email) VALUES ('박민수', 'password4', 'park@example.com');
INSERT INTO users (username, password, email) VALUES ('최영수', 'password5', 'choi@example.com');
```

<h2>2. 프로젝트 설정 </h2>

<h3>1</h3>
<img src="/images/mybatis01.PNG">
<h3>2</h3>
<img src="/images/mybatis02.PNG">

<h3>application.properties 추가</h3>

```java
spring.application.name=bootMybatis

#MySQL 연결 설정
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=1234

# mybatis 설정
mybatis.type-aliases-package=com.bootMybatis.vo
mybatis.mapper-locations=mybatis/mapper/**/*.xml
```

<h2>2. 프로젝트 구조 </h2>
<img src="/images/mybatis03.PNG">

