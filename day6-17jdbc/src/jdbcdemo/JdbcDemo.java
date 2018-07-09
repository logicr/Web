package jdbcdemo;

import java.sql.*;

/**
 * @author  Jan
 */
public class JdbcDemo {
    public static void jdbcStep(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
//            加载类驱动
            Class.forName("com.mysql.jdbc.Driver");
//            连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?user=root&password=147258&useSSL = true");
//           创建命令
//            statement =connection.prepareStatement("select dname,loc from dept where  deptno = ?");
               statement =  connection.createStatement();
//           查询
            resultSet = statement.executeQuery("select dname,deptno from dept where  deptno = 1000");
            while (resultSet.next()){
                int deptno = resultSet.getInt("deptno");
                String dname = resultSet.getString("dname");
                System.out.println(deptno+","+dname);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != statement){
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
    public static void main(String[] args) {
        jdbcStep();
    }
}
