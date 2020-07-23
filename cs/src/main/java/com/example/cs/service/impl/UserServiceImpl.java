package com.example.cs.service.impl;

import com.example.cs.entity.User;
import com.example.cs.repository.UserRepository;
import com.example.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 根据用户名、密码查询用户
     * @param userName
     * @return
     */
    @Override
    public User query(String userName,String password) {
        return userRepository.findByUserNameAndPassword(userName,password);
    }

    @Override
    public List<User> findAllByUserNameLike(String userName) {
        return userRepository.findAllByUserNameLike("%"+userName+"%");
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 保存用户
     * @param user
     */
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * 修改用户
     */
    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(null);
    }
}
