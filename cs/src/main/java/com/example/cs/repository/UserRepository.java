package com.example.cs.repository;

import com.example.cs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    /**
     * 根据用户名、密码查询用户
     * @param userName
     * @return
     */
    User findByUserNameAndPassword(String userName,String password);

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    List<User> findAllByUserNameLike(String userName);

}
