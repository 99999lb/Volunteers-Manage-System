package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLHelper {
    private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url="jdbc:sqlserver://localhost:1433; DatabaseName=ts";
    private static String user="sa",pwd="123456";
    private static Connection con;

    static {
        try{
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();//抛出异常并打印
        }
    }

    public static void executeUpdate(String sql){//增删改
        try {
            con=DriverManager.getConnection(url,user,pwd);
            Statement cmd=con.createStatement();
            cmd.executeUpdate(sql);
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String sql){//查询
        ResultSet rs=null;
        try {
            con=DriverManager.getConnection(url,user,pwd);
            Statement cmd=con.createStatement();
            rs=cmd.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeConnection(){
        try{
            if(con!=null)
                con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
