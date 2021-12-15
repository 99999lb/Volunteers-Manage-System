import dao.AccountDao;
import dao.CustomerDao;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class draft {
    public static void main(String[] args) throws Exception {//本类用于测试数据库连接
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver);
        String url="jdbc:sqlserver://localhost:1433; DatabaseName=ts";
        Connection con=DriverManager.getConnection(url,"sa","123456");
        System.out.println(con);

        CustomerDao d=new CustomerDao();
        ArrayList<Customer> list=d.queryCustomerByPass();
        Customer c=new Customer();
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            c=list.get(i);
            System.out.println(c.getCid()+" "+c.getCname()+" "+c.getSex()+" "+c.getPhone()+" "
                    +c.getSig()+" "+c.getAddress()+" "+c.getPass()+" "+c.getCsort());
        }
    }
}
