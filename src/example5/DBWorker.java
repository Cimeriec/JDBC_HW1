package example5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/myjoinsdb";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public DBWorker() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Res1> getAllRes1() {
        Connection connection = null;
        Statement statement = null;
        List<Res1> res1List = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select name, phone, address from employees " +
                    "join family where employees.id=family.employee_id");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Res1 res1 = new Res1(name, phone, address);
                res1List.add(res1);
            }
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
        return res1List;
    }

    public List<Res2> getAllRes2() {
        Connection connection = null;
        Statement statement = null;
        List<Res2> res2List = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select name, birth, phone from employees " +
                    "join family on employees.id=family.employee_id where marital_status='не одружений'");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("birth");
                String phone = resultSet.getString("phone");
                Res2 res2 = new Res2(name, date, phone);
                res2List.add(res2);
            }
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
        return res2List;
    }

    public List<Res3> getAllRes3() {
        Connection connection = null;
        Statement statement = null;
        List<Res3> res3List = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select name, birth, phone from employees " +
                    "join family on employees.id=family.employee_id join job on employees.id=job.employee_id " +
                    "where job_title='менеджер'");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("birth");
                String phone = resultSet.getString("phone");
                Res3 res3 = new Res3(name, date, phone);
                res3List.add(res3);
            }
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
        return res3List;
    }
}
