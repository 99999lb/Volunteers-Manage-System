package dao;

import DBHelper.SQLHelper;
import entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao {
    //个人信息页面修改信息
    public Boolean updateCInfo(Customer rc) throws SQLException {
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("UPDATE CInfo SET CName='"+rc.getCname()+"'," +
                "Sex='"+rc.getSex()+"',Sig='"+rc.getSig()+"',Phone='"+rc.getPhone()+"',Address='"+rc.getAddress()+"',Pass='"+rc.getPass()+"'," +
                "Csort='"+rc.getCsort()+"' where CID='"+rc.getCid()+"'");

        if (rs!=0)
            flag=true;
        return flag;
    }

    //通过用户id查找用户信息
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

    public ArrayList queryCustomerByPass(){
        ArrayList<Customer> list =new ArrayList<>();

        Customer cus=null;
        String sql="select * from CInfo where Pass='N'";
        ResultSet rs=SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                cus=new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(8),rs.getString(6),rs.getString(7));
                list.add(cus);
            }
        }catch(Exception e){}

        return list;
    }

    public boolean passIDMessage(String id){
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("UPDATE CInfo SET Pass='Y' where CID='"+id+"'");

        if (rs!=0)
            flag=true;
        return flag;
    }

    public boolean noPassIDMessage(String id){
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("UPDATE CInfo SET Pass='E' where CID='"+id+"'");

        if (rs!=0)
            flag=true;
        return flag;
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
        else if("N".trim().equals(p)){
            result="信息修改已提交，待审核";
        }
        else if("E".trim().equals(p))
        {
            result="审核未通过！请修改信息后再次尝试";
        }
        return result;
    }

    public Customer queryCustomerByCID(String cid){
        Customer c=null;
        String sql="select CID,CName from CInfo where CID='"+cid+"'";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            if(rs!=null&&rs.next()){
                c=new Customer(rs.getString(1),rs.getString(2));
            }

        }catch(Exception e){}
        return c;
    }

}
