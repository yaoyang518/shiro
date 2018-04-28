package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author yaoyang
 * @Description:
 * @date 2018/4/28
 */
public interface UserRepository extends BaseRepository<User,Long>{

    User findByName(String name);

}
