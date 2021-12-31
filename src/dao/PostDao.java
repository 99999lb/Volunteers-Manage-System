package dao;

import DBHelper.SQLHelper;
import entity.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDao {
    public ArrayList<Post> queryPostByPass(){//仅测试查询结果，未修改sql语句！！！
        ArrayList<Post> list =new ArrayList<>();
        Post p=null;
        String sql="select * from Post where Pass='"+"Y"+"'";// where Pass='"+"N"+"'
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                p=new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),Integer.parseInt(rs.getString(6)));
                list.add(p);
            }
        }catch(Exception e){}

        return list;
    }

    public Post queryPostByTID(int tid){
        Post p=null;
        String sql="select * from Post where TID='"+tid+"'";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            if(rs!=null&&rs.next()){
                p=new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),Integer.parseInt(rs.getString(6)));
            }

        }catch(Exception e){}
        return p;
    }

    public Boolean addPost(String cid,String cname,String title,String tText) throws SQLException {
        Boolean flag=false;
        int rs=SQLHelper.executeUpdate("insert into Post(CID,CName,Title,Ttext) values('"+cid+"','"+cname+"','"+title+"','"+tText+"')");
        if (rs!=0)
            flag=true;
        return flag;
    }

    public Boolean deletePost(String tid) throws SQLException {
        Boolean flag=false;
        int rs=SQLHelper.executeUpdate("delete from Post where TID='"+tid+"'");
        if (rs!=0)
            flag=true;
        return flag;
    }

    public void createPage(){

    }

    public ArrayList<Post> queryPostCheck(){
        ArrayList<Post> plist =new ArrayList<>();
        Post p=null;
        String sql="select * from Post where Pass='N'";
        ResultSet rs= SQLHelper.executeQuery(sql);
        try{
            while (rs.next()){
                p=new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),Integer.parseInt(rs.getString(6)));
                plist.add(p);
            }
        }catch(Exception e){}

        return plist;
    }

    public boolean passPostMessage(String tid){
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("UPDATE Post SET Pass='Y' where TID='"+tid+"'");

        if (rs!=0)
            flag=true;
        return flag;
    }

    public boolean noPassPostMessage(String tid){
        Boolean flag=false;
        int rs= SQLHelper.executeUpdate("UPDATE Post SET Pass='E' where TID='"+tid+"'");

        if (rs!=0)
            flag=true;
        return flag;
    }
}

