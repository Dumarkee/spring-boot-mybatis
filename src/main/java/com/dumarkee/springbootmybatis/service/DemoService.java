package com.dumarkee.springbootmybatis.service;

import com.dumarkee.springbootmybatis.Student;
import com.dumarkee.springbootmybatis.entity.UserVO;
import com.dumarkee.springbootmybatis.mapper.DemoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Description:
 * Copyright: winshare
 * Author: 杜威
 * Date: 2018-09-19
 * Time: 19:31
 */
@Service
public class DemoService {

    private final Logger logger = LoggerFactory.getLogger(DemoService.class);

    @Autowired
    private DemoMapper demoMapper;

    public List<Student> likeName(String name){
        return demoMapper.likeName(name);
    }

    public List<Student> listStudent(){
        return demoMapper.getAll();
    }

    @Transactional//添加事务.
    public void save(Student demo){
        demoMapper.save(demo);
    }

    @Cacheable(key = "'cache_user_id_' + #id", value = "userIdCache", cacheManager = "cacheManager")
    public UserVO get(long id) {
        logger.info("get by id from db");
        UserVO user = new UserVO();
        user.setId(id);
        user.setName("name" + id);
        user.setCreateTime(new Date());
        return user;
    }

    @Cacheable(key = "'cache_user_name_' + #name", value = "userNameCache", cacheManager = "cacheManager")
    public UserVO get(String name) {
        logger.info("get by name from db");
        UserVO user = new UserVO();
        user.setId(new Random().nextLong());
        user.setName(name);
        user.setCreateTime(new Date());
        return user;
    }

    @CachePut(key = "'cache_user_id_' + #userVO.id", value = "userIdCache", cacheManager = "cacheManager")
    public UserVO update(UserVO userVO) {
        logger.info("update to db");
        userVO.setCreateTime(new Date());
        return userVO;
    }

    @CacheEvict(key = "'cache_user_id_' + #id", value = "userIdCache", cacheManager = "cacheManager")
    public void delete(long id) {
        logger.info("delete from db");
    }
}
