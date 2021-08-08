package jdbc_tests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DB_Util_Practice {

    @Test
    public void test1() {
        DBUtils.createConnection();
        String query = "select first_name, last_name, job_id, salary\n" +
                "from employees";
        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

        for (Map<String, Object> row : queryData) {
            System.out.println(row);

        }
        DBUtils.destroy();

    }

    @Test
    public void test2() {
        //create connection
        DBUtils.createConnection();
        String query = "SELECT first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum <2";

        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        System.out.println(rowMap.toString());

        //close the connection
        DBUtils.destroy();

    }
}