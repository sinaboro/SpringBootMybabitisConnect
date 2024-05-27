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
