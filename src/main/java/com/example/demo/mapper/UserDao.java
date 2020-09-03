package com.example.demo.mapper;

import com.example.demo.db.MySqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UserDao {

    @Autowired
    private MySqlHelper mySqlHelper;

    public void update(int id, String name) throws SQLException {
        String sql = "update user set username = ? where userId = ?";
        mySqlHelper.update(sql, new Object[]{name, id});
    }
}
