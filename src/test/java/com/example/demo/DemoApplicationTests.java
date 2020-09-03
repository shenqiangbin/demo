package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.SettingDao;
import com.example.demo.mapper.UserDao;
import com.example.demo.service.UserService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@SpringBootTest
@EnableTransactionManagement
class DemoApplicationTests {

	@Autowired
	private DataSource ds;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SettingDao settingDao;
	@Autowired
	private UserService userService;

	//https://blog.csdn.net/weixin_40001125/article/details/88538576
	//https://blog.csdn.net/weixin_40001125/article/details/88538576
	//https://www.liaoxuefeng.com/article/1127277451217344

	/*
	mybatis 配置多个数据源
	https://blog.51cto.com/zero01/2161509
	https://www.cnblogs.com/expiator/p/9213912.html

	https://blog.51cto.com/zero01/2161509
	* */

	@Test
	void contextLoads() throws SQLException, ClassNotFoundException {
//		String str = ((HikariDataSource) ds).getJdbcUrl();
//		System.out.println(str);
//
//
//		List<User> list =  jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));
//
//
//		DataSource ds = getConnection();
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
//		jdbcTemplate.query();
//
//		System.out.println(list.size());

		userService.test();
	}

	 //Connection getConnection() throws ClassNotFoundException, SQLException {
//		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//		String DB_URL = "jdbc:mysql://10.170.128.56:3306/tablebigdata?useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
//		String USER = "";
//		String PASS = "";
//
//		Class.forName(JDBC_DRIVER);
//		return DriverManager.getConnection(DB_URL,USER,PASS);

//		HikariConfig config = new HikariConfig();
//		 config.setJdbcUrl();
//		 config.setDriverClassName();
//		 config.setUsername();
//		 config.setPassword();
//		return new HikariDataSource(config);
	//}

}
