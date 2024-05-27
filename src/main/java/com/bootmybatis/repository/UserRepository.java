package com.bootmybatis.repository;

import com.bootmybatis.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    public List<UserVO> getAllList();

    public int updateUser(UserVO user);
    public int insertUser();

    public int deleteUser();

    public UserVO getOneUser(int userNo);
}
