package com.example.demo.mapper;

import com.example.demo.db.MySqlHelper;
import com.mysql.cj.jdbc.exceptions.MySQLTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class SettingDao {

    @Autowired
    private MySqlHelper mySqlHelper;

    public void update(int id, String name) throws SQLException {
        //throw new MySQLTimeoutException("abc");
        String sql = "update setting set name = ? where idsd = ?";
        mySqlHelper.update(sql, new Object[]{name, id});
    }
}
