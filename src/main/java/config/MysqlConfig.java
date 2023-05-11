package config;

import java.sql.*;

import static java.lang.Class.forName;

public class MysqlConfig {
    String database = "develop";
    String user = "root";
    String password = "";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/" + database +"?user=" + user + "&password=" + password;

        return DriverManager.getConnection(url);
    }

    public ResultSet getResultSet (CallableStatement callableStatement) throws SQLException {
        return callableStatement.executeQuery();
    }
}
