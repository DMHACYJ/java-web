package com.example.cs.service;

import com.example.cs.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    /**根据用户名、密码查询用户
     * @param userName
     * @return
     */
    User query(String userName,String password);
    List<User> findAllByUserNameLike(String userName);
    List<User> findAll();
    /**
     * 添加用户
     * @param user
     */
    void save(User user);

    /**
     * 修改用户
     * @param user
     */
    void update(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void delete(int id);
    /**
     * 通过ID查询
     */
    User findById(int id);
}
