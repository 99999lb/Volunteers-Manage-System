package dao;

import DBHelper.SQLHelper;
import entity.Activity;
import entity.JoinActs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JoinActsDao {
    public Boolean JoinAct(String cid,String actid) throws SQLException {
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("insert into ActJoin values('"+actid+"','"+cid+"','N','')");
        if (rs!=0)
            flag=true;
        return flag;
    }

    public ArrayList<JoinActs> JoinActivitiesByID(String cid){
        ArrayList<JoinActs> list =new ArrayList<>();

        JoinActs act=null;
        String sql="select * from ActInfo,ActJoin where ActInfo.ActID=ActJoin.AcTID and ActJoin.CID='"+cid+"'";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                act=new JoinActs(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(16),rs.getString(17));
                list.add(act);
            }
        }catch(Exception e){}

        return list;
    }
}
