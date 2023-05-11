import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import config.MysqlConfig;

public class main {


    public static void main (String[] args) throws SQLException, ClassNotFoundException {

        deleteSp();
    }

    public static void deleteSp() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese ciudad");
        String InputEliminar = scanner.nextLine();

        MysqlConfig config= new MysqlConfig();

        String sqlToCallSp = "{call delete_by_ciudades (?)}";

        Connection connection = config.getConnection();

        CallableStatement  callableStatement = connection.prepareCall(sqlToCallSp);
        callableStatement.setString(1, InputEliminar);

       int rs= callableStatement.executeUpdate();

        System.out.println(rs+ "ha sido eliminado");

    }

}
