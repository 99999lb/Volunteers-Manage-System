package dao;

import DBHelper.SQLHelper;
import entity.Reply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyDao {
    public ArrayList<Reply> queryReply(int t){//仅测试查询结果，未修改sql语句！！！
        ArrayList<Reply> rlist =new ArrayList<>();

        Reply r=null;
        String sql="select * from Reply where TID='"+t+"'";//
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                    r=new Reply(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),
                        Integer.parseInt(rs.getString(5)));
                rlist.add(r);
            }
        }catch(Exception e){}

        return rlist;
    }

    public Boolean addReply(int tid,String cid,String cname,String rep) throws SQLException {
        Boolean flag=false;
        int rs=SQLHelper.executeUpdate("insert into Reply(TID,CID,CName,Rep) values('"+tid+"','"+cid+"','"+cname+"','"+rep+"')");
        if (rs!=0)
            flag=true;
        return flag;
    }

    public Boolean deleteReply(String rid) throws SQLException {
        Boolean flag=false;
        int rs=SQLHelper.executeUpdate("delete from Reply where RID='"+rid+"'");
        if (rs!=0)
            flag=true;
        return flag;
    }

}
