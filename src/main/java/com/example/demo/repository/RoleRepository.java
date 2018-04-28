package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * @author yaoyang
 * @Description:
 * @date 2018/4/28
 */
public interface RoleRepository extends BaseRepository<Role,Long>{

}
