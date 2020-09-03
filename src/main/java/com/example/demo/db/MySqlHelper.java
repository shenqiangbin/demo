package com.example.demo.db;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class MySqlHelper {

    private DataSource dataSource;

    public MySqlHelper(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int add(String sql, Object[] params) throws SQLException {
        Connection connection = null;
        int result = -1;
        try {
            connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i] == null ? "" : params[i]);
                }
            }

            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet != null) {
                if (resultSet.next()) {
                    result = resultSet.getInt(1);
                }
            }

        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return result;
    }

    public int update(String sql, Object[] params) throws SQLException {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }

            return statement.executeUpdate();
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public String executeScalar(String sql, List<Object> params) throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    statement.setObject(i + 1, params.get(i));
                }
            }

            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                return resultSet.getString(1);
            }
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return "";
    }

    public void execute(String sql, List<Object> params) throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    statement.setObject(i + 1, params.get(i));
                }
            }

            statement.execute();
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
