package jdbc_tests;

import java.sql.*;


public class TestConnections {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@3.86.27.247:1521:XE";  //
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from regions");

        // move to the first row
        //     resultSet.next();

        // getting info with column name
        //   System.out.println(resultSet.getString("region_name"));

        // getting info with column name
        //      System.out.println("resultSet.getInt(1) = " + resultSet.getString(2));

        // print 1- Europe
        //       2 - Americas
        //       3 - Asia
        // System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

        // move to second row
//        resultSet.next();
//        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

//        resultSet.next();
//        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

        // printing with loop
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        }




        // close connection
        resultSet.close();
        statement.close();
        connection.close();
    }

}


