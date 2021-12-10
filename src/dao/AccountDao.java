package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.SQLHelper;

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

    public void addCustomer(String cid,String cname,String sex,String sig,String phone,String cpwd){
        String sql="insert into customers values('"+cid+"','"+cname+"','"+sex+"','"+sig+"','"+phone+"','"+cpwd+"')";
        SQLHelper.executeUpdate(sql);
    }
}
