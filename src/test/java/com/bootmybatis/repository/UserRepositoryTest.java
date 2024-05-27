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