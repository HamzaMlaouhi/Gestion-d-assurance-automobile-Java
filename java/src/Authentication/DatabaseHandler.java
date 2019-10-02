package Authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.xml.bind.DatatypeConverter;

public class DatabaseHandler {

    public static Connection GetDatabaseConnection() {
        Connection connection = null;
//    Connection connection;

        String dbUrl = "jdbc:mysql://localhost:3306/assurance";
        String user = "root";
        String pass = "";
        try {
//            driver setup for database
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, user, pass);

            System.out.println("connection successful 12345");
        } catch (ClassNotFoundException e) {
            e.getLocalizedMessage();
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getLocalizedMessage();
        }

        return connection;
    }

    public ResultSet CheckLoginUser(String uname, String pass) throws NoSuchAlgorithmException { //get input from login system module
        Connection connection = GetDatabaseConnection();
        String checkQuery = "select * from user where username = ? and password = ? ";

        PreparedStatement preparedStatement = null;
        boolean status = false; //initially false
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
          .printHexBinary(digest).toUpperCase();
        System.out.println(myHash);
        try {
            preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setString(1, uname); // dynamically sending username
            preparedStatement.setString(2, myHash); // sending password to checkquery statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //status = resultSet.next();
            //preparedStatement.close();
            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
