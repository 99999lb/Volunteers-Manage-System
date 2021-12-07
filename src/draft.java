import java.sql.*;

public class draft {
    public static void main(String[] args) throws Exception {//本类用于测试数据库连接
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver);
        String url="jdbc:sqlserver://localhost:1433; DatabaseName=ts";
        Connection con=DriverManager.getConnection(url,"sa","123456");
        System.out.println(con);
    }
}
