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
mybatis.mapper-locations=mybatis/mapper/*.xml
```

<h2>2. 프로젝트 구조 </h2>
<img src="/images/mybatis03.PNG">


<h2>3. UserVO </h2>

```java
package com.bootmybatis.vo;

import lombok.*;

import java.util.Date;

/*
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVO {
    private int id;
    private String username;
    private String password;
    private String email;
    private Date created_at;
}

```

<h2>4. UserRepository </h2>

```java
package com.bootmybatis.repository;

import com.bootmybatis.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
SpringBoot의 @Mapper를 사용하게 되면 
application.properties에서 설정한 경로를 바탕으로 알아서 쿼리 
xml 파일과 매핑 
@mapper 사용하기 위해서는 build.gradle() 아래 문장 추가
// https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter
implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3'
*/
@Mapper
public interface UserRepository {
    public List<UserVO> getAllList();
}

```

<h2>5. mapperMember.xml </h2>

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.bootmybatis.repository.UserRepository">
    <select id="getAllList" resultType="UserVO">
        select * from users
    </select>
</mapper>
```

<img src="/images/mybatis04.PNG">
<img src="/images/mybatis05.PNG">

<h2>6. UserRepositoryTest -> 테스트 코드 작성 </h2>

<img src="/images/mybatis06.PNG">

```java
package com.bootmybatis.repository;

import com.bootmybatis.vo.UserVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAllList(){
        List<UserVO> lists = userRepository.getAllList();

        lists.forEach(list-> log.info(list));
    }
}
```

<img src="/images/mybatis07.PNG">

<h2>7. 1건 데이타 조회 코드 </h2>
<img src="/images/mybatis08.PNG">

<h2>8. 수정하기 코드 </h2>
<img src="/images/mybatis09.PNG">