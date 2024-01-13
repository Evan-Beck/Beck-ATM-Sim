package db_objs;

import com.mysql.cj.jdbc.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;



public class MyJDBC {
    private static final String DB_URL ="jdbc:mysql://127.0.0.1:3306/bankingapp";
    private static final String DB_USERNAME ="root";
    private static final String DB_PASSWORD = "rootroot";

    public static User validateLogin(String username, String password) {
        try {

            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password = ?"
            );

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");

                BigDecimal currentBalance = resultSet.getBigDecimal("current_balance");

                return new User(userId, username, password, currentBalance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean register(String username, String password) {
        try{
            if(!checkUser(username)){
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users(username, password) " +
                                "VALUES(?, ?)"
                );
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                preparedStatement.executeUpdate();
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();

        }
        return false;
    }
    private static boolean checkUser(String username){
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                return false;
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
