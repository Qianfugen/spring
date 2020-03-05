import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        //3.获得操作数据库的预处理对象
        PreparedStatement preparedStatement = conn.prepareStatement("Select * from account");
        //4.执行sql，得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //5.遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        conn.close();
    }
}
