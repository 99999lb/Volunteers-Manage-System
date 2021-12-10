package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import DBHelper.SQLHelper;

public class AccountDao {
    public Boolean CheckAdmin(String id,String pwd) throws SQLException {
        Boolean flag=false;
        ResultSet rs=SQLHelper.executeQuery("select * from Admin where AID='"+id+"'and pwd='"+pwd+"'");
        if (rs.next())//结果集的第一条项目不为空，即查询到项目
            flag=true;

        return flag;
    }

    public Boolean CheckCustomer(String id,String pwd) throws SQLException {
        Boolean flag=false;
        ResultSet rs=SQLHelper.executeQuery("select * from Customer where CID='"+id+"'and pwd='"+pwd+"'");
        if (rs.next())
            flag=true;

        return flag;
    }
}
