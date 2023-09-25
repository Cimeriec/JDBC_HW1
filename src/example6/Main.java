package example6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/TestFromII";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        registerDriver();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            statement.addBatch("insert into testTable (name, age, address, phone) " +
                    "values ('Андрій', 25, 'Миру 1/1', '111111111')");
            statement.addBatch("insert into testTable (name, age, address, phone) " +
                    "values ('Сергій', 28, 'Правди 1/2', '222222222')");
            statement.addBatch("insert into testTable (name, age, address, phone) " +
                    "values ('Микола', 25, 'Свободи 1/1', '333333333')");
            statement.addBatch("insert into testTable (name, age, address, phone) " +
                    "values ('Анастасія', 25, 'Спаська 1/1', '444444444')");

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
