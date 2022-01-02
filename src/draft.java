import dao.FileDao;
import dao.PostDao;
import entity.FileStore;
import entity.Post;

import java.util.List;

public class draft {
    public static void main(String[] args) throws Exception {//本类用于测试数据库连接
        /*String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver);
        String url="jdbc:sqlserver://localhost:1433; DatabaseName=ts";
        Connection con=DriverManager.getConnection(url,"sa","123456");
        System.out.println(con);

        AccountDao d=new AccountDao();
        Boolean t1=d.CheckAdmin(new Scanner(System.in).next(),new Scanner(System.in).next());
        System.out.println(t1);
        Boolean t2=d.CheckCustomer(new Scanner(System.in).next(),new Scanner(System.in).next());
        System.out.println(t2);*/
        String s1=null;
        String s2="dsj";
        String s3="dsj";
        if(s2.equals(s1)||s3!=null){
            System.out.println("1");
        }
    }
}
