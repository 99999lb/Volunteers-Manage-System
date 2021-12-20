package dao;

import DBHelper.SQLHelper;
import entity.Activity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    public ArrayList<Activity> queryActivityByPass(){//仅测试查询结果，未修改sql语句！！！
        ArrayList<Activity> list =new ArrayList<>();

        Activity act=null;
        String sql="select * from ActInfo where Pass='"+"N"+"'";// where Pass='"+"N"+"'
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                act=new Activity(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
                list.add(act);
            }
        }catch(Exception e){}

        return list;
    }
}
