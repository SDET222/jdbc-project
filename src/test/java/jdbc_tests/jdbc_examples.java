package jdbc_tests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {
    String dbUrl = "jdbc:oracle:thin:@3.86.27.247:1521:XE";  // 34.239.124.255
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from departments");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2)
                    + " - " + resultSet.getString(3) + " - " + resultSet.getString(4));
        }
    }

    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * from departments");

        //how to find how many rows we have for the query

        int count = 0;
        while (resultSet.next()) {

            resultSet.getRow();

            count++;
        }

        System.out.println("Rows = " + count);

        resultSet.last();
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);

        //print all second column info
        resultSet.beforeFirst();
        while(resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }


        resultSet.close();
        statement.close();
        connection.close();



    }
    @Test
    public void test3() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * from departments");

        //get the database related data inside the dbmetadata object

        DatabaseMetaData dbMetaData = connection.getMetaData();

        System.out.println("dbMetaData.getUserName() = " + dbMetaData.getUserName());
        System.out.println("dbMetaData.getDatabaseProductName() = " + dbMetaData.getDatabaseProductName());
        System.out.println("dbMetaData.getDatabaseProductVersion() = " + dbMetaData.getDatabaseProductVersion());
        System.out.println("dbMetaData.getDriverName() = " + dbMetaData.getDriverName());


        //get the resultSetMetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();

        int colCount = rsmd.getColumnCount();
        System.out.println("colCount = " + colCount);

        //getting column name
        System.out.println("rsmd.getColumnName(1) = " + rsmd.getColumnName(1));

        //print all the column names dynamically
        System.out.println("===============================================");

        for (int i = 1; i <= colCount; i++) {
            System.out.println(rsmd.getColumnName(i));
        }


        resultSet.close();
        statement.close();
        connection.close();

    }




}



