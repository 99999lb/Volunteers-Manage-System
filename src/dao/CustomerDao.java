package dao;

import DBHelper.SQLHelper;
import entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
    //个人信息页面修改信息
    public Boolean updateCInfo(String cid,String cname,String sex,String sig,String phone,String address,String pass,String csort) throws SQLException {
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("UPDATE CInfo SET CName='"+cname+"'," +
                "Sex='"+sex+"',Sig='"+sig+"',Phone='"+phone+"',Address='"+address+"',Pass='"+pass+"'," +
                "Csort='"+csort+"' where CID='"+cid+"'");
        if (rs!=0)
            flag=true;
        return flag;
    }

    public Customer queryCustomerByID(String cid){
        Customer cus=null;
        String sql="select * from CInfo where CID='"+cid+"'";
        ResultSet rs=SQLHelper.executeQuery(sql);
        try{
            if(rs!=null&&rs.next()){
                cus=new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                                rs.getString(5),rs.getString(8),rs.getString(6),rs.getString(7));
            }
        }catch(Exception e){}
        return cus;
    }

    public String checkSort(String s){
        String result=null;
        if(("P".trim()).equals(s)){
            result="个人";
        }
        if(("C".trim()).equals(s)){
            result="团队";
        }
        return result;
    }

    public String checkPass(String p){
        String result=null;
        if("Y".trim().equals(p)){
            result="正常";
        }
        else{
            result="待审核";
        }
        return result;
    }


}
