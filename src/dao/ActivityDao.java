package dao;

import DBHelper.SQLHelper;
import entity.ActMes;
import entity.Activity;
import entity.Acts;

import java.sql.ResultSet;
import java.util.ArrayList;

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

    public ArrayList<ActMes> queryActMes(String cid){//仅测试查询结果，未修改sql语句！！！
        ArrayList<ActMes> list =new ArrayList<>();

        ActMes actM=null;
        String sql="select ActMes.ActID,ActInfo.ActName,ActMes.CID, ActMes.StartTime,ActMes.EndTime,ActMes.Apoint from ActMes,ActInfo where CID='"+cid+"' and ActMes.ActID=ActInfo.ActID";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                actM=new ActMes(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),Float.parseFloat(rs.getString(6)));
                list.add(actM);
            }
        }catch(Exception e){}

        return list;
    }

    public ArrayList<Acts> queryActs(){//仅测试查询结果，未修改sql语句！！！
        ArrayList<Acts> list =new ArrayList<>();
        Acts acts=null;
        String sql="select Acts.CID,Acts.ActID,ActInfo.ActName,Acts.YON from Acts,ActInfo where YON='"+"Y"+"' and Acts.ActID=ActInfo.ActID";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                acts=new Acts(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                list.add(acts);
            }
        }catch(Exception e){}

        return list;
    }

    public String checkYON(String s){
        String result=null;
        if(("Y".trim()).equals(s)){
            result="已完成";
        }
        if(("N".trim()).equals(s)){
            result="未完成";
        }
        return result;
    }


}
