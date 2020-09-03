package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.SettingDao;
import com.example.demo.mapper.UserDao;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDao userDao;
    @Autowired
    private SettingDao settingDao;

    public void get(){
        List<User> users = userMapper.getAll();

    }

    @Transactional(rollbackFor = Exception.class)
    public void test() throws SQLException {
        userDao.update(2,"sqbcnki012345");
        settingDao.update(13,"test0123");
    }
}
