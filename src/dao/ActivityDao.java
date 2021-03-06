package dao;

import DBHelper.SQLHelper;
import entity.Activity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActivityDao {
    public ArrayList<Activity> queryActivityByPass(){
        ArrayList<Activity> list =new ArrayList<>();

        Activity act=null;
        String sql="select * from ActInfo where Pass='N'";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                act=new Activity(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
                list.add(act);
            }
        }catch(Exception e){}

        return list;
    }

    public ArrayList<Activity> AllPassActivities(){
        ArrayList<Activity> list =new ArrayList<>();

        Activity act=null;
        String sql="select * from ActInfo,ActCreate where ActInfo.ActID=ActCreate.ActID and fin='N'";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                act=new Activity(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
                list.add(act);
            }
        }catch(Exception e){}

        return list;
    }

    public boolean FinAct(String aid){
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("UPDATE ActCreate SET fin='Y' where ActID='"+aid+"'");

        if (rs!=0)
            flag=true;
        return flag;
    }

    public boolean CheckFinAct(String aid) throws SQLException {
        Boolean flag=false;
        ResultSet rs= SQLHelper.executeQuery("select fin from ActInfo,ActCreate where ActInfo.ActID=ActCreate.ActID and ActCreate.ActID='"+aid+"'");

        while (rs.next()){
            String fin=rs.getString(1);
            System.out.println(fin.trim().equals("Y"));
            if(fin.trim().equals("Y"))
                flag=true;
        }
        return flag;
    }

    public ArrayList<Activity> FindActivitiesByCID(String cid){
        ArrayList<Activity> list =new ArrayList<>();

        Activity act=null;
        String sql="select * from ActInfo where CID='"+cid+"'";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                act=new Activity(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
                list.add(act);
            }
        }catch(Exception e){}

        return list;
    }

    public boolean addActivity(Activity a) throws ParseException {
        Boolean flag=false;

        float dur= Float.parseFloat(a.getDuration());
        int peonum= Integer.parseInt(a.getPeoNum());
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm");

        String[] time=a.getStartTime().split("T");
        String s0="";
        for(int i=0;i<time.length;i++){
            s0+=time[i];
            s0+=" ";
        }
        time=a.getEndTime().split("T");
        String e0="";
        for(int i=0;i<time.length;i++){
            e0+=time[i];
            e0+=" ";
        }
        time=a.getrStartTime().split("T");
        String rs0="";
        for(int i=0;i<time.length;i++){
            rs0+=time[i];
            rs0+=" ";
        }
        time=a.getrEndTime().split("T");
        String re0="";
        for(int i=0;i<time.length;i++){
            re0+=time[i];
            re0+=" ";
        }

        Date s=df.parse(s0);//Util.Date?????????
        Date e=df.parse(e0);
        Date rs=df.parse(rs0);
        Date re=df.parse(re0);

        Timestamp st=new Timestamp(s.getTime());//sql.Date?????????
        Timestamp et=new Timestamp(e.getTime());
        Timestamp rst=new Timestamp(rs.getTime());
        Timestamp ret=new Timestamp(re.getTime());

        int result= SQLHelper.executeUpdate("insert into ActInfo values('"+a.getCID()+"','"+a.getActID()+"','"+a.getActName()+"','"+a.getSort()+"','"+
                    a.getPlace()+"','"+st+"','"+et+"','"+rst+"','"+ret+"','"+dur+"','"+peonum+"','"+a.getActBrif()+"','N')");
        if (result!=0)
            flag=true;


        return flag;
    }

    public boolean passACTMessage(String aid){
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("UPDATE ActInfo SET Pass='Y' where ActID='"+aid+"'");

        if (rs!=0)
            flag=true;
        return flag;
    }

    public boolean noPassACTMessage(String aid){
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("UPDATE ActInfo SET Pass='E' where ActID='"+aid+"'");

        if (rs!=0)
            flag=true;
        return flag;
    }

    public boolean DeleteActByID(String aid){
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("delete from ActInfo where ActID='"+aid+"'");

        if (rs!=0)
            flag=true;
        return flag;
    }

    public String checkYON(String s){
        String result=null;
        if(("Y".trim()).equals(s)){
            result="?????????";
        }
        if(("N".trim()).equals(s)){
            result="?????????";
        }
        return result;
    }


}
