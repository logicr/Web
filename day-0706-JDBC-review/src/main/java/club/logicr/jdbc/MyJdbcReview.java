package club.logicr.jdbc;

import java.sql.*;

/**
 * @author Jan
 */
public class MyJdbcReview {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSttet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?user=root&password=147258&useSSL = true");

            statement = connection.createStatement();
            resultSttet = statement.executeQuery(
                    "select * from dept"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (resultSttet.next()) {
            Integer deptno = resultSttet.getInt("deptno");
            String dname = resultSttet.getString("dname");
            String loc = resultSttet.getString("loc");
            System.out.println(deptno + ", " + dname + ", " + loc);
        }
        /*  关闭结果集*/
        if (null != resultSttet){
            try {
                resultSttet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /*  */
        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
