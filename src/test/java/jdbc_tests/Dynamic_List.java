package jdbc_tests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class Dynamic_List {

    String dbUrl = "jdbc:oracle:thin:@44.195.19.167:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from departments\n" );



        //in order to get column names we need resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();


        //list of maps to keep all information

        List<Map<String,Object>> queryData = new ArrayList<>();

        int columnCount = rsmd.getColumnCount();

        //loop through each row
        while(resultSet.next()){
            Map<String,Object> row = new LinkedHashMap<>();

            for (int i = 1; i <= columnCount; i++) {
                row.put(rsmd.getColumnName(i),resultSet.getObject(i));

            }

            //add ready map row to the list
            queryData.add(row);
        }

        for (Map<String, Object> row : queryData) {
            System.out.println(row);
        }

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }


}
